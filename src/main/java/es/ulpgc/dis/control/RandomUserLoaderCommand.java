package es.ulpgc.dis.control;

import es.ulpgc.dis.model.User;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class RandomUserLoaderCommand {
    private final int numberOfUsers;

    public RandomUserLoaderCommand(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public List<User> execute() {
        try {
            return new RandomUserProvider().newUsers(numberOfUsers);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
