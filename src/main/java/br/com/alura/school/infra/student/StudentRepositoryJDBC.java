package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJDBC implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        try {
            this.saveStudent(student);
            this.savePhones(student.getPhones());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private void saveStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getDocumentNumber());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getEmail());

        preparedStatement.execute();
    }

    private void savePhones(List<Phone> phones) throws SQLException {
        String sql = "INSERT INTO phone VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (Phone phone : phones) {
            preparedStatement.setString(1, phone.getAreaCode());
            preparedStatement.setString(2, phone.getNumber());
            preparedStatement.execute();
        }
    }

    @Override
    public Student findByDocumentNumber(DocumentNumber documentNumber) {
        try {
            String sql = "SELECT id, name, email FROM student WHERE document_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, documentNumber.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean exists = resultSet.next();

            if (!exists)
                throw new StudentNotFoundException(documentNumber);

            String name = resultSet.getString("name");
            Email email = new Email(resultSet.getString("email"));
            Student student = new Student(name, documentNumber, email);

            Long id = resultSet.getLong("id");

            this.fillPhones(student, id);

            return student;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void fillPhones(Student student, Long id) throws SQLException {
        String sql = "SELECT area_code, number FROM phone WHERE student_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String number = resultSet.getString("number");
            String areaCode = resultSet.getString("area_code");
            student.addPhone(areaCode, number);
        }
    }

    @Override
    public List<Student> getAll() {
        try {
            String sql = "SELECT id, name, document_number, email FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> results = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Email email = new Email(resultSet.getString("email"));
                DocumentNumber documentNumber = new DocumentNumber(resultSet.getString("document_number"));
                Student student = new Student(name, documentNumber, email);
                Long id = resultSet.getLong("id");

                this.fillPhones(student, id);

                results.add(student);
            }

            return results;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
