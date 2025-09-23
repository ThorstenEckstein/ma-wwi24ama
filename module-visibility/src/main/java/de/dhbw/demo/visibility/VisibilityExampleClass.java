package de.dhbw.demo.visibility;

public class VisibilityExampleClass {

    // --------------------------- fields

    // what is the modifier here?

    // default, package-private = accessible in this package (all classes in "/visibility")
    String fieldA;

    // public = accessible from "everywhere"
    public String fieldB;

    // protected = accessible in this class, this package and subclasses
    protected String fieldC;

    // private = accessible only in this class
    private String fieldD;

    // --------------------------- c'tors

    public VisibilityExampleClass() {}

    //private VisibilityExampleClass() {}

    // --------------------------- methods

    //String getFieldA() {
    //protected String getFieldA() {
    //private String getFieldA() {
    public String getFieldA() {
        return fieldA;
    }

    //void setFieldA(String fieldA) {
    //public void setFieldA(String fieldA) {
    //public void setFieldA(String fieldA) {
    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

}