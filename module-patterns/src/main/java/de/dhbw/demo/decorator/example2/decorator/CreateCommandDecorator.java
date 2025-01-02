package de.dhbw.demo.decorator.example2.decorator;

import de.dhbw.demo.decorator.example2.commands.Command;

public class CreateCommandDecorator extends CommandDecorator {

	public CreateCommandDecorator(Command command) {
		super(command);
	}

	@Override
	public void execute() {
		getRecorder().record("  recording 'create' execution!");
		super.execute();
	}

}