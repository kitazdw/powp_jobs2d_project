package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.preset.FiguresJane;
import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.adapter.FigureJaneAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.FactoryRectangle;
import edu.iis.powp.command.FactorySquare;
import edu.kis.powp.drawer.panel.DrawPanelController;

public class SelectTestFigureOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Context context = Application.getComponent(Context.class);
		DrawPanelController draw = (DrawPanelController) Application.getComponent(DriverManager.class)
				.getCurrentPlotter();
		draw.initialize(context.getFreePanel());
		switch (e.getActionCommand()) {
		case "Figure Joe 1":
			FiguresJoe.figureScript1(Application.getComponent(DriverManager.class).getCurrentPlotter());
			break;
		case "Figure Joe 2":
			FiguresJoe.figureScript2(Application.getComponent(DriverManager.class).getCurrentPlotter());
			break;
		case "Figure Jane":
			FiguresJane.figureScript(
					new FigureJaneAdapter(Application.getComponent(DriverManager.class).getCurrentPlotter()));
			break;
		case "Figure Rectangle":
			FactoryRectangle rectangle = new FactoryRectangle();
			rectangle.drawRectangle().execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
			break;
		case "Figure Square":
			FactorySquare square = new FactorySquare();
			square.drawRectangle().execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
			break;
		}

	}
}
