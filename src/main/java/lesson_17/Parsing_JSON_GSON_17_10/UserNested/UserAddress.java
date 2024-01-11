package lesson_17.Parsing_JSON_GSON_17_10.UserNested;

public class UserAddress {
    private String country;
    private String city;
    private String street;
    private String houseNumber;

    public UserAddress(String country, String city, String street, String houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
