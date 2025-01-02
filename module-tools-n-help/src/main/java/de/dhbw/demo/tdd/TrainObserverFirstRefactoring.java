package de.dhbw.demo.tdd;

import java.util.List;

@SuppressWarnings("ALL")
public class TrainObserverFirstRefactoring {

    // Hier könnte noch viel verbessert werden ... was zum Beispiel?

    /*
     * A simple set of states:
     *
     * Generic:
     * [source state] --> [next state] ---> [next state]
     *
     * Example:
     * [departed] --> [riding] ---> [arrived]
     */

    List<String> states = List.of(
            /* 0 */ "departed",
            /* 1 */ "riding",
            /* 2 */ "arrived"
    );

    public String nextState(String sourceState) {
        int sourceStateIndex = states.indexOf(sourceState);
        String targetState = states.get(sourceStateIndex + 1);

        return targetState;
    }
}
