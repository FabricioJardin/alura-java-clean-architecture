package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.PasswordEncryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptionMD5 implements PasswordEncryption {
    @Override
    public String encrypt(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();

            for (byte aByte : bytes) {
                stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error on generate hash");
        }
    }

    @Override
    public boolean validateEncryption(String passwordEncrypted, String password) {
        return passwordEncrypted.equals(encrypt(password));
    }
}
