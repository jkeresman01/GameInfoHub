package com.keresman.model;

public class Platform implements Comparable<Platform>{

    private int id;
    private String name;

    public Platform() {
    }

    public Platform(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Platform(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Platform o) {
        return this.name.compareToIgnoreCase(o.name);
    }
}
