package br.com.alura.school.student;

import br.com.alura.school.domain.student.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    @Test
    void shouldNotCreatePhoneWithInvalidAreaCode() {
        assertThrows(IllegalArgumentException.class, () -> new Phone(null, "999999999"));
        assertThrows(IllegalArgumentException.class, () -> new Phone("", "999999999"));
        assertThrows(IllegalArgumentException.class, () -> new Phone("invalid","999999999"));
    }

    @Test
    void shouldNotCreatePhoneWithInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("51", null));
        assertThrows(IllegalArgumentException.class, () -> new Phone("51", ""));
        assertThrows(IllegalArgumentException.class, () -> new Phone("51","invalid"));
    }

    @Test
    void shouldCreatePhoneWithValidAreaCodeAndNumber() {
        String areaCode = "51";
        String phoneNumber = "999999999";

        Phone phone = new Phone("51", "999999999");

        assertEquals(areaCode, phone.getAreaCode());
        assertEquals(phoneNumber, phone.getNumber());
    }
}