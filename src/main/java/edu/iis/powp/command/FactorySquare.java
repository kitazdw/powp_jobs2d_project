package edu.iis.powp.command;

public class FactorySquare {

	public ComplexCommand drawRectangle() {
		ComplexCommand command = new ComplexCommand();
		command.add(new CommandSetPosition(-20, -20));
		command.add(new CommandDrawLineToPosition(-20, 50));
		command.add(new CommandDrawLineToPosition(50, 50));
		command.add(new CommandDrawLineToPosition(50, -20));
		command.add(new CommandDrawLineToPosition(-20, -20));
		return command;
	}

}
