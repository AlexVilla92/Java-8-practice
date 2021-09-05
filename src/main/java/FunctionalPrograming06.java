import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalPrograming06 {

    private static final List<String> courses = List.of("Spring", "Spring Boot", "API"
            , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

    private static final List<String> courses2 = List.of("Spring", "Spring Boot", "API"
            , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

    public static void main(String[] args) {
        //joining: si tengo una lista, elimina la lista y me quedo con los elementos
        System.out.println(courses.stream().collect(Collectors.joining(" ")));

        System.out.println(courses.stream().collect(Collectors.joining(",")));

        //flatmap: convierte una lista de este tipo ["curso"]  a   "curso", es como que aplana la lista
        System.out.println(courses.stream().map(course -> course.split(""))
                .flatMap(Arrays::stream).collect(Collectors.toList()));

        //distinct: elimina los elementos repetidos
        System.out.println(courses.stream().map(course -> course.split(""))
                .flatMap(Arrays::stream).distinct().collect(Collectors.toList()));

        //hago un producto cartesiano entre las dos listas courses y courses2
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
                .collect(Collectors.toList()));

        //misma idea pero eliminando las tuplas que sean iguales, es decir el mismo nombre
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));

        //misma idea pero eliminando las tuplas que sean iguales, es decir el mismo nombre y ademas deben tener el mismo tamanio
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().filter(course2 -> course2.length() == course.length()).map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));

        System.out.println(courses.stream().filter(course -> course.length() > 11)
                .map(String::toUpperCase).findFirst());
    }
}
