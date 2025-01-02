package de.dhbw.demo.adapter;

/**
 * <b>Description </b>: This class is a specialization of the more general SelfMadeRenderEngine which is able to render not
 * only maps, also other 2D- or 3D-Shapes etc. This class here is only needed to handle special purposes when rendering
 * map's. But we don't want to implement it manually because we know that the purchased API already provides a valid
 * render mechanism that can be used.
 */
public class SelfMadeMapRenderEngine extends SelfMadeRenderEngine {

    private ProprietaryRenderEngine proprietaryRenderEngine;

    /**
     * Constructor taking an instance of some proprietary render engine to use it internally by delegating client calls
     * to that "remote" engine.
     *
     * @param proprietaryRenderEngine The proprietary render engine.
     */
    public SelfMadeMapRenderEngine(ProprietaryRenderEngine proprietaryRenderEngine) {
        this.proprietaryRenderEngine = proprietaryRenderEngine;
        super.isDrawing = proprietaryRenderEngine.isCurrentlyDrawing();
    }

    /**
     * This method overides that one implemented in SelfMadeRenderEngine. It forwards client calls (as a wrapper) to some
     * proprietary methods/code.
     */
    @Override
    public String renderMap() {
        String publishingUrl = this.proprietaryRenderEngine.render();
        super.isDrawing = true;
        return publishingUrl;
    }

}
