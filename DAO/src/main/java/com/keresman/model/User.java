package com.keresman.model;

import java.time.LocalDateTime;
import java.util.Objects;

public final class User implements Comparable<User> {

    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String passwordHash;
    private String email;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(
            String username,
            String passwordHash,
            String firstName,
            String lastName,
            String email) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(
            int userId,
            String username,
            String passwordHash,
            String firstName,
            String lastName,
            String email,
            Role role,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{"
                + "userId=" + userId
                + ", username=" + username
                + ", passwordHash=" + passwordHash
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", email=" + email
                + ", role=" + role
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return userId == user.userId
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(username, user.username)
                && Objects.equals(passwordHash, user.passwordHash)
                && Objects.equals(email, user.email)
                && Objects.equals(role, user.role)
                && Objects.equals(createdAt, user.createdAt)
                && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username);
    }

    @Override
    public int compareTo(User o) {
        return this.username.compareToIgnoreCase(o.username);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
