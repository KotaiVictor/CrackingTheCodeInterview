package com.kotai.cracking.chapter8.problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.google.common.base.Optional;
import com.kotai.cracking.chapter8.problem2.employee.Employee;

public class EscalatingCallHandler implements CallHandler {
  private static CallHandler instance;

  public static CallHandler getInstance() {
    if (instance == null)
      instance = new EscalatingCallHandler();
    return instance;
  }

  private Map<Rank, List<Employee>> employees;
  private Queue<Call> escallationQueue = new LinkedList<>();

  public EscalatingCallHandler() {
    employees = new HashMap<>();
    employees.put(Rank.RESPONDER, new ArrayList<>());
    employees.put(Rank.MANAGER, new ArrayList<>());
    employees.put(Rank.DIRECTOR, new ArrayList<>());
  }

  public Optional<Employee> getHandlerForCall(Call call) {
    Rank callRank = call.getRank();
    List<Employee> availableEmployees = employees.get(callRank);
    Employee responder = null;
    if (!availableEmployees.isEmpty()) {
      responder = availableEmployees.get(1);
    }
    return Optional.fromNullable(responder);
  }

  public void addEmployee(Employee employee) {
    employees.get(employee.getRank()).add(employee);
  }

  @Override
  public void handleCall(Call incomingCall) {
    Optional<Employee> possibleEmployee = getHandlerForCall(incomingCall);
    if (possibleEmployee.isPresent()) {
      possibleEmployee.get().receiveCall(incomingCall);
      incomingCall.setHandler(possibleEmployee.get());
    } else {
      incomingCall.escalate();
      escallationQueue.offer(incomingCall);
    }
  }
}
