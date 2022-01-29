package school;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;

    private DocumentNumber documentNumber;
    private Email email;

    private List<Phone> phones = new ArrayList<>();

    public Student addPhone(String areaCode, String number) {
        this.phones.add(new Phone(areaCode, number));
        return this;
    }

}
