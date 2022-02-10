package br.com.alura.school.student;

public class Phone {
    private String areaCode;
    private String number;

    public Phone(String areaCode, String number) {
        if (areaCode == null || number == null)
            throw new IllegalArgumentException("Area code and phone number are required!");

        if (!areaCode.matches("\\d{2}"))
            throw new IllegalArgumentException("Area code is invalid");

        if (!number.matches("\\d{8}|\\d{9}"))
            throw new IllegalArgumentException("Phone number is invalid");

        this.areaCode = areaCode;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }
}
