package br.com.alura.school.student;

public class StudentBuilder {
    private Student student;

    public StudentBuilder withNameAndDocumentAndEmail(String name, String documentNumber, String email) {
        this.student = new Student(name, new DocumentNumber(documentNumber), new Email(email));
        return this;
    }

    public StudentBuilder withPhone(String areaCode, String number) {
        this.student.addPhone(areaCode, number);
        return this;
    }

    public Student build() {
        return this.student;
    }
}
