package de.dhbw.enums.exercises;

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

        // Hier: 'switch' anstelle der 'if-elseif-else' Ausdrücke ...

        if (this == Color.Red) { // base color to mix with ...

            if (color == Color.Blue) {
                return Color.Lila;
            } else if (color == Color.Green) {
                return Color.Brown;
            }
            // ... more "else if(...)" to mix red with other colors ...
            else {
                return Color.Unknown;
            }

        }

        // ... same for other base colors

        return Unknown;
    }

}