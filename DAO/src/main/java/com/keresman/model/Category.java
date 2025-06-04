package com.keresman.model;

public class Category implements Comparable<Category> {

    private int id;
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + '}';
    }
    
    @Override
    public int compareTo(Category o) {
        return this.name.compareToIgnoreCase(o.name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
