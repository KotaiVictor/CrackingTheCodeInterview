package com.kotai.cracking.chapter9.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.kotai.cracking.chapter9.StringPermutation;

public class StringPermutationTest {

  private StringPermutation permutator = new StringPermutation();

  @Test
  public void allpermutations_for_a_1_lengthString() {
    assertThat(permutator.generatePermutations("a"),
        equalTo(Stream.of("a").collect(Collectors.toList())));
  }

  @Test
  public void all_permutations_for_a_2_lenghtString() {
    assertThat(permutator.generatePermutations("ab"),
        equalTo(Stream.of("ab", "ba").collect(Collectors.toList())));
  }

  @Test
  public void all_permutations_for_a_3_lenght_string() {
    List<String> permutations = permutator.generatePermutations("abc");
    assertThat(permutations.stream().distinct().count(), equalTo(6l));
  }
}
