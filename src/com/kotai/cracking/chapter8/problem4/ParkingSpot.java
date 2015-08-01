package com.kotai.cracking.chapter8.problem4;

public class ParkingSpot {
  private Vehicle vehicleInSpot;
  private final int spotSize;
  private final int spotNumber;
  private final int level;

  public ParkingSpot(int level, int spotNumber, int spotSize) {
    this.level = level;
    this.spotNumber = spotNumber;
    this.spotSize = spotSize;
  }

  public boolean park(Vehicle vehicle) {
    if (isSpotTaken()) {
      return false;
    }
    vehicleInSpot = vehicle;
    return true;
  }

  public void removeVehicle() {
    vehicleInSpot = null;
  }

  public boolean isSpotTaken() {
    return vehicleInSpot == null;
  }

  public int getSpotSize() {
    return spotSize;
  }

  public int getSpotNumber() {
    return spotNumber;
  }

  public int getLevel() {
    return level;
  }
}
