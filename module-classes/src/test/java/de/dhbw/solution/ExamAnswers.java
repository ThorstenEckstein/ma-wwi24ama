package de.dhbw.solution;

import de.dhbw.commons.Answer;
import de.dhbw.commons.Answers;

@SuppressWarnings("ALL")
public class ExamAnswers extends Answers {

    static {
        answers.put(Q1, Answer.fromMany("B","C"));
        answers.put(Q2, Answer.fromExplanation("""
                Ein Objekt wird zuerst deklariert, dann instanziiert, dann initialisiert.
                
                1. Deklaration    : Die Variablendeklaration mit einem Variablennamen und einem Objekttyp                                                                                                                                
                2. Instanziierung : Das Schlüsselwort „new“ wird zum Erstellen des Objekts verwendet                                                                                                                             
                3. Initialization : Auf das Schlüsselwort „new“ folgt ein Aufruf eines Konstruktors. 
                                    Dieser Aufruf initialisiert das neue Objekt.
                """)
        );
    }

    //
    // Demonstrations for questions
    // May not compile, therefore some elements commented
    //

    private class DemoForQ1 {

        //Test t1 = new Test();
        Test t2 = new Test(1);
        Test t3 = new Test(1, 2);
        //Test t4 = new Test(1, 2, 3);
        //Test t6 = new Base();

        public class Base {
            public Base(){}
            public Base(int j, int k){}
        }
        public class Test extends Base {
            public Test(int j) {}
            public Test(int j, int k) { super(j, k); }
        }
    }

}