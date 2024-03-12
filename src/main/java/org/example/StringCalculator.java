package org.example;

import java.math.BigDecimal;

public class StringCalculator {


  public static final String SEPARATORE_VIRGOLA = ",";
  public static final String SEPARATORE_NEW_LINE = "\n";
  public static final String SEPARATORE_DOPPIA_VIRGOLA = ",,";

  public String add(String numbers) {

    if (numbers.isEmpty()) {
      return "0";
    }
    if(String.valueOf(numbers.charAt(numbers.length() - 1)).equals(SEPARATORE_VIRGOLA)) {
      return "Number expected but EOF found.";
    }
    String numbersConSoloVirgole = numbers.replace(SEPARATORE_NEW_LINE, SEPARATORE_VIRGOLA);
    if(isDoppioSeparatore(numbersConSoloVirgole)) {
      return messaggioDiErrore(numbers, numbersConSoloVirgole);
    }
    String[] arrayDiNumeri = map(numbersConSoloVirgole);
    return somma(arrayDiNumeri);
  }

  private static String messaggioDiErrore(String numbers, String numbersConSoloVirgole) {
    int posizioneErrore = numbersConSoloVirgole.indexOf(SEPARATORE_DOPPIA_VIRGOLA) + 1;
    return "Number expected but '" + numbers.charAt(posizioneErrore) + "' found at position "
        + posizioneErrore + ".";
  }

  private static boolean isDoppioSeparatore(String numbersConSoloVirgole) {
    return numbersConSoloVirgole.contains(SEPARATORE_DOPPIA_VIRGOLA);
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
