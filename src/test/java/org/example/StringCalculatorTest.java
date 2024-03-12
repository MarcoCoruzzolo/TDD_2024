package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  @Test
  public void calcolaSomma_stringaVuota_stringaConValore0() {
  StringCalculator stringCalculator = new StringCalculator();

  String actual = stringCalculator.add("");

    Assertions.assertThat(actual).isEqualTo("0");
  }

  @Test
  public void calcolaSomma_stringaConUnValore_stringaConUnicoValore() {
    StringCalculator stringCalculator = new StringCalculator();

    String actual = stringCalculator.add("1");

    Assertions.assertThat(actual).isEqualTo("1");
  }

  @Test
  public void calcolaSomma_stringaConDueValori_stringaConSommaDeiDueValori() {
    StringCalculator stringCalculator = new StringCalculator();

    String actual = stringCalculator.add("1.1,2.2");

    Assertions.assertThat(actual).isEqualTo("3.3");
  }

  @Test
  public void calcolaSomma_stringaConNumeroValoriElevato_stringaConSommaDeiValori() {
    StringCalculator stringCalculator = new StringCalculator();

    String actual = stringCalculator.add("1,10,50,20,1.5,3.5");

    Assertions.assertThat(actual).isEqualTo("86.0");
  }

  @Test
  public void calcolaSomma_stringaConNewLineEVirgola_stringaConSommaDeiValori() {
    StringCalculator stringCalculator = new StringCalculator();

    String actual = stringCalculator.add("1\n2,3");

    Assertions.assertThat(actual).isEqualTo("6");
  }

  @Test
  public void calcolaSomma_stringaConNewLineEVirgola_messaggioDiErrore() {
    StringCalculator stringCalculator = new StringCalculator();

    String actual = stringCalculator.add("175.2,\n35");

    Assertions.assertThat(actual).isEqualTo("Number expected but '\n' found at position 6.");
  }

/*
  @Test
  public void calcolaSomma_stringaConValoreErrato_errore() {
    StringCalculator stringCalculator = new StringCalculator();

    String actual = stringCalculator.add("1,3,");

    Assertions.assertThat(actual).isEqualTo("Number expected but EOF found");
  }

 */

}