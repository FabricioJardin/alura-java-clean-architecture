package school;

import java.time.LocalDateTime;

public class Recommendation {

    private Student studentFrom;
    private Student studentTo;
    private LocalDateTime createdAt;

    public Recommendation(Student studentFrom, Student studentTo) {
        this.studentFrom = studentFrom;
        this.studentTo = studentTo;
        this.createdAt = LocalDateTime.now();
    }

    public Student getStudentFrom() {
        return studentFrom;
    }

    public Student getStudentTo() {
        return studentTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
