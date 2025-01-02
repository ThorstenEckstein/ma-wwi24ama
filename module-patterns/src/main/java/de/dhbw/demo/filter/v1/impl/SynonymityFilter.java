package de.dhbw.demo.filter.v1.impl;

import de.dhbw.demo.filter.v1.DefaultFilter;
import de.dhbw.demo.filter.v1.FilterChain;
import de.dhbw.demo.filter.v1.FilterException;
import de.dhbw.demo.filter.v1.mock.Subject;
import de.dhbw.demo.filter.v1.mock.Candidate;

public class SynonymityFilter extends DefaultFilter {

	@Override
	public void doFilter(Subject subject, Candidate candidate, FilterChain filterChain)
			throws FilterException {
		
		if (subject == null)
			throw new FilterException();
		
		if (true /* check synonmymity*/)
			candidate.commit();

		filterChain.doFilter(subject, candidate);
	}

}