package com.kotai.cracking.chapter9.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.kotai.cracking.chapter9.SubsetGenerator;

public class SubsetGeneratorTest {

  private SubsetGenerator<Integer> generator = new SubsetGenerator<>();

  @Test
  public void case_for_a_single_element_works() {
    List<Integer> listOf1 = Stream.of(1).collect(Collectors.toList());
    List<List<Integer>> result = generator.createAllSubsets(listOf1);
    assertThat(result.size(), equalTo(2));
    assertThat(result.get(0), equalTo(Lists.newArrayList()));
    assertThat(result.get(1), equalTo(listOf1));
  }

  /* horrid tests */
  @Test
  public void case_for_2_elements_works() {
    List<Integer> listOf2 = Stream.of(1, 2).collect(Collectors.toList());
    List<List<Integer>> result = generator.createAllSubsets(listOf2);
    assertThat(result.size(), equalTo(4));
    assertThat(result.get(0), equalTo(Lists.newArrayList()));
    assertThat(result.get(1), equalTo(Stream.of(1).collect(Collectors.toList())));
    assertThat(result.get(2), equalTo(Stream.of(2).collect(Collectors.toList())));
    assertThat(result.get(3), equalTo(Stream.of(1, 2).collect(Collectors.toList())));
  }

  @Test
  public void case_for_no_elements_works() {
    List<List<Integer>> result = generator.createAllSubsets(new ArrayList<>());
    assertThat(result.size(), equalTo(1));
    assertThat(result.get(0), equalTo(Lists.newArrayList()));

  }
}
