package se.altran.java.lambda.effectivelyfinal;


public class ShowEffectivelyFinal {
    
    public void test() {
        String str = "";
        A a = s -> {str = "dummy"; return str;};
     }
     
 }

 interface A {
     public String test(String str);
 }

