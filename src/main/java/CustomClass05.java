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
    }
}
