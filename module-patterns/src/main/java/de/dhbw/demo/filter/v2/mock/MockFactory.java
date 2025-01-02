package de.dhbw.demo.filter.v2.mock;

import java.util.List;
import java.util.Vector;

import de.dhbw.demo.filter.v2.MatchProcessor;
import de.dhbw.demo.filter.v2.impl.EqualityMatcher;
import de.dhbw.demo.filter.v2.impl.IdentityMatcher;
import de.dhbw.demo.filter.v2.impl.SynonymityMatcher;

public class MockFactory {

	public MatchProcessor mockChainConfig() {
		MatchProcessor matchProcessor = new MatchProcessor();
		matchProcessor.addMatcher(new IdentityMatcher());
		matchProcessor.addMatcher(new EqualityMatcher());
		matchProcessor.addMatcher(new SynonymityMatcher());
		return matchProcessor;
	}

	public Subject mockSubject(String name) {
		Subject subject = new Subject();
		subject.setName(name);
		return subject;
	}

	public List<Candidate> mockCandidates(String... names) {
		Vector<Candidate> candidates = new Vector<Candidate>();
		for (String name : names) {
			Candidate candidate = mockCandidate(name);
			candidates.add(candidate);
		}
		return candidates;
	}

	private Candidate mockCandidate(String name) {
		Candidate candidate = new Candidate();
		candidate.setName(name);
		return candidate;
	}

}
