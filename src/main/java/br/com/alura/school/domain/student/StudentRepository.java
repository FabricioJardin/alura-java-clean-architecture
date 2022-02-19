package br.com.alura.school.domain.student;

import java.util.List;

public interface StudentRepository {
    void enroll(Student student);

    Student findByDocumentNumber(DocumentNumber documentNumber) throws StudentNotFoundException;

    List<Student> getAll();
}
