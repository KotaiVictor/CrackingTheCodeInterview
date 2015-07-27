package com.kotai.cracking.chapter8.problem2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Optional;
import com.kotai.cracking.chapter8.problem2.employee.Employee;

public class EscalatingCallHandler implements CallHandler {
  private static CallHandler instance;

  public static CallHandler getInstance() {
    if (instance == null)
      instance = new EscalatingCallHandler();
    return instance;
  }

  Map<Rank, List<Employee>> employees = new HashMap<Rank, List<Employee>>();


  public Optional<Employee> getHandlerForCall(Call call) {
    Rank callRank = call.getRank();
    List<Employee> availableEmployees = employees.get(callRank);
    Employee responder = null;
    if (!availableEmployees.isEmpty()) {
      responder = availableEmployees.get(1);
    }
    return Optional.fromNullable(responder);
  }

  @Override
  public void handleCall(Call incomingCall) {
    Optional<Employee> possibleEmployee = getHandlerForCall(incomingCall);
    if (possibleEmployee.isPresent()) {
      possibleEmployee.get().receiveCall(incomingCall);
      incomingCall.setHandler(possibleEmployee.get());
    } else {
      // escalate call
    }
  }
}
