package de.dhbw.javadoc.exercises;

//tag::improve-javadoc[]
public interface XmlAdapter {

    String toXml(String plainText);

    // Purpose: xml --> plain text (string)
    String fromXml(String xml) throws Exception;

    String adapt(String xmlOrPlainText) throws Exception;

}
//end::improve-javadoc[]