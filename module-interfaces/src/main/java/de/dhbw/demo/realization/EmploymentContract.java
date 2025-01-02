package de.dhbw.demo.realization;

//tag::interface[]
public class EmploymentContract implements Contract {

    private int id;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
//end::interface[]