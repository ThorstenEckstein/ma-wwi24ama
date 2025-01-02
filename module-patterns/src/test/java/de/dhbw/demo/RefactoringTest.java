package de.dhbw.demo;

import de.dhbw.demo.refactoring.AfterRefactoring;
import de.dhbw.demo.refactoring.BeforeRefactoring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefactoringTest {

	@Test
	public void beforeRefactoring() {
		// given
		BeforeRefactoring processor = new BeforeRefactoring();
		StringBuilder out = new StringBuilder();
		String ERR_KEY = "invalid input";

		// when
		processor.process(ERR_KEY, 3, out, "172563.988");

		// then
		assertEquals("   invalid input: 172563.988", out.toString());
	}

	@Test
	public void afterRefactoring() {
		// given
		AfterRefactoring processor = new AfterRefactoring();
		String ERR_KEY = "invalid input";

		// when
		String out = processor.process(ERR_KEY, 3, "172563.988");

		// then
		assertEquals("   invalid input: 172563.988", out);
	}

}