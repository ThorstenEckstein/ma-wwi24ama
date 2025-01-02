package de.dhbw.model.routes;

import java.util.List;
import java.util.Objects;

public class Route {

    /**
     * Example name: WI-FFM
     */
    private String name;

    // 'final' represents composition (bound to the lifetime of parent class)
    private final List<Section> sections;

    public Route(String name, List<Section> sections) {
        this.name = name;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return name.equals(route.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Route{" +
                "name='" + name +
                '}';
    }
}
