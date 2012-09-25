package org.openproj.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.projity.pm.graphic.gantt.Main;

public class WorkbenchActivator implements BundleActivator {
	private String[] formattedArgs;
	
	

	public WorkbenchActivator(String[] formattedArgs) {
		super();
		this.formattedArgs = formattedArgs;
	}

	public void start(BundleContext arg0) throws Exception {
		Main.main(formattedArgs);
	}

	public void stop(BundleContext arg0) throws Exception {
		if(Main.mainFrame != null) 
			Main.mainFrame.dispose();
	}

}
