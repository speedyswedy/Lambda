package se.altran.java.lambda.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import se.altran.java.lambda.expresssions.domain.Person;

public class PersonFactory {
    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<Person>();
        LocalDate birthday = LocalDate.now();
        birthday = birthday.withYear(1974);
        persons.add(new Person("Åke", birthday, Person.Sex.MALE, "ake@telia.com"));
        birthday = birthday.withYear(1977);
        persons.add(new Person("Lars", birthday, Person.Sex.MALE, "lars@telia.com"));
        birthday = birthday.withYear(1981);
        persons.add(new Person("Bertil", birthday, Person.Sex.MALE, "bertil@telia.com"));
        birthday = birthday.withYear(1985);
        persons.add(new Person("Lisa", birthday, Person.Sex.FEMALE, "lisa@telia.com"));
        return persons;
    }
}
