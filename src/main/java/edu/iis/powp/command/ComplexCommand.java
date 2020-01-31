package edu.iis.powp.command;

import java.util.Vector;

import edu.iis.client.plottermagic.IPlotter;

public class ComplexCommand implements PlotterCommand {

	Vector<PlotterCommand> plotterCommands = new Vector<PlotterCommand>();

	public void add(PlotterCommand command) {
		plotterCommands.add(command);
	}

	@Override
	public void execute(IPlotter plotter) {
		for (PlotterCommand iterator : plotterCommands) {
			iterator.execute(plotter);
		}
	}

}
