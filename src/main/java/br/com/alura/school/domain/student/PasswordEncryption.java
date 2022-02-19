package br.com.alura.school.domain.student;

public interface PasswordEncryption {
    String encrypt(String password);

    boolean validateEncryption(String passwordEncrypted, String password);
}
