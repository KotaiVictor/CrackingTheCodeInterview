package com.kotai.cracking.chapter8.problem5;

public class User {

  private final int userId;
  private String userName;
  private String description;

  public User(int userId, String userName, String description) {
    this.userId = userId;
    this.description = description;
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getUserId() {
    return userId;
  }
}
