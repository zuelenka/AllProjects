package base;

import java.util.Objects;

public class StudentNoHash {
    private final String name;
    private final int age;
    private final String email;

    public StudentNoHash(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StudentNoHash)) return false;
        StudentNoHash other = (StudentNoHash) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.email, other.email);
    }

    //hashCode НЕ переопределён — используется Object.hashCode()

    @Override
    public String toString() {
        return "StudentNoHash{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}