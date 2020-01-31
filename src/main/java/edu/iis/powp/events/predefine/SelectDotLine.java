package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.powp.app.Application;
import edu.kis.powp.drawer.shape.LineFactory;

public class SelectDotLine implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		LinePlotterAdapter linePlotterAdapter = Application.getComponent(LinePlotterAdapter.class);
		linePlotterAdapter.setLineStyle(LineFactory.getDottedLine());
	}
}
