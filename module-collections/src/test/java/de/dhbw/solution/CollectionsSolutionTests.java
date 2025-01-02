
package de.dhbw.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* ----------------------------------------------------------------
 * Im test-package 'exercises' bzw. in dieser Testklasse können
 * einfach eigene Tests oder Experimente geschrieben werden.
 * ------------------------------------------------------------- */

public class CollectionsSolutionTests {

    @Test
    @DisplayName("""
            Übung 1: Schreibe einen Test, in dem eine konkrete Implementierung von `List` und den
            Datentyp `Integer` benutzt wird. Befülle diese mit beliebig vielen Einträgen. Summiere
            alle Listeneinträge mithilfe einer `for-each` Schleife.
            """)
    public void solution1() {
        // given
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(6);

        // when
        Integer total = 0;
        for (Integer i : list) {
            total += i;
        }
        // total = list.stream().reduce(0, Integer::sum);

        // then
        assertEquals(10, total);
    }

    @Test
    @DisplayName("""
            Übung 2: Schreibe einen Test, in dem eine konkrete Implementierung von `SortedMap` benutzt wird.
            Befülle diese mit mindestens 5 Einträgen, nutze dazu `String` sowohl für den Schlüssel (K) also auch
            für den Wert (V).
            
            Überprüfe die Haupt-Charakteristik "natürliche Sortierung" dieses Map-Typs mithilfe von 'assertEquals'.
            """)
    public void solution2() {
        // given
        Map<String, String> map = new TreeMap<>();

        // when
        map.put("K4","V4");
        map.put("K1","V1");
        map.put("K5","V5");
        map.put("K3","V3");
        map.put("K2","V2");

        // then
        assertEquals("[K1, K2, K3, K4, K5]", map.keySet().toString());
    }

}