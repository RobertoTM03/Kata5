package es.ulpgc.dis.control;

import es.ulpgc.dis.control.pojo.RandomUser;
import es.ulpgc.dis.model.Image;
import es.ulpgc.dis.model.User;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.logging.Logger;

public class RandomUserAdapter implements UserAdapter<RandomUser> {
    @Override
    public User from(RandomUser object) {
        User user = new User()
                .setName(object.getName().first() + " " + object.getName().last())
                .setEmail(object.getEmail())
                .setGender(User.Gender.valueOf(capitalize(object.getGender())));
        loadPhoto(object, user);
        return user;
    }

    private void loadPhoto(RandomUser object, User user) {
        try {
            user.setPhoto(getPhoto(object.getPicture().large()));
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    private Image getPhoto(String url) throws IOException {
        return new Image(
                Jsoup.connect(url)
                        .ignoreContentType(true)
                        .execute()
                        .bodyAsBytes()
        );
    }

    private String capitalize(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
