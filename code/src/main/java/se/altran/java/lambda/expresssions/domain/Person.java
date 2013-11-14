package se.altran.java.lambda.expresssions.domain;

import java.time.LocalDate;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }
    
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    
    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        super();
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }
    
    public Sex getGender() {
        return gender;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        LocalDate bir =  LocalDate.now();
        int age = bir.getYear() - birthday.getYear();
        return age;
    }

    public void printPerson() {
       StringBuilder sb = new StringBuilder();
       sb.append("Name:" + name + "\n");
       sb.append("Age:" + getAge() + "\n");
       sb.append("Email:" + emailAddress + "\n");
       System.out.println(sb.toString());
    }
}