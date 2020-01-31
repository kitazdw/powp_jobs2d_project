package edu.iis.powp.command;

public class FactoryRectangle {

	public ComplexCommand drawRectangle() {
		ComplexCommand command = new ComplexCommand();
		command.add(new CommandSetPosition(-20, -20));
		command.add(new CommandDrawLineToPosition(-20, 50));
		command.add(new CommandDrawLineToPosition(100, 50));
		command.add(new CommandDrawLineToPosition(100, -20));
		command.add(new CommandDrawLineToPosition(-20, -20));
		return command;
	}

}
