package de.dhbw.demo.observer;

/**
 * <b>Description </b>: This interfaces represents all observed subjects 
 *    watched by the observing objects (observer). This implementation 
 *    uses the "push-notification" (=observed subjects calls update on the 
 *    observing, attached observer objects) mechanism.
 */
public interface Observable {

	/**
	 * Registers/attaches an observer instance to this observed subject. 
	 * Mandatory for the implementation of this "observer-observable" pattern.
	 * @param observer An instance of an obserser.
	 */
	void attach(Observer observer);
	/**
	 * Unregisteres/detaches an observer instance to this observed subject.
	 * Mandatory for the implementation of this "observer-observable" pattern.
	 * @param observer An instance of an obserser.
	 */
	void detach(Observer observer);
	/**
	 * Proprietary method of the observed subject, which can be called without
	 * knowledge of the concrete implementation of this interface. This method 
	 * is not required by the "observer-observable" pattern implementation.
	 * @return the name of this observed subject.
	 */
	String getName();
	/**
	 * Proprietary method of the observed subject, which can be called without
	 * knowledge of the concrete implementation of this interface. This method 
	 * is not required by the "observer-observable" pattern implementation.
	 * @param name The new name of the observed subject.
	 */
	void setName(String name);
	
}
