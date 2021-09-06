import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Person {
    private Integer id;
    private String fname;
    private String lname;

    public Person(Integer id, String fname, String lname) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    //Getters and Setters

    @Override
    public String toString() {
        return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}

public class FinalPractice07 {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>(List.of("Spring", "Spring Boot", "API"
                , "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));

        //removeIf: elimina elementos de la lista que cumplan la condicion
        System.out.println(courses);
        courses.removeIf(course -> course.length() < 6);
        System.out.println(courses);

        //distinct: elimina los elementos duplicados
        List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

        List<String> distinctElements = list.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctElements);

        //distinctByKey: elimina los elementos duplicados por clave
        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Brian", "Clooney");
        Person alex = new Person(3, "Alex", "Kolen");

        List<Person> personList = Arrays.asList(lokesh,brian,alex,lokesh,brian,lokesh);

        List<Person> distinctElementsByKey = personList.stream()
                .filter( distinctByKey(Person::getId) )
                .collect(Collectors.toList());

        System.out.println("distinct elments by key " +  distinctElementsByKey );
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
