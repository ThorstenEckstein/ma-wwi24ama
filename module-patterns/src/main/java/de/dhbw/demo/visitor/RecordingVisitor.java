package de.dhbw.demo.visitor;

public interface RecordingVisitor {

	public void visit(CreateCommandVisitee createCommand);
	
	public void visit(UpdateCommandVisitee updateCommand);

}