package org.example;

import java.math.BigDecimal;

public class StringCalculator {


  public static final String SEPARATORE_VIRGOLA = ",";

  public String add(String numbers) {

    if (numbers.isEmpty()) {
      return "0";
    }
    String numbersConSoloVirgole = numbers.replace("\n", SEPARATORE_VIRGOLA);
    if(isDoppioSeparatore(numbersConSoloVirgole)) {
      int posizioneErrore = numbersConSoloVirgole.indexOf(",,") + 1;
      return "Number expected but '\n' found at position " + posizioneErrore +".";
    }
    String[] arrayDiNumeri = map(numbersConSoloVirgole);
    return somma(arrayDiNumeri);
  }

  private static boolean isDoppioSeparatore(String numbersConSoloVirgole) {
    return numbersConSoloVirgole.contains(",,");
  }

  private static String somma(String[] arrayDiNumeri) {
    BigDecimal somma = BigDecimal.ZERO;
    for (String split : arrayDiNumeri) {
      BigDecimal bd = new BigDecimal(split);
      somma = somma.add(bd);
    }
    return somma.toString();
  }

  private static String[] map(String numbersConSoloVirgole) {
    return numbersConSoloVirgole.split(SEPARATORE_VIRGOLA);
  }

  private static String ultimoCarattere(String s) {
    return String.valueOf(s.charAt(s.length() - 1));
  }
}
