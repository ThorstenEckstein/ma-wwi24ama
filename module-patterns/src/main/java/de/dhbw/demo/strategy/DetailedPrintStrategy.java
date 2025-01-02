package de.dhbw.demo.strategy;

import de.dhbw.demo.model.Entity;
import de.dhbw.demo.template.AbstractPrintStrategy;

public class DetailedPrintStrategy extends AbstractPrintStrategy {

    @Override
    public void print(PrintContext context) {
        Entity entity = (Entity)context.get("entity");
        System.out.printf("ID=%s (%s)", entity.getId(), context.getItems());
    }

}