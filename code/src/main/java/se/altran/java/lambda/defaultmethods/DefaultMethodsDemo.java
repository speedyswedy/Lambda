package se.altran.java.lambda.defaultmethods;


public class DefaultMethodsDemo implements Foo, Bar {

    public static void main(String[] args) {  
    }
}

interface Foo {
    default void someMethod() {
        System.out.println("Foo#SomeMethod");
    }
    
    default void soeOtherMethod() {
        System.out.println("Foo#SomeOtherMethod");
    }
}

interface Bar {
    
    // TODO Rename this method to someMethod, compile error should appear
    default void someMethod2() {
        System.out.println("Bar#someMethod");
    }
}

