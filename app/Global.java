

import java.util.Date;

import models.AppLogger;
import controllers.MomentMachineController;
import play.*;

public class Global extends GlobalSettings {

  @Override
  public void onStart(Application app) {
	AppLogger.addNew(new AppLogger(MomentMachineController.appName, "APP START", new Date().toString(), "", "null"));
    Logger.info("Glogal: OnStart: Application has started...");
    //Logger.info("Glogal: OnStart: Starting INITInstagram...");
    MomentMachineController.initFacebook();
  }  
  
  @Override
  public void onStop(Application app) {
	AppLogger.addNew(new AppLogger(MomentMachineController.appName, "APP END", new Date().toString(), "", "null"));
    Logger.info("Global: OnStop: Application shutdown...");
    
  }  
    
}