import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}

public class CustomClass05 {

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        //allmatch: todos los elementos deben cumplir con la condicion, para que devuelve true
        //nonematch: ninguno de los elementos deben cumplir con la condicion, entonces devuelve true
        //anymatch: si alguno de los elementos cumple con la condicion, entonces devuelve true
        Predicate<Course> scoreGreaterThan90 = course -> course.getReviewScore() > 90;
        Predicate<Course> scoreGreaterThan95 = course -> course.getReviewScore() > 95;
        Predicate<Course> scoreLessThan90 = course -> course.getReviewScore() < 90;
        System.out.println(courses.stream().allMatch(scoreGreaterThan90));
        System.out.println(courses.stream().noneMatch(scoreGreaterThan90));
        System.out.println(courses.stream().noneMatch(scoreLessThan90));
        System.out.println(courses.stream().anyMatch(scoreLessThan90));
        System.out.println(courses.stream().anyMatch(scoreGreaterThan95));

        //sort: orden creciente
        Comparator<Course> comparingByNumberStudents = Comparator.comparing(Course::getNoOfStudents);
        System.out.println(courses.stream().sorted(comparingByNumberStudents).collect(Collectors.toList()));

        //sort: orden decreciente
        Comparator<Course> comparingByNumberStudentsReverse = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingByNumberStudentsReverse).collect(Collectors.toList()));

        Comparator<Course> comparingReviewsAndNumberStudentsDecreasing = Comparator.comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore).reversed();

        System.out.println(courses.stream().sorted(comparingReviewsAndNumberStudentsDecreasing).collect(Collectors.toList()));

        //skip: skipea los primero n valores, limit: solo toma los primeros n valores, los demas los elimina, seria como el opuesto a skip
        System.out.println("skip first 3 and limit only 5 ");
        System.out.println(courses.stream()
                .sorted(comparingReviewsAndNumberStudentsDecreasing)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList())
        );

        //takewhile: devuevle todos los objetos, mientras cumplan la condicion, cuando encuentra el primer objeto
        //que no la cumple, entonces corta la secuencia
        System.out.println("take while ");
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList())
        );

        //dropWhile: seria el opuesto, no devuelve los elementos que cumplan la condicion, cuando encuentra el primero que
        //no la cumpla, ya corta la secuencia
        System.out.println("drop while ");
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList())

        );

        //max element
        System.out.println("max element");
        System.out.println(courses.stream().max(comparingReviewsAndNumberStudentsDecreasing));

        //min element
        System.out.println("min element");
        System.out.println(courses.stream()
                .min(comparingReviewsAndNumberStudentsDecreasing)
                .orElse(new Course("java", "backend", 98, 10000))
        );

        //find first and findany
        System.out.println(courses.stream()
                .filter(scoreGreaterThan95)
                .findFirst()
        );

        //devuelve cualquier valor que haya cumplido la condicion
        System.out.println(courses.stream()
                .filter(scoreGreaterThan95)
                .findAny()
        );

        //devuelve el total de estudiantes que estan los cursos con score mayor a 95
        System.out.println(courses.stream()
                .filter(scoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .sum()
        );

        //idem arriba pero devuelve el promedio
        System.out.println(courses.stream()
                .filter(scoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .average()
        );

        //cuenta la cantidad de cursos que complen con la condicion del score
        System.out.println(courses.stream()
                .filter(scoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .count()
        );

        //devuelve el curso que tiene mas alumnos con score mayor a 95
        System.out.println(courses.stream()
                .filter(scoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .max()
        );

        //groupby: agrupo los cursos por categoria
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        //agrupo por categoria y cuento
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        //agrupo por categoria y me quedo con el curso que tiene mayor score, de cada categoria
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        //agrupo por categoria y listo los cursos solo por el nombre
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList()))));
    }
}
