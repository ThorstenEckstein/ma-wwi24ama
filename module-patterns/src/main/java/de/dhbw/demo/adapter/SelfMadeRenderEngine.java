package de.dhbw.demo.adapter;

/**
 * <b>Description </b>: This class is some render implementation as part of a self-made Render-API. It provides some
 * drawing state and a general implementation of "drawing some map".
 */
public class SelfMadeRenderEngine implements RenderEngine {

    /**
     * Equivalent to the proprietary render engine, we also want to provide some "state-saving" member here.
     */
    boolean isDrawing = false;

    @Override
    public String renderMap() {
        isDrawing = true;
        System.out.println(getClass().getSimpleName() + " is now drawing a map ...");
        return " ... drawings finished ... saving result locally under c:/temp/myMap.png!";
    }

}
