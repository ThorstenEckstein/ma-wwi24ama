package de.dhbw.demo.filter.v1.mock;

public class Candidate {

	private String name;
	
	private boolean committed = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void commit() {
		committed = true;
	}
	
	public void rollback() {
		committed = false;
	}
	
	public boolean isCommitted() {
		return committed;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Output [name=" + name + ", committed=" + committed + "]";
	}

}