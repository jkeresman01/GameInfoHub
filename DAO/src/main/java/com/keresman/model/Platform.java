package com.keresman.model;

public final class Platform implements Comparable<Platform> {

    private int platformId;
    private String name;

    public Platform() {
    }

    public Platform(int platformId, String name) {
        this.platformId = platformId;
        this.name = name;
    }

    public Platform(String name) {
        this.name = name;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Platform o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
