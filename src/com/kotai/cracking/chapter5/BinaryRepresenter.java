package com.kotai.cracking.chapter5;

/*
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary
 * representation. If the number cannot be represented accurately in binary with at most 32
 * characters, print "ERROR."
 */
public class BinaryRepresenter {
  public static final String ERROR_MESSAGE = "ERROR";

  public String representInBinary(double number) {
    if (number >= 1 || number <= 0) {
      return ERROR_MESSAGE;
    }

    StringBuilder resultString = new StringBuilder();
    while (number > 0) {
      if (resultString.length() >= 32) {
        return ERROR_MESSAGE;
      }

      double result = number * 2;
      if (result >= 1) {
        resultString.append("1");
        number = result - 1;
      } else {
        resultString.append("0");
        number = result;
      }
    }
    return "0." + resultString.toString();
  }
}
