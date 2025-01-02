package de.dhbw.demo.decorator.example2.decorator;

import de.dhbw.demo.decorator.example2.commands.Command;

public class UpdateCommandDecorator extends CommandDecorator {

	public UpdateCommandDecorator(Command command) {
		super(command);
	}

	@Override
	public void execute() {
		getRecorder().record("  recording 'update' execution!");
		super.execute();
	}

}