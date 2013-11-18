package se.altran.java.lambda.methodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

//http://java.dzone.com/articles/java-lambda-expressions-vs
public class StringToInteger {
    
   // 2. Constructor Method References
    
   // public interface Function<T, R> {
   // public R apply(T t);
   // }

    <T, R> List<R> map(Function<T, R> function, List<T> source) {
        List<R> destiny = new ArrayList<>();
        for (T item : source) {
            R value = function.apply(item);
            destiny.add(value);
        }
        return destiny;
    }
 
   
    public void test() {
        List<String> digits = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> numbers = map(s -> new Integer(s), digits);
        //List<Integer> numbers = map(Integer::new, digits);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        StringToInteger sToI = new StringToInteger();
        sToI.test();
    }
}

