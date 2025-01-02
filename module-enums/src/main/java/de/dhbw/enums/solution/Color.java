package de.dhbw.enums.solution;

public enum Color {
    Red,
    Green,
    Blue,
    Yellow,
    Brown,
    Lila,
    Orange,
    Unknown;

    public Color mix(Color color) {

        // old-fashioned switch statement
        // if (this == Red) {
        //     switch (color) {
        //         case Green:  return Brown;
        //         case Blue:   return Lila;
        //         case Yellow: return Orange;
        //         default: return Unknown;
        //     }
        // }

        // modern way, so-called 'enhanced switch'
        if (this == Red) {
            switch (color) {
                case Green  -> { return Brown;  }
                case Blue   -> { return Lila;   }
                case Yellow -> { return Orange; }
            }
        }
        return Unknown;
    }

}