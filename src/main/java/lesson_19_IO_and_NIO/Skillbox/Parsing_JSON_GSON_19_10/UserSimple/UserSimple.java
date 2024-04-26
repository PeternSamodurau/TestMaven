package lesson_19_IO_and_NIO.Skillbox.Parsing_JSON_GSON_19_10.UserSimple;

public class UserSimple {
    private String name;
    private String email;
    private transient int age;                   // transient делает 0
    private transient boolean isDeveloper;        // transient делает false

    public UserSimple(String name, String email, int age, boolean isDeveloper) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
    }

    @Override
    public String toString() {
        return "UserSimple{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}
