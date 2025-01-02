package de.dhbw.demo.adapter;

/**
 * <b>Description </b>: This class represents some 3rd party implementation. It provides some proprietary code and may
 * be purchased from a vendor or the using client don't know the real code within this class (but is not an open source
 * class).
 */
public class ProprietaryRenderEngine {

    private boolean isCurrentlyDrawing;

    public ProprietaryRenderEngine() {
        isCurrentlyDrawing = false;
    }

    public boolean isCurrentlyDrawing() {
        return isCurrentlyDrawing;
    }

    public void setIsCurrentlyDrawing(boolean isCurrentlyDrawing) {
        this.isCurrentlyDrawing = isCurrentlyDrawing;
    }

    /**
     * Method to represent some complex algorithm provided by some proprietary API or product. The method implementation
     * is not visibly and thus not known by the calling client. Although this method figures its purpose not out, we
     * know that this method actually renders map's!
     *
     * @return The result of this render mechanism (here: the publishing location)
     */
    public String render() {
        this.isCurrentlyDrawing = true;
        System.out.println(getClass().getSimpleName() + " is now rendering the map ...");
        return " ... rendering finished ... publishing result at http://www.domain.de/map!";
    }

}
