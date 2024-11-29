import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DemoLambda {
  public static void main(String[] args) {

    BiFunction<Integer, Integer, Integer> add = (a, b) -> {
      int result = a + b;
      return result;
    };
    System.out.println(add.apply(10, 20));


    // example of Predicate
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    // list1.add(7); // can not use .add(),because of Arrays.asList()
    Predicate<Integer> isEven = n -> n % 2 == 0;
    List<Integer> evenNumberLists = list1.stream() //
        .filter(isEven).collect(Collectors.toSet());

    List<Integer> evenNumberList2 =
        list1.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

    List<String> evenNumberLists3 = list1.stream()
        .filter(num -> String.valueOf(num)).collect(Collectors.toList());
    System.out.println("line 73 : ");
    System.out.println(evenNumberLists3.get(0) instanceof String);
    

    // example of Supplier
    Supplier<Double> ramdomSupplier = () -> Math.random();
    System.out.println(ramdomSupplier.get()); // ramdom Double

    // 會自動排序
    TreeMap<Double, Integer> stockPrice = new TreeMap<>();
    stockPrice.put(333.50, 300);
    stockPrice.put(333.30, 100);
    stockPrice.put(333.40, 200);
    System.out.println(stockPrice);
    // {333.3=100, 333.4=200, 333.5=300}

    // 按照輸入次序排
    Map<Double, Integer> stockPrice2 = new HashMap<>();
    stockPrice2.put(333.50, 300);
    stockPrice2.put(333.30, 100);
    stockPrice2.put(333.40, 200);
    System.out.println(stockPrice2);
    // {333.4=200, 333.5=300, 333.3=100}

  }
}
