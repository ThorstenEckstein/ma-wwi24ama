package de.dhbw.javadoc.exercises;

public class DefaultXmlAdapter implements XmlAdapter {

    @Override
    public String toXml(String plainText) {
        // add tags to text
        return "<tag>" + plainText + "</tag>";
    }

    @Override
    public String fromXml(String xml) throws Exception {
        // clear xml from tags
        return remove(xml, "<tag>", "</tag>");
    }

    @Override
    public String adapt(String xmlOrPlainText) throws Exception {
        // process to adapt omitted ...
        return null;
    }

    private String remove(String xml, String... tags) {
        final String WITH_NOTHING = "";
        String result = xml;
        for (String tag : tags) {
            result = xml.replace(tag, WITH_NOTHING);
        }
        return result;
    }

}