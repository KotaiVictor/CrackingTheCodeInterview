package com.kotai.cracking.chapter9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

/**
 * Write a method to return all subsets of a set.
 */

public class SubsetGenerator<T> {

  public List<List<T>> createAllSubsets(List<T> set) {
    // return getSubsets(set, 0);
    return getSubsetsViaNumberGeneration(set);
  }

  private List<List<T>> getSubsets(List<T> set, int index) {
    List<List<T>> allSubsets;
    if (set.size() == index) {
      allSubsets = Lists.newArrayList();
      allSubsets.add(Lists.newArrayList());
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

  private List<List<T>> getSubsetsViaNumberGeneration(List<T> set) {
    return Stream.iterate(0, (subsetNo) -> subsetNo + 1).limit(1 << set.size())
        .map(subsetNo -> convertToSubset(subsetNo, set)).collect(Collectors.toList());
  }

  private List<T> convertToSubset(int subsetNo, List<T> set) {
    List<T> subset = Lists.newArrayList();
    int index = 0;
    for (int k = subsetNo; k > 0; k >>= 1) {
      if ((k & 1) == 1)
        subset.add(set.get(index));
      index++;
    }
    return subset;
  }
}
