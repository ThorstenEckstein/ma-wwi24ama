package de.dhbw.demo.proxy;

/* 
 * These classes are the sample implementation of the GoF Proxy pattern. 
 * Following UML shows the general intention.<br>
 * <br>
 * <b>Notes:</b><br>
 *  There are four types of proxies, all taking the same basic format:<br>
 *   1. Virtual Proxy - The proxy won't create an "expensive" subject object
 *      until it is actually needed.<br>
 *   2. Remote Proxy - A local proxy object controls access to a remote
 *      subject object.<br>
 *   3. Protection proxy - The proxy insures that the object creating/calling
 *      the subject has authorization to do so.<br>
 *   4. Smart reference - The proxy will perform "additional actions" when
 *      the subject is called. <br>
 * <br>
 * <code><pre>
 * 
 *              +--------------------------+
 *              | RenderEngine (Interface) |
 *              +-------------/ \----------+
 *                             | 
 *           +------impl.------+-------impl.----+
 *           |                                  |
 * +---------+---------+   delegates   +--------+--------+ 
 * | RenderEngineProxy |-------------->| MapRenderEngine |
 * +-------------------+               +-----------------+
 * </pre></code>
 * 
 * <b>Description </b>: This class is the Proxy class within this pattern. It 
 *    implements the mandatory engine interface. It controls instantiation of
 *    and access to the concrete render engine implementation (here the map
 *    renderer) with its one and only method render as prescribed by the
 *    interface.
 */
public class RenderEngineProxy implements RenderEngine {

	/**
	 * <code><pre>
	 * 	// who does it
	 *	System.out.println("Primary call occured to "+getClass().getSimpleName());
	 *	// instantiation control over concrete implementation(s)
	 *	MapRenderEngine mapRenderEngine = new MapRenderEngine();
	 *	// access control over concrete implementation(s)
	 *	return mapRenderEngine.render();
	 * </pre></code>
	 */
	public String render() throws RenderException {
		// instantiation control over concrete implementation(s)
		MapRenderEngine mapRenderEngine = new MapRenderEngine();
		// access control over concrete implementation(s)
		return mapRenderEngine.render();
	}

}
