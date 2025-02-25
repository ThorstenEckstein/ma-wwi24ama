package de.dhbw.demo.override;

public class PlatformDisplay extends DefaultDisplay {

    @Override
    public void update(int index, String row) {
        String shortenedRow = shorten(row);
        super.update(index, shortenedRow);
    }

    private String shorten(String row) {
        if (row == null)
            return "";

        if (row.length() > 10) {
            return row.substring(0,10) + "...";
        }

        return row;
    }
}