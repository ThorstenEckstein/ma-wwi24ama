package de.dhbw.enums.solution;

public enum RgbColor {
    Red  (255,0,0),
    Green (0,255,0),
    Blue  (0,0,255),
    Black (0,0,0);

    private final int r;
    private final int g;
    private final int b;

    RgbColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String getRGB() {
        return "(" + r + "," + g + "," + b + ")";
    }
}