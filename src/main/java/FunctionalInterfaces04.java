import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterfaces04 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,2,5,5,45,1,12,15);

        //predicate: es una interface functional que solo admite un solo argumento y devuelve un booleano
        final Predicate<Integer> integerPredicate = number -> number % 2 == 0;
        //function: es una funcion que recibe un argumento y devuelve un valor
        final Function<Integer, Integer> integerFunction = number -> number * number;
        //binary operation: similar al function, pero admite 2 argumentos
        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
        //binary operation with method reference
        BinaryOperator<Integer> sumBinaryOperatorReference = Integer::sum;
        //consumer: representa a una operacion que recibe un solo argumento y no devuelve nada(como un void)
        final Consumer<Integer> println = System.out::println;
        numbers.stream()
                .filter(integerPredicate)
                .map(integerFunction)
                .forEach(println);

        //behavior parameterization: se parametriza un metodo funcional
        System.out.println("behavior parameterization");

        filterAndPrint(numbers, number -> number % 2 == 0);

        filterAndPrint(numbers, number -> number % 2 != 0);

        //exercises 13: Do Behavior Parameterization for the mapping logic.
        //List squaredNumbers = numbers.stream() .map(x -> x*x) .collect(Collectors.toList());
        System.out.println("exercise 13");
        List squaredNumbers = getMappingList(numbers, x -> x * x);
        List cubeNumbers = getMappingList(numbers, x -> x * x * x);
        List doubleNumbers = getMappingList(numbers, x -> x + x);
        System.out.println(squaredNumbers);
        System.out.println(cubeNumbers);
        System.out.println(doubleNumbers);

        //supplier: nobody input - return something
        Supplier<Integer> randomIntegerSupplier = () -> 2;
        System.out.println("supplier " + randomIntegerSupplier.get());

        Supplier<Integer> randomSupplier = () -> {
            Random random = new Random();
            return random.nextInt(2000);
        };
        System.out.println("supplier random " + randomSupplier.get());

        //unary operator: similar al binary operator, pero con un solo argumento
        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println("unary operator " + unaryOperator.apply(4));

        //Bipredicate: two inputs and the output is a boolean
        BiPredicate<Integer, String> biPredicate = (number, str) -> true;
        BiPredicate<Integer, String> biPredicateBis = (number, str) -> {
          return number > str.length();
        };

        System.out.println("bipredicate " + biPredicate.test(10, "test"));
        System.out.println("bipredicate bis " + biPredicateBis.test(10, "mañanaaaaaaaa"));

        //bifunction: recibe 2 argumentos y el tercero es el tipo de dato de la respuesta
        BiFunction<Integer, String, String> biFunction = (number, str) -> {
          return number + str;
        };

        System.out.println("bi function " + biFunction.apply(18, " in 3 months"));

        //biConsumer: recibe 2 argumentos y no devuelve ningun valor(void)
        BiConsumer<String, Integer> biConsumer = (word1, word2) -> {
            System.out.println(word1);
            System.out.println(word2);
        };

        biConsumer.accept("i live my life in", 14);

        //constructor reference
        Supplier<String> stringSupplierReference = String::new;
    }

    private static List<Integer> getMappingList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

}
