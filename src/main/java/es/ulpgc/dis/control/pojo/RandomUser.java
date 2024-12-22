package es.ulpgc.dis.control.pojo;

public class RandomUser {
    private String gender;
    private Name name;
    private Picture picture;
    private String email;

    public record Name(String title, String first, String last) {
    }

    public record Picture(String large, String medium, String thumbnail) {
    }

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Picture getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }
}
