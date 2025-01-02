package de.dhbw.demo.template;

import de.dhbw.demo.strategy.PrintContext;
import de.dhbw.demo.strategy.PrintStrategy;

/**
 * Class providing a template method as defined by the "<b>template method
 * pattern</b>".
 *
 * <pre>
 *   +---------------------+
 *   |  <<abstract>>       |
 *   |  TemplateClass      |
 *   |   +templateMethod() |
 *   |   +abstract print() |
 *   +---------------------+
 *            /\
 *             | "extends"
 *             |
 *   +---------------------+
 *   |  ConcreteClass      |
 *   |   +print()          |
 *   +---------------------+
 * </pre>
 */
public abstract class AbstractPrintStrategy implements PrintStrategy {

    // abstract: must be overridden by subclasses
    public abstract void print(PrintContext context);

    // this method works as a template method, uses concrete and abstract method(s) to specify the basic algorithm
    public void templatePrint(PrintContext context) {

        // concrete
        before(context);

        // abstract
        print(context);

        // concrete
        after();

    }

    private void before(PrintContext context) {
        System.out.printf("[%s]\n", context.get("caller"));
    }

    private void after(){
        System.out.println("\n");
    }

}
