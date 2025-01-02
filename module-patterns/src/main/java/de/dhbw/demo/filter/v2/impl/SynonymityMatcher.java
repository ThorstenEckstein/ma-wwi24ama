package de.dhbw.demo.filter.v2.impl;

import de.dhbw.demo.filter.v2.AnalysisCase;
import de.dhbw.demo.filter.v2.AnalysisDetail;
import de.dhbw.demo.filter.v2.MatchException;
import de.dhbw.demo.filter.v2.Matcher;
import de.dhbw.demo.filter.v2.MatcherChain;
import de.dhbw.demo.filter.v2.mock.Candidate;
import de.dhbw.demo.filter.v2.mock.Subject;

public class SynonymityMatcher implements Matcher {

	@SuppressWarnings("unused")
	@Override
	public void matches(AnalysisCase<Subject, Candidate> analysisCase,
			Candidate candidate, MatcherChain matcherChain) throws MatchException {
		
		Subject subject = analysisCase.getSubject();
		
		if (subject == null) {
			throw new MatchException();
		}
		
		if (false /* check synonymity*/) {
			System.err.println("'" + this + "' matches! Exiting chain ...");
			AnalysisDetail<Candidate> detail = new AnalysisDetail<Candidate>();
			detail.setCandidate(candidate);
			analysisCase.addUncommittedCandidate(detail);
			matcherChain.resetProgressIndex();
		} else {
			System.out.println("'" + this + "' doesn't match ... proceeding to next matcher ...");
			// proceed to next matcher representing another check-algorithm 
			matcherChain.proceed(analysisCase, candidate);
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}