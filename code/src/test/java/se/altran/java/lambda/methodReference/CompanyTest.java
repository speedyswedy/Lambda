package se.altran.java.lambda.methodReference;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.altran.java.lambda.expresssions.domain.Person;

public class CompanyTest {
    
    private Company sortPersons;

    @Before
    public void setup() {
        sortPersons = new Company();
    }
    
    @Test
    public void testSortEmployeesByAge() {
        List<Person> sortedPersons = sortPersons.sortEmployeesByAge();
        Person previousPerson = null;
        for(Person p : sortedPersons) {
            if (previousPerson == null || Person.compareByAge(p, previousPerson) > 0) {
                previousPerson = p;
            } else {
                fail();
            }
        }
    }
    
    @Test
    public void testSortEmployeesByAge2() {
        List<Person> sortedPersons = sortPersons.sortEmployeesByAge2();
        Person previousPerson = null;
        for(Person p : sortedPersons) {
            if (previousPerson == null || Person.compareByAge(p, previousPerson) > 0) {
                previousPerson = p;
            } else {
                fail();
            }
        }
    }
    
    @Test
    public void testSortEmployeesByAge3() {
        List<Person> sortedPersons = sortPersons.sortEmployeesByAge3();
        Person previousPerson = null;
        for(Person p : sortedPersons) {
            if (previousPerson == null || Person.compareByAge(p, previousPerson) > 0) {
                previousPerson = p;
            } else {
                fail();
            }
        }
    }
    
    @Test
    public void testSortEmployeesByAge4() {
        List<Person> sortedPersons = sortPersons.sortEmployeesByAge4();
        Person previousPerson = null;
        for(Person p : sortedPersons) {
            if (previousPerson == null || Person.compareByAge(p, previousPerson) > 0) {
                previousPerson = p;
            } else {
                fail();
            }
        }
    }

}
