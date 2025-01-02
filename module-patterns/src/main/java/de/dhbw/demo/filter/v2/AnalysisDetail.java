package de.dhbw.demo.filter.v2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnalysisDetail<CT> {

	private Long id;
	private Integer concurrencyToken;
	
	private int directive;

	private CT candidate;
	
	private boolean committed;
	
	private Map<String, Object> detailItems;

	public AnalysisDetail() {
		super();
		this.setCommitted(false);
	}

	public AnalysisDetail(CT candidate, int directive) {
		super();
		this.candidate = candidate;
		this.directive = directive;
		this.detailItems = new HashMap<String, Object>(); 
		this.setCommitted(false);
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

	public int getDirective() {
		return directive;
	}

	public void setDirective(int directive) {
		this.directive = directive;
	}

	public String getReadableDirective() {
		return String.valueOf(directive);
	}

	public CT getCandidate() {
		return candidate;
	}

	public boolean hasCandidate() {
		return candidate != null;
	}

	public void setCandidate(CT candidate) {
		this.candidate = candidate;
	}

	public void addDetailItem(String key, Object value) {
		if (this.detailItems == null)
			this.detailItems = new HashMap<String, Object>();
		this.detailItems.put(key, value);
	}

	public String getReadableDetailItems() {
		if (this.detailItems == null || this.detailItems.size() == 0) return "";
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = detailItems.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			Object value = detailItems.get(key);
			sb.append(key).append(": ").append(value.toString())
					.append(it.hasNext() ? ", " : "");
		}
		return sb.toString();
	}

	public Map<String, Object> getDetailItems() {
		return detailItems;
	}
	
	public Object getDetailItem(String key) {
		return this.detailItems.get(key);
	}

	public void setDetailItems(Map<String, Object> detailItems) {
		this.detailItems = detailItems;
	}

	public void setCommitted(boolean committed) {
		this.committed = committed;
	}

	public boolean isCommitted() {
		return committed;
	}

	public boolean isUncommitted() {
		return !committed;
	}

	@Override
	public String toString() {
		return "AnalysisDetail [id=" + id + ", directive=" + directive
				+ ", candidate=" + candidate + ", committed=" + committed
				+ ", detailItems=" + getReadableDetailItems() + "]";
	}

}