package de.dhbw.demo.classes;

public class AComplexClass {

    public String aField;

    public AComplexClass() { }

    /**
     * Zugriffsmethode für das Feld (das Feld selbst sollte 'private' sein, hier nur zur Demonstration 'public')
     */
    public String getAField() {
        return aField;
    }

    /**
     * Methoden-Deklaration mit Parameter
     */
    public String aMethod(String parameter) {
        return parameter;
    }

}