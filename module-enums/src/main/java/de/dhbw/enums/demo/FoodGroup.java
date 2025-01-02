package de.dhbw.enums.demo;

import java.util.Arrays;

@SuppressWarnings("SpellCheckingInspection")
public enum FoodGroup {
    Milchprodukte("Milchprodukte"),
    BroteUndKleingebaecke("Brote, Kleingebäcke"),
    HuelsenfruechteUndSchalenobst("Hülsenfruechte, Schalenobst"),
    Fruchtsaefte("Fruchtsäfte"),
    Suesswaren("Süßwaren"),
    Sonstiges("Sonstiges")
    ;

    private final String label;

    // Sollte das enum hier vielleicht "public" sein?
    FoodGroup(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static FoodGroup from(String label) {
        return Arrays.stream(FoodGroup.values())
                .filter(fg -> fg.getLabel().equals(label))
                .findFirst()
                .orElse(FoodGroup.Sonstiges);
    }

}