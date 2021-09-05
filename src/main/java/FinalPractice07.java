import java.util.ArrayList;
import java.util.List;

public class FinalPractice07 {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>(List.of("Spring", "Spring Boot", "API"
                , "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));

        //removeIf: elimina elementos de la lista que cumplan la condicion
        System.out.println(courses);
        courses.removeIf(course -> course.length() < 6);
        System.out.println(courses);

        
    }
}
