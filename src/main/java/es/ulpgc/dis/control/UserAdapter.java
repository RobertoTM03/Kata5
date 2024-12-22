package es.ulpgc.dis.control;

import es.ulpgc.dis.model.User;

public interface UserAdapter<T> {
    User from(T object);
}
