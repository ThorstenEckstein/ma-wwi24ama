package de.dhbw.demo.adapter;

/**
 * <b>Description </b>: This class is meant to be a single general interface to access some rendering mechanism while
 * not specifying what algorithm resp. implementation to use (this will be decided at runtime dependent on the class
 * type as specified when the "render" method hers is called). The UML diagram for this adapter pattern is shown below:
 *
 * <pre>
 *                         +-------------------+
 *                         |    RenderEngine   |
 *                         +-------------------+
 *                                   / \
 *                                    | implements
 *                                    |
 * +-----------------+      +----------------------+
 * | Renderer        | uses | SelfMadeRenderEngine |
 * +-----------------+      +----------------------+
 *                    u              / \
 *                     s              | extends
 *                      e             |
 *                       s +----------------------+            +------------------------+
 *                         | SelfMadeMapRenderEngine >-- calls --> ProprietaryRenderEngine |
 *                         +----------------------+            +------------------------+
 * </pre>
 */
public class Renderer {

    /**
     * Renders "something" ;-) using the specified render engine.
     *
     * @param localRenderEngine The engine to use.
     * @return the render result.
     */
    public String render(RenderEngine localRenderEngine) {
        return localRenderEngine.renderMap();
    }

}
