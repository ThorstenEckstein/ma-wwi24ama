package de.dhbw.demo.proxy;

/**
 * <b>Description </b>: This interface is the one which must be implemented
 *    by either ther proxy itself as well as the concrete (real) implementation
 *    of some real algorithm, such as here the real map rendering process.
 */
public interface RenderEngine {

	/**
	 * Renders "something" ... ;-)
	 * @return the rendering result (here: a file within filesystem)
	 * @throws RenderException
	 */
	String render() throws RenderException;
	
}
