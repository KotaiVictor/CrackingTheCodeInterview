package com.kotai.cracking.chapter8.problem4;

public abstract class Vehicle {

  private final String licensePlate;
  private final int size;
  private ParkingSpot spot;

  public Vehicle(String licensePlate, int size) {
    this.licensePlate = licensePlate;
    this.size = size;
  }

  public void parkInSpot(ParkingSpot spot) {
    this.spot = spot;
  }

  public void clearSpot() {
    spot = null;
  }
}
