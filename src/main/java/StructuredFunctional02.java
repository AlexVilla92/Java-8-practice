import java.util.List;

//02 - Introduction to functional
public class StructuredFunctional02 {
    public static void main(String[] args) {
        //printAllNumbers(List.of(1,2,3,4,2,5,5,45,1));
        //printAllNumbersFunctional(List.of(1,2,3,4,2,5,5,45,1));
        printEvenNumbersStructured(List.of(1,2,3,4,2,5,5,45,1));
        System.out.println();
        printEvenNumbersFunctional(List.of(1,2,3,4,2,5,5,45,1));
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
