package se.altran.java.lambda.defaultmethods;

public class DefaultMethodsDemo2 implements Foo2, Bar2 {

    public static void main(String[] args) {
       DefaultMethodsDemo2 demo = new DefaultMethodsDemo2();
       demo.someMethod();
    }

    @Override
    public void someMethod() {
        System.out.println("DefaultMethodsDemo2#someMethod");
        Bar2.super.someMethod(); 
    }
}


interface Foo2 {
    default void someMethod() {
        System.out.println("Foo#SomeMethod");
    }
    
    default void soeOtherMethod() {
        System.out.println("Foo#SomeOtherMethod");
    }
}

interface Bar2 {
    default void someMethod() {
        System.out.println("Bar#someMethod");
    }
}

