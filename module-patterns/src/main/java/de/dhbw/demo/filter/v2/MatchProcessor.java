package de.dhbw.demo.filter.v2;

import de.dhbw.demo.filter.v2.mock.Candidate;
import de.dhbw.demo.filter.v2.mock.Subject;

public class MatchProcessor {

	private MatcherChain matcherChain = new MatcherChain();

	public void addMatcher(Matcher matcher) {
		matcherChain.add(matcher);
	}

	public MatcherChain getMatcherChain() {
		return matcherChain;
	}

	public void setMatcherChain(MatcherChain matcherChain) {
		this.matcherChain = matcherChain;
	}

	public void execute(
            AnalysisCase<Subject, Candidate> analysisCase, Candidate candidate)
			throws MatchException {
		matcherChain.proceed(analysisCase, candidate);
	}

}