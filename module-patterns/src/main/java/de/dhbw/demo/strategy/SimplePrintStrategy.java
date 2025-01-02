package de.dhbw.demo.strategy;

import de.dhbw.demo.model.Entity;
import de.dhbw.demo.template.AbstractPrintStrategy;

public class SimplePrintStrategy extends AbstractPrintStrategy {

    @Override
    public void print(PrintContext context) {
        Entity entity = (Entity)context.get("entity");
        System.out.printf("ID=%s", entity.getId());
    }

}