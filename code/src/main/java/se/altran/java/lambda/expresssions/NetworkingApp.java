package se.altran.java.lambda.expresssions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import se.altran.java.lambda.expresssions.domain.Person;

public class NetworkingApp {

    // Approach 1: Create Methods That Search for Members That Match One
    // Characteristic
    public List<Person> getAndPrintPersonsOlderThan(List<Person> persons, int age) {
        List<Person> tempPersons = new ArrayList<Person>();
        for (Person p : persons) {
            if (p.getAge() >= age) {
                p.printPerson();
                tempPersons.add(p);
            }
        }
        return tempPersons;
    }

    // Approach 2: Create More Generalized Search Methods
    public List<Person> getAndPrintPersonsWithinAgeRange(List<Person> persons, int low, int high) {
        List<Person> tempPersons = new ArrayList<Person>();
        for (Person p : persons) {
            // Task 1:
            // add new condition here
                p.printPerson();
                tempPersons.add(p);
           
        }
        return tempPersons;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Approach 3: Specify Search Criteria Code in a Local Class
    public List<Person> getAndPrintPersons(List<Person> persons, CheckPerson tester) {
        List<Person> tempPersons = new ArrayList<Person>();
        for (Person p : persons) {
            if (tester.test(p)) {
                p.printPerson();
                tempPersons.add(p);
            }
        }
        return tempPersons;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions
    // Task 4:
    // Change CheckPerson to an already existing function inerface in Java
    public List<Person> getAndPrintPersonsWithPredicate(List<Person> persons, CheckPerson tester) {
        List<Person> tempPersons = new ArrayList<Person>();
        for (Person p : persons) {
            if (tester.test(p)) {
                p.printPerson();
                tempPersons.add(p);
            }
        }
        return tempPersons;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Approach 7: Use Lambda Expressions Throughout Your Application
    // Task 5:
    // Add an existing functional interface as parameter (now a Trams interface is used)
    public List<Person> processPersons(List<Person> persons, Predicate<Person> tester, Trams<Person> trams) {
        List<Person> tempPersons = new ArrayList<Person>();
        for (Person p : persons) {
            if (tester.test(p)) {
                trams.trams(p);
                tempPersons.add(p);
            }
        }
        return tempPersons;
    }

    public List<Person> processPersonsWithFunction(List<Person> persons, Predicate<Person> tester,
            Function<Person, String> mapper, Consumer<String> block) {
        List<Person> tempPersons = new ArrayList<Person>();
        for (Person p : persons) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
                tempPersons.add(p);
            }
        }
        return tempPersons;
    }

    //Approach 8: Use Generics More Extensively
    public <X, Y> List<X> processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
            Consumer<Y> block) {
        List<X> tempPersons = new ArrayList<X>();
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
                tempPersons.add(p);
            }
        }
        return tempPersons;
    }
}

interface CheckPerson {
    boolean test(Person p);
}

interface Trams<T> {
    void trams(T t);
}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE && p.getAge() >= 36 && p.getAge() <= 40;
    }
}
