package de.dhbw.demo.tdd;

import java.util.List;

@SuppressWarnings("ALL")
public class TrainObserverSecondRefactoring {

    /*
     * Add transition names, because we can have more than one target state:
     *
     *                       + [target state 1]
     *         transition A /
     *                     /
     * [source state] ----+
     *                     \
     *         transition B \
     *                       + [target state 2]
     */

    List<Transition> states = List.of(
        new Transition("departed","start","riding"),
        new Transition("departed","teleport","arrived"),
        new Transition("riding","arrive","arrived")
        // ... more transitions can go here ...
    );

    public String nextState(String sourceState, String transition) {
        Transition _transition = states.stream()
                .filter(t -> t.from.equals(sourceState) &&
                             t.transition.equals(transition))
                .findFirst()
                .orElse(
                        new Transition(null,null, "unknown")
                );
        return _transition.to;
    }

    private class Transition {
        String from;
        String transition;
        String to;

        public Transition(String from, String transition, String to) {
            this.from = from;
            this.transition = transition;
            this.to = to;
        }
    }
}
