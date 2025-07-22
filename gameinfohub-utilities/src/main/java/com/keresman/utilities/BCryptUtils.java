package com.keresman.utilities;

import org.mindrot.jbcrypt.BCrypt;

public final class BCryptUtils {

  private static final int BCRYPT_WORK_FACTOR = 12;

  private BCryptUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static String hashPassword(String plainTextPassword) {
    return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(BCRYPT_WORK_FACTOR));
  }

  public static boolean veriftyPassword(String plainTextPassword, String storedHash) {
    return BCrypt.checkpw(plainTextPassword, storedHash);
  }
}
