package se.altran.java.lambda.expresssions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.altran.java.lambda.expresssions.domain.Person;
import se.altran.java.lambda.utils.PersonFactory;

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
                //Task 2:
                // Add correct condition
                // gender = Person.Sex.MALE and 36 >= age <= 40
                return false;
            }
        });
        assertTrue(results.size() == 2);
    }
    
   //Approach 5: Specify Search Criteria Code with a Lambda Expression
    @Test
    public void testgetPersonsLambda() {
        List<Person> persons = createPersons();
        //Task 3:
        // Add correct condition, but now use lambda expression
        List<Person> results = app.getAndPrintPersons(persons, null);
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
        List<Person> results = app.processPersonsWithFunction(persons, p -> p.getGender() == Person.Sex.MALE
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
        List<Person> results = app.processElements(persons, p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 36
                && p.getAge() <= 40,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        assertTrue(results.size() == 2);
    }
    
    @Test
    public void testProcessElements2() {
        List<String> names = new ArrayList<String>();
        names.add("Pelle");
        names.add("Mattias");
        List<String> results = app.processElements(names, n -> n.length() > 5,
                p -> p.length(),
                len -> System.out.println(len)
        );
        assertTrue(results.size() == 1);
    }
    
    private List<Person> createPersons() {
        return PersonFactory.getPersons();
    }

}
