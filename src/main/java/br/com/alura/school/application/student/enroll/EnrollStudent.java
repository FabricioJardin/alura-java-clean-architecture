package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.StudentRepository;

public class EnrollStudent {
    private final StudentRepository studentRepository;

    public EnrollStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // COMMAND
    public void execute(EnrollStudentDto enrollStudentDto) {
        studentRepository.enroll(enrollStudentDto.buildStudent());
    }
}
