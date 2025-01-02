package de.dhbw.solution.model;

public abstract class DefaultWagon implements Wagon {
    private int order;

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }

}