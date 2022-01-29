package school;

public class DocumentNumber {
    private String value;

    public DocumentNumber(String value) {
        if (value == null ||
                !value.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Invalid document number!");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
