package se.altran.java.lambda.methodReference;

import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.altran.java.lambda.expresssions.domain.Person;

public class CompanyTest {
    
    private Company company;

    @Before
    public void setup() {
        company = new Company();
    }
    
    @Test
    public void testSortEmployeesByAge() {
        List<Person> sortedPersons = company.sortEmployeesByAge();
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
        List<Person> sortedPersons = company.sortEmployeesByAge2();
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
        List<Person> sortedPersons = company.sortEmployeesByAge3();
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
        List<Person> sortedPersons = company.sortEmployeesByAge4();
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
