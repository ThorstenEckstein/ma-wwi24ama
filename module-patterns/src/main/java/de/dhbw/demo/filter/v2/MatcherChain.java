package de.dhbw.demo.filter.v2;

import java.util.Vector;

import de.dhbw.demo.filter.v2.mock.Candidate;
import de.dhbw.demo.filter.v2.mock.Subject;

public class MatcherChain {

	private Vector<Matcher> matchers = new Vector<Matcher>();

	private int progressIndex = 0;
	private int chainSize = 0;

	public void add(Matcher matcher) {
		chainSize++;
		matchers.add(matcher);
	}

	public Vector<Matcher> getMatchers() {
		return matchers;
	}

	public void setMatchers(Vector<Matcher> matchers) {
		chainSize = matchers.size();
		this.matchers = matchers;
	}

	public void proceed(AnalysisCase<Subject, Candidate> analysisCase,
			Candidate candidate) throws MatchException {
		Matcher matcher = getNextMatcher();
		if (matcher != null) {
			matcher.matches(analysisCase, candidate, this);
		}
	}

	public void increaseProgressIndex() {
		progressIndex++;
	}

	public void resetProgressIndex() {
		progressIndex = 0;
	}

	private Matcher getNextMatcher() {
		Matcher matcher = null;
		if (progressIndex < chainSize) {
			matcher = matchers.elementAt(progressIndex);
			System.out.println("(" + progressIndex + ") Using '" + matcher + "'");
			increaseProgressIndex();
		} else {
			System.err.println("End of Queue reached");
			resetProgressIndex();
		}
		return matcher;
	}

}