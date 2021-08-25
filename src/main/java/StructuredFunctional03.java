import java.util.List;

//03 - Playing with streams
public class StructuredFunctional03 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,2,5,5,45,1,12,15);

        int sum = addListFunctional(numbers);
        System.out.println(sum);
    }

    //return sum of a integer list functional way
    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(0, StructuredFunctional03::sum);
    }

    private static Integer sum(Integer number1, Integer number2) {
        return number1 + number2;
    }


}
