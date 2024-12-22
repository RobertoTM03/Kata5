package es.ulpgc.dis.control;

import com.google.gson.Gson;
import es.ulpgc.dis.control.pojo.RandomUser;
import es.ulpgc.dis.control.pojo.RandomUserResponse;
import es.ulpgc.dis.model.User;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUserProvider implements UserProvider{
    @Override
    public List<User> newUsers(int numberOfUsers) throws IOException {
        if (numberOfUsers < 1) return Collections.emptyList();

        Connection connection = Jsoup.connect("https://randomuser.me/api/?results=" + numberOfUsers).ignoreContentType(true);
        RandomUserResponse randomUserResponse = new Gson().fromJson(connection.get().text(), RandomUserResponse.class);

        List<User> users = new ArrayList<>();

        for (RandomUser randomUser : randomUserResponse.getResults())
            users.add(new RandomUserAdapter().from(randomUser));

        return users;
    }
}
