package com.keresman.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category implements Comparable<Category> {

    @XmlElement(name = "categoryId")
    private int categoryId;

    @XmlElement(name = "name")
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.categoryId = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + categoryId + ", name=" + name + '}';
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
    
        @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        return this.categoryId == other.categoryId;
    }
}
