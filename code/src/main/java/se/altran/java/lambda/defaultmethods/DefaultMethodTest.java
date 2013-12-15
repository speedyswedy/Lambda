package se.altran.java.lambda.defaultmethods;


public class DefaultMethodTest {

    public String test() {
       A a = s -> {s= "Pelle";return s;};
       return t(a);
    }
    
    public String t(A a) {
        return a.test("pelle");
    }
    
    public static void main(String[] args) {
        DefaultMethodTest test = new DefaultMethodTest();
        System.out.println(test.test());
    }
    
}

interface A {
    public String test(String str);
}

