package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.DocumentNumber;
import br.com.alura.school.domain.student.Student;
import br.com.alura.school.domain.student.StudentNotFoundException;
import br.com.alura.school.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryMemory implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.students.add(student);
    }

    @Override
    public Student findByDocumentNumber(DocumentNumber documentNumber) {
        return this.students.stream()
                .filter(student -> student.getDocumentNumber().equals(documentNumber.getValue()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(documentNumber));
    }

    @Override
    public List<Student> getAll() {
        return this.students;
    }
}
