package com.kotai.cracking.chapter9.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Sets;
import com.kotai.cracking.chapter9.ParanthesisGenerator;

public class ParanthesisGeneratorTest {

  private ParanthesisGenerator generator = new ParanthesisGenerator();

  @Test
  public void cant_generate_for_odd_number() {
    assertThat(generator.generateFor(3), equalTo(Sets.newHashSet()));
    assertThat(generator.generateFor(5), equalTo(Sets.newHashSet()));
  }

  @Test
  public void generate_for_2_shows_good() {
    assertThat(generator.generateFor(2), equalTo(Stream.of("()").collect(Collectors.toSet())));
  }

  @Test
  public void generate_for_4_is_ok() {
    assertThat(generator.generateFor(4),
        equalTo(Stream.of("()()", "(())").collect(Collectors.toSet())));
  }

  @Test
  public void generate_for_6_is_ok() {
    assertThat(generator.generateFor(6), equalTo(
        Stream.of("()()()", "()(())", "(()())", "(())()", "((()))").collect(Collectors.toSet())));
  }
}
