package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.DocumentNumber;
import br.com.alura.school.domain.student.Student;
import br.com.alura.school.domain.student.StudentRepository;
import br.com.alura.school.infra.student.StudentRepositoryMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnrollStudentTest {
    @Test
    void studentShouldPersist() {
        StudentRepository repository = new StudentRepositoryMemory();
        EnrollStudent useCase = new EnrollStudent(repository);

        String nameString = "Fulano";
        String documentString = "123.456.789-00";
        String emailString = "fulano@email.com";

        EnrollStudentDto enrollStudentDto = new EnrollStudentDto(
                nameString,
                documentString,
                emailString
        );

        useCase.execute(enrollStudentDto);

        Student student = repository.findByDocumentNumber(new DocumentNumber(documentString));

        assertEquals(nameString, student.getName());
        assertEquals(documentString, student.getDocumentNumber());
        assertEquals(emailString, student.getEmail());
    }
}