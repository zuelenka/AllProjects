import java.util.Objects;

public class StudentJava {
    private final String name;
    private final int age;
    private final String email;

    public StudentJava(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    //Генерируем equals/hashCode через IntelliJ (Alt+Insert).
    //Сгенерированный IntelliJ equals содержит проверку типа getClass() и явную на пустоту
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentJava that = (StudentJava) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    //Генерируем toString через IntelliJ (Alt+Insert).
    @Override
    public String toString() {
        return "StudentJava{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}