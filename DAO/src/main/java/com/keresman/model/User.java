package com.keresman.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public final class User implements Comparable<User> {

  public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

  @XmlElement(name = "userid")
  private int userId;

  @XmlElement(name = "firstname")
  private String firstName;

  @XmlElement(name = "lastname")
  private String lastName;

  @XmlElement(name = "username")
  private String username;

  @XmlElement(name = "passwordhash")
  private String passwordHash;

  @XmlElement(name = "email")
  private String email;

  @XmlElement(name = "role")
  private Role role;

  @XmlElement(name = "gender")
  private Gender gender;

  @XmlElement(name = "picturepath")
  private String picturePath;

  @XmlElement(name = "createdat")
  @XmlJavaTypeAdapter(UserDateTimeAdapter.class)
  private LocalDateTime createdAt;

  @XmlElement(name = "updatedat")
  @XmlJavaTypeAdapter(UserDateTimeAdapter.class)
  private LocalDateTime updatedAt;

  @XmlElement(name = "isactive")
  private boolean isActive;

  public User() {}

  public User(
      String username,
      String passwordHash,
      String firstName,
      String lastName,
      String email,
      String picturePath,
      Gender gender) {
    this.username = username;
    this.passwordHash = passwordHash;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.picturePath = picturePath;
    this.gender = gender;
  }

  public User(
      int userId,
      String username,
      String passwordHash,
      String firstName,
      String lastName,
      String email,
      Role role,
      Gender gender,
      Boolean isActive,
      String picturePath,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.userId = userId;
    this.username = username;
    this.passwordHash = passwordHash;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.role = role;
    this.gender = gender;
    this.isActive = isActive;
    this.picturePath = picturePath;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "User{"
        + "userId="
        + userId
        + ", firstName="
        + firstName
        + ", lastName="
        + lastName
        + ", username="
        + username
        + ", passwordHash="
        + passwordHash
        + ", email="
        + email
        + ", role="
        + role
        + ", gender="
        + gender
        + ", picturePath="
        + picturePath
        + ", createdAt="
        + createdAt
        + ", updatedAt="
        + updatedAt
        + ", isActive="
        + isActive
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
    return Integer.compare(userId, o.userId);
  }

  public int getId() {
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

  public String getGender() {
    return gender.toString();
  }

  public String getPicturePath() {
    return picturePath;
  }

  public void setPicturePath(String picturePath) {
    this.picturePath = picturePath;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isAdmin() {
    return this.role == Role.ADMINISTRATOR;
  }

  public Role getRole() {
    return this.role;
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

  public boolean isActive() {
    return this.isActive;
  }
}
