package com.keresman.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "articlearchive")
@XmlAccessorType(XmlAccessType.FIELD)
public final class UserArchive {
    
    @XmlElementWrapper
    @XmlElement(name = "user")
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
