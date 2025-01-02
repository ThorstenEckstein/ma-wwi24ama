package de.dhbw.demo.filter.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnalysisCase<ST,CT> {

	private Long id;
	private Integer concurrencyToken;
	
	private String name;
	
	private ST subject;
	
	private Map<String, Object> metadata;
	
	// size == 0 => no match found!
	private List<AnalysisDetail<CT>> uncommittedCandidates;
	private List<AnalysisDetail<CT>> committedMatches;
	
	public AnalysisCase(String name) {
		super();
		this.name = name;
		this.metadata = new HashMap<String, Object>(); 
		this.uncommittedCandidates = new ArrayList<AnalysisDetail<CT>>();
		this.committedMatches = new ArrayList<AnalysisDetail<CT>>();
	}
	public AnalysisCase(String name, ST subject) {
		this(name);
		this.subject = subject;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getConcurrencyToken() {
		return concurrencyToken;
	}
	public void setConcurrencyToken(Integer concurrencyToken) {
		this.concurrencyToken = concurrencyToken;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ST getSubject() {
		return subject;
	}
	public void setSubject(ST subject) {
		this.subject = subject;
	}
	public boolean hasCandidates() {
		return !uncommittedCandidates.isEmpty();
	}
	public boolean isHasCandidates() {
		return hasCandidates();
	}
	public boolean addUncommittedCandidate(AnalysisDetail<CT> uncommittedCandidate) {
		return uncommittedCandidates.add(uncommittedCandidate);
	}
	public int getUncommittedCandidatesCount() {
		return uncommittedCandidates.size();
	}
	public List<AnalysisDetail<CT>> getUncommittedCandidates() {
		return uncommittedCandidates;
	}
	public void setUncommittedCandidates(List<AnalysisDetail<CT>> uncommittedCandidates) {
		this.uncommittedCandidates = uncommittedCandidates;
	}
	public boolean hasCommittedMatches() {
		return !committedMatches.isEmpty();
	}
	public boolean addCommittedMatch(AnalysisDetail<CT> committedMatch) {
		return committedMatches.add(committedMatch);
	}
	public List<AnalysisDetail<CT>> getCommittedMatches() {
		return committedMatches;
	}
	public void setCommittedMatches(List<AnalysisDetail<CT>> committedMatches) {
		this.committedMatches = committedMatches;
	}
	
	public void addMetadata(String key, Object value) {
		if (this.metadata == null)
			this.metadata = new HashMap<String, Object>();
		this.metadata.put(key, value);
	}

	public String getReadableMetadata() {
		if (this.metadata == null || this.metadata.size() == 0) return "";
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = metadata.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			Object value = metadata.get(key);
			sb.append(key).append(": ").append(value.toString())
					.append(it.hasNext() ? ", " : "");
		}
		return sb.toString();
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}
	
	public Object getMetadata(String key) {
		return this.metadata.get(key);
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}
	@Override
	public String toString() {
		return "AnalysisCase [id=" + id + ", name=" + name + ", subject="
				+ subject + ", metadata=" + metadata
				+ ", uncommittedCandidates=" + uncommittedCandidates.size()
				+ ", committedMatches=" + committedMatches.size() + "]";
	}
	
}