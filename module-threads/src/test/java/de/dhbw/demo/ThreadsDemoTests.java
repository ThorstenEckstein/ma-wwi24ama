package de.dhbw.demo;

import de.dhbw.demo.ex1.BasicThreadApp;
import de.dhbw.demo.ex2.CreateThreadWay1App;
import de.dhbw.demo.ex3.CreateThreadWay2App;
import de.dhbw.demo.ex4.CreateThreadWay3App;
import de.dhbw.demo.ex5.GetCurrentThreadNameApp;
import de.dhbw.demo.ex6.TwoThreadsApp;
import de.dhbw.demo.ex7.ThreadSleepApp;
import de.dhbw.demo.ex8.StoppableRunnableApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("All")
public class ThreadsDemoTests {

    //tag::synchronized-list[]
    @Test
    @DisplayName("Demo 1: Nutzung von 'synchronized'")
    public void demo1() {
        // given
        List<String> unsyncedList = new ArrayList<>();
        unsyncedList.add("E1");
        unsyncedList.add("E2");
        unsyncedList.add("E3");

        // when
        List<String> syncedList = Collections.synchronizedList(unsyncedList);

        /*
        // Iterieren über die Liste, aber ...
        Iterator<String> i = syncedList.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        */

        // Iteration must be in synchronized block
        synchronized (syncedList) {
            Iterator<String> i = syncedList.iterator();
            while (i.hasNext()) {
                System.out.println(i.next());
            }
        }

        // then
        // no assertion, just to demonstrate 'synchronized'
    }
    //end::synchronized-list[]

    @Test
    @DisplayName("Example 1: /ex1/BasicThreadApp")
    public void ex1() {
        // given
        String[] args = null;

        // when
        BasicThreadApp.main(args);

        // then - nothing to assert
    }

    @Test
    @DisplayName("Example 2: /ex2/CreateThreadWay1App")
    public void ex2() {
        // given
        String[] args = null;

        // when
        CreateThreadWay1App.main(args);

        // then - nothing to assert
    }

    @Test
    @DisplayName("Example 3: /ex3/CreateThreadWay2App")
    public void ex3() {
        // given
        String[] args = null;

        // when
        CreateThreadWay2App.main(args);

        // then - nothing to assert
    }

    @Test
    @DisplayName("Example 4: /ex4/CreateThreadWay3App")
    public void ex4() {
        // given
        String[] args = null;

        // when
        CreateThreadWay3App.main(args);

        // then - nothing to assert
    }

    @Test
    @DisplayName("Example 5: /ex5/GetCurrentThreadNameApp")
    public void ex5() {
        // given
        String[] args = null;

        // when
        GetCurrentThreadNameApp.main(args);

        // then - nothing to assert
    }

    @Test
    @DisplayName("Example 6: /ex6/TwoThreadsApp")
    public void ex6() {
        // given
        String[] args = null;

        // when
        TwoThreadsApp.main(args);

        // then - nothing to assert
    }

    @Test
    @DisplayName("Example 7: /ex7/ThreadSleepApp")
    public void ex7() {
        // given
        String[] args = null;

        // when - EXECUTE main() DIRECTLY!
        ThreadSleepApp.main(args);

        // then - nothing to assert
    }

    @Test
    @DisplayName("Example 8: /ex8/StoppableRunnableApp")
    public void ex8() {
        // given
        String[] args = null;

        // when
        StoppableRunnableApp.main(args);

        // then - nothing to assert
    }

}