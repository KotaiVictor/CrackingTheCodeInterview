package com.kotai.cracking.chapter8.problem4;

import java.util.List;

import com.google.common.collect.Lists;

public class ParkingLot {
  List<ParkingSpot> emptySpots = Lists.newArrayList();
  List<ParkingSpot> filledSpots = Lists.newArrayList();

  public ParkingLot(List<ParkingSpot> spots) {
    emptySpots.addAll(spots);
  }

  public void parkVehicle(Vehicle vehicle) {
    // find a way to get a big enough spot
  }
}
