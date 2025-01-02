package de.dhbw.demo.decorator.example2.decorator;

import de.dhbw.demo.decorator.example2.commands.Command;
import de.dhbw.demo.decorator.example2.record.Recorder;

public abstract class CommandDecorator implements Command {

	private Command command;
	
	// additional functionality
	private Recorder recorder;
	
	public CommandDecorator(Command command) {
		this.command = command;
		this.recorder = new Recorder();
	}

	public void execute() {
		command.execute();
	}

	public Recorder getRecorder() {
		return recorder;
	}

	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}

}