package de.dhbw.demo.strategy;

public class SwitchPrinter {

    public enum Format {
        Xml, Json;
    }

    //tag::switch-example-impl[]
    public void print(Format format, PrintContext context) {
        switch (format) {
            case Xml  -> printXml(context);
            case Json -> printJson(context);
            default   -> printPlain(context);
        }
    }
    //end::switch-example-impl[]

    private void printXml(PrintContext context) {
        System.out.println("<xml>" + context + "</xml>");
    }

    private void printJson(PrintContext context) {
        System.out.println("{" + context + "}");
    }

    private void printPlain(PrintContext context) {
        System.out.println(context);
    }

}