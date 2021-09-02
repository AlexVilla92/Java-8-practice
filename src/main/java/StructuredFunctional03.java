import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//03 - Playing with streams
public class StructuredFunctional03 {

    private static final List<String> courses = List.of("Spring", "Spring Boot", "API"
            , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,2,5,5,45,1,12,15);

        int sum = addListFunctional(numbers);
        System.out.println(sum);
        int positiveMaxValue = positiveMaxValueCalculator(numbers);
        System.out.println("positive max value " + positiveMaxValue);
        int positiveMinValue = positiveMinValueCalculator(numbers);
        System.out.println("positive min value " + positiveMinValue);
        int squareTotal = sumOfAllSquare(numbers);
        System.out.println("sum of all squares numbers in the list " + squareTotal);
        int cubeTotal = sumOfAllCube(numbers);
        System.out.println("sum of all cube numbers in the list " + cubeTotal);
        int oddNumbersTotal = sumOfAllOddNumbers(numbers);
        System.out.println("sum of all odd numbers in the list " + oddNumbersTotal);
        practiceDistinct(numbers);
        System.out.println("reverse list");
        reverseOrderCourses(courses);
        System.out.println("order by length");
        orderByLength(courses);
        System.out.println("list with even numbers");
        List<Integer> evenList = listOfEvenNumbers(numbers);
        System.out.println(evenList);

        System.out.println("list of length courses numbers");
        List<Integer> lengthList = listOfLengthCourses(courses);
        System.out.println(lengthList);
    }

    //exercise 11: Create a List with lengths of all course titles.
    private static List<Integer> listOfLengthCourses(List<String> courses) {
        return courses.stream().map(course -> course.length()).collect(Collectors.toList());
    }

    //exercise 10: Create a List with Even Numbers Filtered from the Numbers List
    private static List<Integer> listOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }



    private static void orderByLength(List<String> courses) {
        courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    private static void reverseOrderCourses(List<String> courses) {
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void practiceDistinct(List<Integer> numbers) {
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

    //exercise 9: Find Sum of Odd Numbers in a list
    private static int sumOfAllOddNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 1).reduce(0, Integer::sum);
    }

    //exercise 8: Cube every number in a list and find the sum of cubes
    private static int sumOfAllCube(List<Integer> numbers) {
        return numbers.stream().map(number -> number * number * number).reduce(0, Integer::sum);
    }

    //exercises 7: Square every number in a list and find the sum of squares
    private static int sumOfAllSquare(List<Integer> numbers) {
        return numbers.stream().map(number -> number * number).reduce(0, Integer::sum);
    }


    private static int positiveMinValueCalculator(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MAX_VALUE, (x,y) -> x > y ? y : x);
    }

    private static int positiveMaxValueCalculator(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x,y) -> x > y ? x : y);
    }

    //return sum of a integer list functional way
    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
                //.reduce(0, StructuredFunctional03::sum);
                //.reduce(0, (x,y) -> x + y);

    }


    private static Integer sum(Integer number1, Integer number2) {
        return number1 + number2;
    }


}
