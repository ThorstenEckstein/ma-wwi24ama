package de.dhbw.demo.observer;

/**
 * <b>Description </b>: This class is a prototype implementation of some
 * "observing object", which will be updated by any "state-changed" event of
 * the observed subject (here: on calling setName() of the subject).
 */
public class MapObserver implements Observer {
	/**
	 * The identifier of this observer implementation. 
	 * Only a private member for some tests.
	 */
	private int id;
	/**
	 * Creates a new observer instance using some identifier.
	 * @param id The identifier if this new observer instance.
	 */
	public MapObserver(int id) { 
		this.id = id; 
    }
	
	/**
	 * Implementation of the interface method <code>update</code>. This method
	 * will be called, if the observed subject is changed (it notifies this
	 * observer instance by calling this <code>update</code> method).
	 * @see Observer#update(
	 *                    Observable)
	 */
	public void update(Observable subject) {
		System.out.println("Observer "+id+" got an update map-name event" +
				           ", it is now: "+subject.getName());
	}

}
