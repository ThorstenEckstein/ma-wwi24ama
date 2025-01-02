package de.dhbw.javadoc.solution;

/**
 * Class doc
 */
public interface XmlAdapter {

    /**
     * Method doc
     * @param plainText the text
     * @return value
     */
    String toXml(String plainText);

    /**
     * Method doc
     * @param xml xml
     * @return value
     * @throws Exception an exception
     */
    String fromXml(String xml) throws Exception;

    /**
     * Method doc
     * @param xmlOrPlainText the text
     * @return value
     * @throws Exception an exception
     */
    String adapt(String xmlOrPlainText) throws Exception;

}