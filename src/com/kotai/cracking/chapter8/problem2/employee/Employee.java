package com.kotai.cracking.chapter8.problem2.employee;

import com.kotai.cracking.chapter8.problem2.Call;
import com.kotai.cracking.chapter8.problem2.Rank;

public abstract class Employee {

  private Call currentCall = null;

  protected Rank rank;

  public Employee(Rank rank) {
    this.rank = rank;
  }

  public void receiveCall(Call call) {
    this.currentCall = call;
  }

  public Call callCompleted() {
    Call completedCall = this.currentCall;
    this.currentCall = null;
    completedCall.setCompleted();
    return completedCall;
  }

  public boolean isFree() {
    return currentCall == null;
  }

  public Rank getRank() {
    return rank;
  }
}
