package se.altran.java.lambda.expresssions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import se.altran.java.lambda.expresssions.domain.Person;

public class NetworkingAppAll {

    // Approach 1: Create Methods That Search for Members That Match One
    // Characteristic
    public List<Person> getAndPrintPersonsOlderThan(List<Person> roster, int age) {
        List<Person> tempRoster = new ArrayList<Person>();
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
                tempRoster.add(p);
            }
        }
        return tempRoster;
    }

    // Approach 2: Create More Generalized Search Methods
    public List<Person> getAndPrintPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        List<Person> tempRoster = new ArrayList<Person>();
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
                tempRoster.add(p);
            }
        }
        return tempRoster;
    }

    // Approach 3: Specify Search Criteria Code in a Local Class
    public List<Person> getAndPrintPersons(List<Person> roster, CheckPerson2 tester) {
        List<Person> tempRoster = new ArrayList<Person>();
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
                tempRoster.add(p);
            }
        }
        return tempRoster;
    }

    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions
    public List<Person> getAndPrintPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        List<Person> tempRoster = new ArrayList<Person>();
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
                tempRoster.add(p);
            }
        }
        return tempRoster;
    }

    // Approach 7: Use Lambda Expressions Throughout Your Application
    public List<Person> processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        List<Person> tempRoster = new ArrayList<Person>();
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
                tempRoster.add(p);
            }
        }
        return tempRoster;
    }

    public List<Person> processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
            Function<Person, String> mapper, Consumer<String> block) {
        List<Person> tempRoster = new ArrayList<Person>();
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
                tempRoster.add(p);
            }
        }
        return tempRoster;
    }

    //Approach 8: Use Generics More Extensively
    public <X, Y> List<X> processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
            Consumer<Y> block) {
        List<X> tempRoster = new ArrayList<X>();
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
                tempRoster.add(p);
            }
        }
        return tempRoster;
    }
}

interface CheckPerson2 {
    boolean test(Person p);
}

class CheckPersonEligibleForSelectiveService2 implements CheckPerson2 {
    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE && p.getAge() >= 36 && p.getAge() <= 40;
    }
}
