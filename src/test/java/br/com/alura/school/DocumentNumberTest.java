package br.com.alura.school;

import br.com.alura.school.student.DocumentNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentNumberTest {

    @Test
    void shouldNotCreateDocumentNumberWithInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new DocumentNumber(null));
        assertThrows(IllegalArgumentException.class, () -> new DocumentNumber(""));
        assertThrows(IllegalArgumentException.class, () -> new DocumentNumber("invalid"));
    }

    @Test
    void shouldCreateDocumentNumberWithValidValue() {
        String number = "420.344.600-73";

        DocumentNumber documentNumber = new DocumentNumber(number);

        assertEquals(number, documentNumber.getValue());
    }
}