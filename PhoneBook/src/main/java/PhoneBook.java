import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    private List<People> person;

    public PhoneBook() {
        this.person = new ArrayList<>();
    }

    public int getSize() {
        return person.size();
    }

    public List<People> getPerson() {
        return Collections.unmodifiableList(person);
    }

    public void addPerson(People per) {
        person.add(per);
    }

    public void removePerson(int index) {
        person.remove(index - 1);
    }

    public final List<People> find(String str) {
        List<People> findPerson = new ArrayList<>();

        for (People c : person) {
            if (c.getMail().contains(str))
                findPerson.add(c);
            for (Number num : c.getNumberPhone())
                if (num.getNumber().contains(str))
                    findPerson.add(c);
            if (c.getSurname().contains(str))
                findPerson.add(c);
            if (c.getName().contains(str))
                findPerson.add(c);
        }

        return findPerson;
    }
}
