package de.dhbw.demo.strategy;

import de.dhbw.demo.model.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintContext {

    private Map<String, Object> items;

    public PrintContext(){
        items = new HashMap<>();
    }

    public PrintContext add(String key, Object value) {
        items.put(key, value);
        return this;
    }

    public PrintContext entity(Entity entity) {
        return add("entity", entity);
    }

    public Object get(String key) {
        return items.get(key);
    }

    public Map<String, Object> getItems() {
        return items;
    }

    public void setItems(Map<String, Object> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return items.keySet().stream()
                .map(key -> key + "=" + items.get(key))
                .collect(Collectors.joining(", "));
    }
}
