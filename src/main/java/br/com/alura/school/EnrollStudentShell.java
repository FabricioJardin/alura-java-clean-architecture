package br.com.alura.school;

import br.com.alura.school.application.student.enroll.EnrollStudent;
import br.com.alura.school.application.student.enroll.EnrollStudentDto;
import br.com.alura.school.infra.student.StudentRepositoryMemory;

public class EnrollStudentShell {
    public static void main(String[] args) {
        String name = "Fulano da Silva";
        String documentNumber = "123.456.789-00";
        String email = "fulano@email.com";

        EnrollStudent enrollStudent = new EnrollStudent(new StudentRepositoryMemory());
        enrollStudent.execute(new EnrollStudentDto(name, documentNumber, email));
    }
}
