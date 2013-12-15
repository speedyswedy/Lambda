package se.altran.java.lambda.methodReference;

public class HelloAndGodbyeApp {
    
    public static void hello(String str) {
        System.out.println("Hello " + str);
    }
    
    public void executeMyInterfaceImplementation(MyInterface myObject) {
        myObject.process("Kalle");
    }
    
    public void run() {
        MyInterface hello = HelloAndGodbyeApp::hello;
        //Task: Add a godbye method as well
        MyInterface godbye = null;
        executeMyInterfaceImplementation(hello);
        executeMyInterfaceImplementation(godbye);
    }
    
    public static void main(String[] args) {
        HelloAndGodbyeApp t = new HelloAndGodbyeApp();
        t.run();
    }
}

interface MyInterface {
    public void process(String a);
}