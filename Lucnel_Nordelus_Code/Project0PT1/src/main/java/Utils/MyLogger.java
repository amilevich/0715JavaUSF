package Utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger {
    
    static{
        PropertyConfigurator.configure("src/properties/log4j.properties");
    }
    static Logger log = Logger.getLogger(MyLogger.class.getName());
    
    public static void log(String msg){
        log.info(msg);
    }
}
