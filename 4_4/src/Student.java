import java.util.Objects; //Для equals, hash

//Класс Student (name, age, email).
public class Student {
    private final String name;
    private final int age;
    private final String email;

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //Переопределяем equals (по name + email)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.email, other.email);
    }

    //hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    //toString
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}