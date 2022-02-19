package br.com.alura.school.student;

import br.com.alura.school.domain.student.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldNotCreateEmailWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("invalid"));
    }

    @Test
    void shouldCreateEmailWithValidAddress() {
        String address = "fabricio@gmail.com";

        Email email = new Email(address);

        assertEquals(address, email.getAddress());
    }
}