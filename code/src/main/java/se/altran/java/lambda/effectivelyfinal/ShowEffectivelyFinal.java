package se.altran.java.lambda.effectivelyfinal;


public class ShowEffectivelyFinal {
    
    public void test() {
        String str = "";
        A a = s -> {String str2 = "dummy"; return str;};
     }
     
 }

 interface A {
     public String test(String str);
 }

