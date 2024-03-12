package org.example;

import java.math.BigDecimal;

public class StringCalculator {


  public String add(String s) {

    if(s.isEmpty()) {
      return "0";
    } else {
      BigDecimal somma = BigDecimal.ZERO;
      String[] splits = s.split(",");
      for(String split : splits) {
        BigDecimal bd = new BigDecimal(split);
        somma = somma.add(bd);
      }
     return somma.toString();
    }
  }

  private static String ultimoCarattere(String s) {
    return String.valueOf(s.charAt(s.length() - 1));
  }
}
