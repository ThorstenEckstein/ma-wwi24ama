package de.dhbw.demo.visibility;

public class VisibilityExampleClass {

    // what is the modifier here?

    // default, package-private = accessible in this package (all classes in "/visibility")
    String fieldA;

    // public = accessible from "everywhere"
    public String fieldB;

    // protected = accessible in this class, this package and subclasses
    protected String fieldC;

    // private = accessible only in this class
    private String fieldD;

}