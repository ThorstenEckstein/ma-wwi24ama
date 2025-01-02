package de.dhbw.demo.observer;

/**
 * <b>Description </b>: This class is a prototype implementation of some
 * "observed subject", which will notify/update any attached observer if
 * this object is changed ("state-changed" event) on calling one of the 
 * setter methods (here only: setName()).
 */
public class ObservableMap implements Observable {

	/**
	 * The list of attached/registered observer objects.
	 */
	private Observer[] observers = new Observer[5];
	/**
	 * The number of currently attached observer objects.
	 */
	private int observerCount = 0;
	/**
	 * The name of this observed subject.
	 */
	private String name;
	/**
	 * Creates a new observable subject identifeid by some specified name.
	 * @param name The nema of this observable subject.
	 */
	public ObservableMap(String name) {
		this.name = name;
	}
	/**
	 * Attaches/registres a new observing object on this subject.
	 * @param observer The observing object instance to attach.
	 */
	public void attach(Observer observer) {
		observers[observerCount++] = observer;
	}
	/**
	 * Detaches/unregisters some currently observing object.
	 * @param observer The observer to detach.
	 */
	public void detach(Observer observer) {
		for (int i=0; i < observerCount; ++i) {
			if (observers[i] == observer) {
				--observerCount;
				for (;i < observerCount; ++i) {
					observers[i] = observers[i+1];
				}
				break;
			}
		}
	}
	/**
	 * Returns the name of this concrete observed subject.
	 * @return the name of this concrete observed subject.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the new name of this observed subject. A call to this method is a
	 * "state-change" event a causes the notification/update to all attached
	 * (currently observing) observer objects.
	 * @param name The new name of this observed subject.
	 */
	public void setName(String name) {
		this.name = name;
		notifyObserver();
	}
	/**
	 * Notifies all attached observers by calling their <code>update</code> 
	 * methods. This mechanism can also be called "firing 'state-change' event".
	 */
	private void notifyObserver() {
		for (int i=0; i<observerCount; i++) {
			observers[i].update(this);
		}
	}

}
