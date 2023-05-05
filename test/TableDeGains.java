package test;

import java.util.HashMap;
import java.util.Map;

public class TableDeGains {
  private Map < String, Integer[] > gains;

  public TableDeGains() {
    gains = new HashMap < > ();


    gains.put("A", new Integer[] {
      1000,
      2000,
      4000
    });
    gains.put("B", new Integer[] {
      750,
      1500,
      3000
    });
    gains.put("C", new Integer[] {
      500,
      750,
      1500
    });
    gains.put("D", new Integer[] {
      500,
      750,
      1500
    });
    gains.put("E", new Integer[] {
      300,
      500,
      1000
    });
    gains.put("F", new Integer[] {
      300,
      500,
      1000
    });
    gains.put("G", new Integer[] {
      300,
      500,
      1000
    });
    gains.put("H", new Integer[] {
      300,
      500,
      1000
    });
  
  }

  public int getGain(String symbole, int nombreDeSymboles) {
    if (gains.containsKey(symbole)) {
      Integer[] gainsSymbole = gains.get(symbole);
      if (nombreDeSymboles >= 3 && nombreDeSymboles <= 5) {
        return gainsSymbole[nombreDeSymboles - 3];
      }
    }

    return 0;
  }
}
