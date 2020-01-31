package edu.iis.powp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.appext.ApplicationWithDrawer;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;

public class TestPlotSoftPatterns {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static IPlotter linePlotter;

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param context
	 *            Application context.
	 */
	private static void setupPresetTests(Context context) {
		SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener();

		context.addTest("Figure Joe 1", selectTestFigureOptionListener);
		context.addTest("Figure Joe 2", selectTestFigureOptionListener);
		context.addTest("Figure Jane", selectTestFigureOptionListener);
		context.addTest("Figure Rectangle", selectTestFigureOptionListener);
		context.addTest("Figure Square", selectTestFigureOptionListener);
	}

	/**
	 * Setup driver manager, and set default IPlotter for application.
	 * 
	 * @param
	 */
	private static void setupDrivers(Context context) {
		IPlotter clientPlotter = new ClientPlotter();
		context.addDriver("Client Plotter", clientPlotter);
		Application.getComponent(DriverManager.class).setCurrentPlotter(clientPlotter);

		IPlotter plotter = (IPlotter) ApplicationWithDrawer.getDrawPanelController();
		context.addDriver("Buggy Simulator", plotter);

		linePlotter = (IPlotter) ApplicationWithDrawer.getLineController();
		context.addDriver("Line Simulator", linePlotter);

		context.updateDriverInfo();
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param context
	 *            Application context.
	 */
	private static void setupLogger(Context context) {
		Application.addComponent(Logger.class);
		context.addComponentMenu(Logger.class, "Logger", 0);
		context.addComponentMenuElement(Logger.class, "Clear log", (ActionEvent e) -> context.flushLoggerOutput());
		context.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> LOGGER.setLevel(Level.FINE));
		context.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> LOGGER.setLevel(Level.INFO));
		context.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> LOGGER.setLevel(Level.WARNING));
		context.addComponentMenuElement(Logger.class, "Severe level", (ActionEvent e) -> LOGGER.setLevel(Level.SEVERE));
		context.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> LOGGER.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ApplicationWithDrawer.configureApplication();
				Context context = Application.getComponent(Context.class);

				setupDrivers(context);
				setupPresetTests(context);
				setupLogger(context);
			}

		});
	}

}
