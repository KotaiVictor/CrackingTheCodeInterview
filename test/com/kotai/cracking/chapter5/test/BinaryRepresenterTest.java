package com.kotai.cracking.chapter5.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter5.BinaryRepresenter;

public class BinaryRepresenterTest {

  private BinaryRepresenter representer = new BinaryRepresenter();

  @Test
  public void representer_handles_out_of_bounds_numbers() {
    assertThat(representer.representInBinary(1), equalTo(BinaryRepresenter.ERROR_MESSAGE));
    assertThat(representer.representInBinary(-0.1), equalTo(BinaryRepresenter.ERROR_MESSAGE));
  }

  @Test
  public void representer_handles_an_easy_case() {
    assertThat(representer.representInBinary(0.625), equalTo("0.101"));
    assertThat(representer.representInBinary(0.125), equalTo("0.001"));
  }

  @Test
  public void representer_cant_display_value() {
    assertThat(representer.representInBinary(0.33), equalTo(BinaryRepresenter.ERROR_MESSAGE));
    assertThat(representer.representInBinary(0.2), equalTo(BinaryRepresenter.ERROR_MESSAGE)); // 0.001100110011...
  }
}
