package es.ulpgc.dis.control;

import es.ulpgc.dis.model.User;

import java.io.IOException;
import java.util.List;

public interface UserProvider {
    List<User> newUsers(int numberOfUsers) throws IOException;
}
