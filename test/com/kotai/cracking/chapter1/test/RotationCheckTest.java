package com.kotai.cracking.chapter1.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.kotai.cracking.chapter1.RotationCheck;

public class RotationCheckTest {

  private RotationCheck checker = new RotationCheck();

  @Test
  public void valid_case() {
    assertTrue(checker.isRotation("waterbottle", "bottlewater"));
    assertTrue(checker.isRotation("waterbottle", "erbottlewat"));
  }

}
