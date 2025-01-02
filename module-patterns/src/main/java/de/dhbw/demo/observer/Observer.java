package de.dhbw.demo.observer;

/**
 * <b>Description </b>: This interfaces represents all observer objects 
 *    watching the observed subject, which is also called the "Observable".
 *    This implementation uses the "push-notification" (=observed subjects 
 *    calls update on the observing, attached observer objects) mechanism.
 */
public interface Observer {

	/**
	 * Every observer must implement this <code>update</code> method, which 
	 * contains the behaviour what shall happen/be done, if the observed subject
	 * fires a "state-changed" event to it's attached observers. Generally that 
	 * will occure e.g. on calling a setter method of the observed subject.
	 * @param subject The observed subject (implementor of interface Subject)
	 */
	void update(Observable subject);
	
}
