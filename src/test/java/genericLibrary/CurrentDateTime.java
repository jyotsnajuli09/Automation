package genericLibrary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime {
	
	public static String get_datetimestampinmillisec() {
		  Date date = new Date();
		
	    SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    String format=  dateformat.format(date);
	    return format;
	}
	public static String get_datetimestamp(){
        Date date = new Date();
//      format date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
     
        String format = dateFormat.format(date);
        return format;

        }
	
	public static String get_datetimestampinmin()
	{
	       Date date = new Date();
//	      format date
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm");
	     
	        String format = dateFormat.format(date);
	        return format;

	        }
	
	public static String get_datetimestampinhour()
	{
	       Date date = new Date();
//	      format date
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh");
	     
	        String format = dateFormat.format(date);
	        return format;

	        }
	}
	
