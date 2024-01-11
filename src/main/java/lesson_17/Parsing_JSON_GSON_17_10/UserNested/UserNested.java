package lesson_17.Parsing_JSON_GSON_17_10.UserNested;

public class UserNested {
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;
    private UserAddress userAddress;

    public UserNested(String name, String email, int age, boolean isDeveloper, UserAddress userAddress) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "UserNested{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                ", userAddress=" + userAddress +
                '}';
    }
}
