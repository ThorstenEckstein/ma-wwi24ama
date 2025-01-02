package de.dhbw.commons;

public class Colourizer {

    public static final int BLACK = 30;
    public static final int RED = 31;
    public static final int GREEN = 32;
    public static final int YELLOW = 33;
    public static final int BLUE = 34;
    public static final int MAGENTA = 35;
    public static final int CYAN = 36;
    public static final int WHITE = 37;
    public static final int DEFAULT = 39;

    /**
     * Returns a colourized text for better console output.
     * <pre>
     *  +~~~~~~+~~~~~~+~~~~~~~~~~~+
     *  |  fg  |  bg  |  color    |
     *  +~~~~~~+~~~~~~+~~~~~~~~~~~+
     *  |  30  |  40  |  black    |
     *  |  31  |  41  |  red      |
     *  |  32  |  42  |  green    |
     *  |  33  |  43  |  yellow   |
     *  |  34  |  44  |  blue     |
     *  |  35  |  45  |  magenta  |
     *  |  36  |  46  |  cyan     |
     *  |  37  |  47  |  white    |
     *  |  39  |  49  |  default  |
     *  +~~~~~~+~~~~~~+~~~~~~~~~~~+
     * </pre>
     * @param colour the colour to use
     * @param text the text to colourize
     * @return the colourized text
     */
    public static String colourize(int colour, String text) {
        if (colour < 30 || colour > 39) {
            throw new IllegalArgumentException("Please use a valid text colour (30 - 39)!");
        }
        return String.format(escape() + "%s%s" + terminate(), sequence(colour), text);
    }

    public static String black(String text) {
        return colourize(BLACK, text);
    }

    public static String red(String text) {
        return colourize(RED, text);
    }

    public static String green(String text) {
        return colourize(GREEN, text);
    }

    public static String yellow(String text) {
        return colourize(YELLOW, text);
    }

    public static String blue(String text) {
        return colourize(BLUE, text);
    }

    public static String magenta(String text) {
        return colourize(MAGENTA, text);
    }

    public static String cyan(String text) {
        return colourize(CYAN, text);
    }

    public static String white(String text) {
        return colourize(WHITE, text);
    }

    /**
     * Returns the 'ESC' symbol that is required to begin an escape sequence (see ASCII characters)
     * @return the ESC symbol that begins an escape sequence
     */
    private static char escape() {
        return (char)27;
    }

    /**
     * Returns expression for 'terminate escape sequence'
     * @return the escape sequence termination signal
     */
    private static String terminate() {
        return escape() + "[0m";
    }

    /**
     * Returns the specified colour as escape sequence.
     * <pre>
     *  +~~~~~~+~~~~~~+~~~~~~~~~~~+   +~~~~~+~~~~~~~~~~~~~~~~~~+
     *  |  fg  |  bg  |  color    |   |  n  |  effect          |
     *  +~~~~~~+~~~~~~+~~~~~~~~~~~+   +~~~~~+~~~~~~~~~~~~~~~~~~+
     *  |  30  |  40  |  black    |   |  0  |  reset           |
     *  |  31  |  41  |  red      |   |  1  |  bold            |
     *  |  32  |  42  |  green    |   |  2  |  faint*          |
     *  |  33  |  43  |  yellow   |   |  3  |  italic**        |
     *  |  34  |  44  |  blue     |   |  4  |  underline       |
     *  |  35  |  45  |  magenta  |   |  5  |  slow blink      |
     *  |  36  |  46  |  cyan     |   |  6  |  rapid blink*    |
     *  |  37  |  47  |  white    |   |  7  |  inverse         |
     *  |  39  |  49  |  default  |   |  8  |  conceal*        |
     *  +~~~~~~+~~~~~~+~~~~~~~~~~~+   |  9  |  strikethrough*  |
     *                                +~~~~~+~~~~~~~~~~~~~~~~~~+
     * * not widely supported
     * ** not widely supported and sometimes treated as inverse
     * </pre>
     * @param colour the colour (see static constants)
     * @return the colour surrounded with escape sequence chars
     */
    private static String sequence(int colour) {
        return "[" + colour + "m";
    }

}
