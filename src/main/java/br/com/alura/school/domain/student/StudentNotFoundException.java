package br.com.alura.school.domain.student;

public class StudentNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public StudentNotFoundException(DocumentNumber documentNumber) {
        super("Student with document number " + documentNumber + " was not found");
    }
}
