package de.dhbw.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("CastCanBeRemovedNarrowingVariableType")
public class DatatypesDemoTest {

    @Test
    @DisplayName("Demo : Datentypen & Umwandlung von primitiven Typen")
    public void demo1() {
        // given :: primitive Datentypen
        char     c = '\u0000'; // Zeichen, UTF-16 Code mit Wert 0
        byte     b = 0;
        short   sh = 0;
        int      i = 0;
        long     l = 0L;
        float    f = 0.0f;
        double   d = 0.0;
        boolean bl = false;

        // when & then - widening (implicit conversion)

        /*
        b = 97;
        System.out.println("Initialwert von 'b': " + b);
        System.out.println("Initialwert von 'i': " + i);
        */
        //i = b;
        //System.out.println("byte    -> int     : " + i);

        /*
        i = 2_500_000;
        System.out.println("Initialwert von 'i': " + i);
        System.out.println("Initialwert von 'd': " + d);
        */
        //d = i;
        //System.out.println("int     -> double  : " + d);

        // when & then - narrowing (explicit casting)

        /*
        sh = 4_000;
        System.out.println("Initialwert von 'sh': " + sh);
        System.out.println("Initialwert von 'b' : " + b);
        */
        //b = sh;
        //b = (byte)sh;
        //System.err.println("short   -> byte     : " + b);

        /*
        l = 1_987_654_321_000L;
        System.out.println("Initialwert von 'l': " + l);
        System.out.println("Initialwert von 'i': " + i);
        */
        //i = l;
        //i = (int)l;
        //System.err.println("long     -> int    : " + i);


        /*
        // given :: komplexe Datentypen
        String   s = null;
        long[] arr = {}; // leeres Array

        s = "true";
        //bl = s;
        //bl = Boolean.valueOf(s);
        System.err.println("String  -> Boolean : " + bl);
        */
    }

    @Test
    @DisplayName("Demo : Datentypen & Umwandlung von komplexen Java-Typen")
    public void demo2() {
        // given :: komplexe Standard-Datentypen
        boolean bl = false;
        String   s = null;
        long[] arr = {}; // leeres Element vom Typ 'Array', deklariert durch die eckigen Klammern

        s = "true";
        //bl = s;
        //bl = Boolean.valueOf(s);
        System.err.println("String  -> Boolean : " + bl);
    }

    @Test
    @DisplayName("Demo : Down-Casting von Objekttypen")
    public void demo3() {
        // given
        Train train = new RegionalTrain("RB 21", "Baureihe 123");

        // when
        String trainNumber = train.getNumber();

        // when: down-casting
        RegionalTrain regionalTrain = (RegionalTrain) train;
        String type = regionalTrain.getType();

        System.out.println(trainNumber);
        System.out.println(type);
    }

}
