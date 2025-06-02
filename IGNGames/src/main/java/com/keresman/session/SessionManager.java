package com.keresman.session;

import com.keresman.model.User;

public final class SessionManager {

  private static SessionManager instance;

  private User currentUser;

  private SessionManager() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static SessionManager getInstance() {
    if (instance == null) {
      instance = new SessionManager();
    }

    return instance;
  }

  public void setCurrentUser(User user) {
    this.currentUser = user;
  }

  public User getCurrentUser() {
    return this.currentUser;
  }

  public void clear() {
    this.currentUser = null;
  }

  public boolean isLoggedIn() {
    return this.currentUser != null;
  }
}
