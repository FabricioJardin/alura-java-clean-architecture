package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.DocumentNumber;
import br.com.alura.school.domain.student.Email;
import br.com.alura.school.domain.student.Student;

public class EnrollStudentDto {
    private final String name;
    private final String documentNumber;
    private final String email;

    public EnrollStudentDto(String name, String documentNumber, String email) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
    }

    public Student buildStudent() {
        return new Student(name, new DocumentNumber(documentNumber), new Email(email));
    }
}
