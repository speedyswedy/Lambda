package se.altran.java.lambda.methodReference;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import se.altran.java.lambda.expresssions.domain.Person;
import se.altran.java.lambda.utils.PersonFactory;

public class Company {
    
    public List<Person> sortEmployeesByAge() {
        
        List<Person> persons = PersonFactory.getPersons();
       
        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        
        Collections.sort(persons, new PersonAgeComparator());
        
        return persons;
    }
    
    
    //static <T> void sort(T[] a, Comparator<? super T> c)  --> functional interface
    
    public List<Person> sortEmployeesByAge2() {
        
        List<Person> persons = PersonFactory.getPersons();
        
        Collections.sort(persons,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
            );
        
        return persons;
    }
    
    //However, this method to compare the birth dates of two Person 
    //instances already exists as Person.compareByAge.
    
    public List<Person> sortEmployeesByAge3() {
        
        List<Person> persons = PersonFactory.getPersons();
        
        Collections.sort(persons, (a, b) -> Person.compareByAge(a, b));
        
        return persons;
    }
    
    //Because this lambda expression invokes an existing method, you can use a 
    //method reference instead of a lambda expression:
    
    public List<Person> sortEmployeesByAge4() {
        
        List<Person> persons = PersonFactory.getPersons();
        
        Collections.sort(persons, Person::compareByAge);
        
        return persons;
    }
}
