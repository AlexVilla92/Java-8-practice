import java.util.List;

//02 - Introduction to functional
public class Structured02 {
    public static void main(String[] args) {
        printAllNumbers(List.of(1,2,3,4,2,5,5,45,1));
    }

    private static void printAllNumbers(List<Integer> numbers) {
        for (Integer oneNumber: numbers) {
            System.out.println(oneNumber);
        }
    }
}
