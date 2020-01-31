package edu.iis.powp.appext;

import edu.iis.powp.adapter.DrawerAdapter;
import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.events.predefine.SelectBasicLine;
import edu.iis.powp.events.predefine.SelectClearPanelOptionListener;
import edu.iis.powp.events.predefine.SelectDotLine;
import edu.iis.powp.events.predefine.SelectSpecialLine;
import edu.kis.powp.drawer.panel.DrawPanelController;

/**
 * Application.
 */
public class ApplicationWithDrawer {

    private static boolean isAppCreated = false;
	
    /**
     * Startup configuration.
     */
	public synchronized static void configureApplication()
	{
	    if (!isAppCreated)
	    {
	    	isAppCreated = true; 
	        
	    	Application.configureApplication();
	    	
	        Application.addComponent(DriverManager.class);
	        Application.addComponent(Context.class);
	        
	        Context context = Application.getComponent(Context.class);
	        
	        setupDrawerPlugin(context);
	        
	        context.setVisibility(true);	
	    }
	}

	/**
	 * Setup Drawer Plugin and add to context.
	 * 
	 * @param context Application context.
	 */
	private static void setupDrawerPlugin(Context context) {    
		SelectClearPanelOptionListener selectClearPanelOptionListener = new SelectClearPanelOptionListener();
	
		Application.addComponent(DrawerAdapter.class);
		context.addComponentMenu(DrawerAdapter.class, "Draw Panel", 0);
		context.addComponentMenuElement(DrawerAdapter.class, "Clear Panel", selectClearPanelOptionListener);
		
		Application.addComponent(LinePlotterAdapter.class);
		context.addComponentMenu(LinePlotterAdapter.class, "Line Panel", 3);
		context.addComponentMenuElement(LinePlotterAdapter.class, "Basic Line", new SelectBasicLine());
		context.addComponentMenuElement(LinePlotterAdapter.class, "Dotted Line", new SelectDotLine());
		context.addComponentMenuElement(LinePlotterAdapter.class, "Special Line", new SelectSpecialLine());
		
		//getDrawPanelController().initialize(context.getFreePanel());
		//getLineController().initialize(context.getFreePanel());
	}

	 /**
     * Get controller of application drawing panel.
     * 
     * @return drawPanelController.
     */
	public static DrawPanelController getDrawPanelController() {
		return Application.getComponent(DrawerAdapter.class);
	}
	
	public static DrawPanelController getLineController() {
		return Application.getComponent(LinePlotterAdapter.class);
	}

}
