package com.kotai.cracking.chapter1.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter1.UniqueStringCharacters;

public class UniqueStringCharTest {

  private UniqueStringCharacters tester = new UniqueStringCharacters();

  @Before
  public void setup() {
    tester = new UniqueStringCharacters();
  }

  @Test
  public void method_identifies_strings() {
    assertThat(tester.isStringCharacterUnique("abcdefh"), equalTo(true));
    assertThat(tester.isStringCharacterUnique("aabcdefgh"), equalTo(false));
    assertThat(tester.isStringCharacterUnique(StringUtils.EMPTY), equalTo(true));
  }

}
