package com.kotai.cracking.chapter1;

import org.apache.commons.lang3.StringUtils;

/**
 * Given two strings, check that one is the rotation of the other using only one call to substring.
 */
public class RotationCheck {

  public boolean isRotation(String original, String rotation) {
    return StringUtils.contains((rotation + rotation), original);
  }
}
