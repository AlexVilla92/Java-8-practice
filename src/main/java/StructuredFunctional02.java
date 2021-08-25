import java.util.List;

//02 - Introduction to functional
public class StructuredFunctional02 {

    private static final List<String> courses = List.of("Spring", "Spring Boot", "API"
            , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

    public static void main(String[] args) {
        //printAllNumbers(List.of(1,2,3,4,2,5,5,45,1));
        //printAllNumbersFunctional(List.of(1,2,3,4,2,5,5,45,1));
        //printEvenNumbersStructured(List.of(1,2,3,4,2,5,5,45,1));
        //System.out.println();
        //printEvenNumbersFunctional(List.of(1,2,3,4,2,5,5,45,1));
        //printOnlyOddNumbers(List.of(1,2,3,4,2,5,5,45,1));
        //printCoursesContainsWord("Spring");
        //printCoursesWith4LettersOrMore();
        //printSquareOfEvenNumbersFunctional(List.of(1,2,3,4,2,5,5,45,1));
        //printCubesOfOddNumbers(List.of(1,2,3,4,2,5,5,45,1));
        printLengthOfCourses();
    }

    //print length of courses
    private static void printLengthOfCourses() {
        courses.stream().map(course -> course + " " + course.length()).forEach(System.out::println);
    }

    //Print the cubes of odd numbers
    private static void printCubesOfOddNumbers(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 == 1)
                .map(number -> number * number * number).forEach(System.out::println);
    }

    //calculate and show square of even numbers
    private static void printSquareOfEvenNumbersFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 == 0)
                .map(number -> number * number).forEach(System.out::println);
    }

    //Print Courses Whose Name has atleast 4 letters
    private static void printCoursesWith4LettersOrMore() {
        courses.stream().filter(course -> course.length() > 3).forEach(System.out::println);
    }

    //Print Courses Containing the word "Spring"
    private static void printCoursesContainsWord(String word) {
        courses.stream().filter(course -> course.contains(word)).forEach(System.out::println);
    }

    //imprime solo numeros impares
    private static void printOnlyOddNumbers(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printEvenNumbersFunctional(List<Integer> numbers) {
        //filter
        numbers.stream()
                .filter(number -> number % 2 == 0).forEach(System.out::println);
                //.filter(StructuredFunctional02::isEven).forEach(System.out::println);

    }

    private static void printEvenNumbersStructured(List<Integer> numbers) {
        for (Integer oneNumber: numbers) {
            if (oneNumber % 2 == 0) {
                System.out.println(oneNumber);
            }
        }
    }

    private static void printAllNumbersFunctional(List<Integer> numbers) {
        //method reference
        numbers.forEach(StructuredFunctional02::printNumber);
        numbers.forEach(System.out::println);
    }

    private static void printNumber(int number) {
        System.out.println(number);
    }

    private static void printAllNumbers(List<Integer> numbers) {
        for (Integer oneNumber: numbers) {
            System.out.println(oneNumber);
        }
    }
}
