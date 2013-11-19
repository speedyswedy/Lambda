package se.altran.java.lambda.methodReference;

import java.util.ArrayList;
import java.util.List;

public class ReferenceTest {
    public void test() {
        
        // Create an object and instantiate a variable
        Reference<MyObject> constructorRef = MyObject::new;
        MyObject object = constructorRef.process("Hello World");
        System.out.println(object.getVariable());
        
        // Create an other object and instantiate a name variable
        Reference<MyObject2> constructorRef2 = MyObject2::new;
        MyObject2 object2 = constructorRef2.process("Kalle");
        System.out.println(object2.getName());
        
        // Call an instance method
        Reference<String> constructorRef3 = this::someMethod;
        String object3 = constructorRef3.process("instance method");
        System.out.println(object3);
        
        //Call a static method
        Reference<String> constructorRef4 = ReferenceTest::someOtherMethod;
        String object4 = constructorRef4.process("static method");
        System.out.println(object4);
        
        // Length of a String
        Length l = "Kalle Johnsson"::length;
        System.out.println(l.length());
        
        // Creation of an ArrayList
        MyList<Integer> myListRef = ArrayList::new;
        List<Integer> myList = myListRef.create();
        myList.add(1);
        System.out.println(myList.size());  
        
    }
    
    public String someMethod(String str) {
        return "someMethod:" + str;
    }
    
    public static String someOtherMethod(String str) {
        return "someStaticMethod:" + str;
    }
    
    public static void main(String[] args) {
        ReferenceTest t = new ReferenceTest();
        t.test();
    }
}

interface Reference<T> {
    T process(String t);
}

interface Length {
    int length();
}

interface MyList<T> {
    List<T> create();
}

class MyObject {
    private String variable;
    
    public MyObject(String t) {
        this.variable = t;
    }
    
    public String getVariable() {
        return variable;
    }
}

class MyObject2 {
    private String name;
    public MyObject2(String t) {
        this.name = t;
    }
    
    public String getName() {
        return name;
    }
    
}