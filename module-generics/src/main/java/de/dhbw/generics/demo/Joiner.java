package de.dhbw.generics.demo;

import java.util.Collection;
import java.util.Iterator;

// tag::generic-class[]
public class Joiner<T> {

    public String join(Collection<T> collection) {
        StringBuilder builder = new StringBuilder();
        Iterator<T> iterator = collection.stream().iterator();

        builder.append("[");
        while (iterator.hasNext()) {
            T item = iterator.next();
            final String formattedItem =
                    iterator.hasNext()
                            ? String.format("%s, ", item)
                            : String.format("%s", item);
            builder.append(formattedItem);
        }
        builder.append("]");

        return builder.toString();
    }
}
//end::generic-class[]
