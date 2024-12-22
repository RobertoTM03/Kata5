package es.ulpgc.dis.model;

public class User {
    private String name;
    private Gender gender;
    private String email;
    private Image photo;

    public enum Gender {
        Male,
        Female
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Image getPhoto() {
        return photo;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPhoto(Image photo) {
        this.photo = photo;
        return this;
    }
}
