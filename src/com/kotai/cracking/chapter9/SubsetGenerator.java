package com.kotai.cracking.chapter9;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Write a method to return all subsets of a set.
 */

public class SubsetGenerator<T> {

  public List<List<T>> createAllSubsets(List<T> set) {
    return getSubsets(set, 0);
  }

  private List<List<T>> getSubsets(List<T> set, int index) {
    List<List<T>> allSubsets;
    if (set.size() == index) {
      allSubsets = new ArrayList<>();
      allSubsets.add(new ArrayList<>());
    } else {
      allSubsets = getSubsets(set, index + 1);
      T currentElement = set.get(index);
      List<List<T>> otherSubsets = Lists.newArrayList();
      for (List<T> subset : allSubsets) {
        List<T> newSubset = Lists.newArrayList();
        newSubset.addAll(subset);
        newSubset.add(currentElement);
        otherSubsets.add(newSubset);
      }
      allSubsets.addAll((otherSubsets));
    }
    return allSubsets;
  }

}
