package br.com.alura.school.student;

public class Email {
    private String address;

    public Email(String address) {
        if (address == null ||
                !address.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid Email");
        }

        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
