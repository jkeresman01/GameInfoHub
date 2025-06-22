package com.keresman.model;

public final class Developer implements Comparable<Developer> {

    private int developerId;
    private String name;

    public Developer() {
    }

    public Developer(int developerId, String name) {
        this.developerId = developerId;
        this.name = name;
    }

    public Developer(String name) {
        this.name = name;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Developer o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
