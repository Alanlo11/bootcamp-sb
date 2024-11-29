import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoGroupby {
  public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
      this.name = name;
      this.salary = salary;
    }

    public String getName() {
      return this.name;
    }

    public int getSalary() {
      return this.salary;
    }

  }
  
  public static void main(String[] args) {
    List<Employee> employeeLists = Arrays.asList(
        new Employee("A", 20000),
        new Employee("B", 30000),
        new Employee("C", 40000),
        new Employee("D", 20000),
        new Employee("A", 40000));

    Map<String, Integer> employeeMaps = employeeLists.stream()
        .collect(Collectors.groupingBy(Employee::getName,
        Collectors.summingInt(Employee::getSalary)));

        employeeMaps.forEach((name, salary) -> {
          System.out.println(name + " : $ " + salary);
        });
        //list of list -> list
  }
}
