package de.dhbw.enums.demo;

public enum Color {
    Red,
    Green,
    Blue,
    Yellow,
    Brown,
    Lila,
    Orange,
    Unknown;

    public String getPalette() {
        return "RGB";
    }

    /*
     * Info zum 'logischen UND':
     *
     *  &  : Wertet immer beide Operanden aus
     *  && : Wertet den ersten Operanden aus, und ist dieser 'false', wird der
     *        zweite nicht ausgewertet, und das Gesamtergebnis wird 'false'
     *
     */

    public Color mix(Color color) {
        if (this == Red && color == Green) {
            return Brown;
        }
        else if (this == Red && color == Blue) {
            return Lila;
        }
        else if (this == Red && color == Yellow) {
            return Orange;
        }
        // ... maybe more cases ...
        else {
            return Unknown;
        }
    }

}