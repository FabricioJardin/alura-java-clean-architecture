package br.com.alura.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;

    private DocumentNumber documentNumber;
    private Email email;

    private List<Phone> phones = new ArrayList<>();

    private String password;

    public Student(String name, DocumentNumber documentNumber, Email email) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
    }

    public Student addPhone(String areaCode, String number) {
        this.phones.add(new Phone(areaCode, number));
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDocumentNumber() {
        return documentNumber.getValue();
    }

    public String getEmail() {
        return email.getAddress();
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
