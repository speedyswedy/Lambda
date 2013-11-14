package se.altran.java.lambda.expresssions;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.altran.java.lambda.expresssions.domain.Person;

public class NetworkingAppTest {

    private NetworkingApp app;

    @Before
    public void setup() {
        app = new NetworkingApp();
    }

    @Test
    public void testGetPersonsOlderThan() {
        List<Person> persons = createPersons();
        List<Person> results = app.getAndPrintPersonsOlderThan(persons, 36);
        assertTrue(results.size() == 2);
    }

    @Test
    public void testGetPersonsWithinAgeRange() {
        List<Person> persons = createPersons();
        List<Person> results = app.getAndPrintPersonsWithinAgeRange(persons, 36, 40);
        assertTrue(results.size() == 2);
    }

    @Test
    public void testgetPersons() {
        List<Person> persons = createPersons();
        List<Person> results = app.getAndPrintPersons(persons, new CheckPersonEligibleForSelectiveService());
        assertTrue(results.size() == 2);
    }

    //Approach 4: Specify Search Criteria Code in an Anonymous Class
    @Test
    public void testgetPersonsAnonymous() {
        List<Person> persons = createPersons();
        List<Person> results = app.getAndPrintPersons(persons, new CheckPerson() {
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE && p.getAge() >= 36 && p.getAge() <= 40;
            }
        });
        assertTrue(results.size() == 2);
    }
    
   //Approach 5: Specify Search Criteria Code with a Lambda Expression
    @Test
    public void testgetPersonsLambda() {
        List<Person> persons = createPersons();
        List<Person> results = app.getAndPrintPersons(persons, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 36
                && p.getAge() <= 40
        );
        assertTrue(results.size() == 2);
    }
    
    @Test
    public void testGetPersonsWithPredicate() {
        List<Person> persons = createPersons();
        List<Person> results = app.getAndPrintPersonsWithPredicate(persons, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 36
                && p.getAge() <= 40
        );
        assertTrue(results.size() == 2);
    }
    
    // Approach 7: Use Lambda Expressions Throughout Your Application
    @Test
    public void testProcessPersons() {
        List<Person> persons = createPersons();
        List<Person> results = app.processPersons(persons, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 36
                && p.getAge() <= 40,
                p -> p.printPerson()
        );
        assertTrue(results.size() == 2);
    }
    
    @Test
    public void testProcessPersonsWithFunction() {
        List<Person> persons = createPersons();
        List<Person> results = app.processPersonsWithFunction(persons, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 36
                && p.getAge() <= 40,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        assertTrue(results.size() == 2);
    }
    
    @Test
    public void testProcessElements() {
        List<Person> persons = createPersons();
        List<Person> results = app.processElements(persons, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 36
                && p.getAge() <= 40,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        assertTrue(results.size() == 2);
    }
    
    private List<Person> createPersons() {
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
