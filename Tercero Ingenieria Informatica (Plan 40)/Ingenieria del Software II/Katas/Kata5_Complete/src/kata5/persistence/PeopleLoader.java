package kata5.persistence;

import java.util.List;
import kata5.model.Person;

public interface PeopleLoader {
    public List<Person> load();
}
