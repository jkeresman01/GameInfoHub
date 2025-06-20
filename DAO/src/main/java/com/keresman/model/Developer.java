package com.keresman.model;

public final class Developer implements Comparable<Developer> {

    private int developerId;

    private String firstName;

    private String lastName;

    public Developer() {
    }

    public Developer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Developer(int developerId, String firstName, String lastName) {
        this.developerId = developerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return "Developer{" + "developerId=" + developerId + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.developerId;
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
        final Developer other = (Developer) obj;
        return this.developerId == other.developerId;
    }

    @Override
    public int compareTo(Developer o) {
        return Integer.compare(developerId, o.developerId);
    }
}
