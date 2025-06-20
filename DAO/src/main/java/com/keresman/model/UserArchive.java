package com.keresman.model;

import java.util.ArrayList;
import java.util.List;

public final class UserArchive {
    
    private List<User> users;

    public UserArchive() {
    }

    public UserArchive(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
