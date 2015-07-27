package com.kotai.cracking.chapter8.problem2;

import com.kotai.cracking.chapter8.problem2.employee.Employee;

public class Call {
  private boolean isCompleted;
  private Rank minRank;
  private Employee handler;

  private final String callerName;

  public Call(String callerName) {
    this.callerName = callerName;
    this.minRank = Rank.RESPONDER;
    this.isCompleted = false;
  }

  public void setHandler(Employee employee) {
    this.handler = employee;
  }

  public String getCallerName() {
    return this.callerName;
  }

  public Rank getRank() {
    return minRank;
  }

  public void excalate() {
    this.minRank = Rank.getRankForLevel(minRank.getRank() + 1);
  }

  public boolean isCompleted() {
    return this.isCompleted;
  }

  public void setCompleted() {
    this.isCompleted = true;
    this.handler = null;
  }

  public Employee getHandler() {
    return handler;
  }
}
