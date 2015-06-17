package com.whyun.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import android.util.Log;

import com.whyun.IConst;

public class MyLog {
	public static final int ERROR = Log.ERROR;
	public static final int WARN = Log.WARN;
	public static final int INFO = Log.INFO;
	public static final int DEBUG = Log.DEBUG;
	
	private static final HashMap<Integer,String> LOG_LEVEL_STR
		= new HashMap<Integer,String>() {
			private static final long serialVersionUID = 1L;

		{
			put(ERROR,"ERROR");
			put(WARN,"WARN");
			put(INFO,"INFO");
			put(DEBUG,"DEBUG");
		}
	};
	
	private String tag;
	private static final String androidTag = "handle";
    private static final String ERROR_LOG = "/sdcard/error.log";
	
	protected MyLog() {
		
	}
	
	protected MyLog(String tag) {
		this.tag = tag;		
	}
	
	public static MyLog getLogger(String tag) {
		return new MyLog(tag);
	}
	
	public static MyLog getLogger(Class<?> tag){
		if (tag != null) {
			return getLogger(tag.getName());
		} else {
			return getLogger("");
		}
	}

    private void writeErrorLog(String msg,Throwable e) {
        RandomAccessFile in = null;
        PrintWriter printWriter = null;
        try{
            in = new RandomAccessFile(ERROR_LOG, "rw");
            //append to file end
            long length = in.length();
            in.seek(length);
            StringWriter writer = new StringWriter();
            printWriter = new PrintWriter( writer );
            e.printStackTrace( printWriter );
            printWriter.flush();

            String stackTrace = writer.toString();

            Log.println(ERROR, androidTag, stackTrace);
            SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
            String d=dateformat1.format(new Date());
            in.write(('['+d+']'+msg).getBytes());
            in.write(stackTrace.getBytes());

        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
	
	public void showLog(int level,String msg,Throwable e) {
		if (level < IConst.TOP_LEVEL_LOG) {
			//不做操作
		} else {
			String msgStr = "[" + LOG_LEVEL_STR.get(level) + "]"
				+ "["+tag + "]" + msg;
			Log.println(level, androidTag, msgStr);
			if (e != null) {
                writeErrorLog(msg,e);
				e.printStackTrace();
			}
		}
	}
	
	public void showLog(int level,String msg) {
		showLog(level,msg,null);
	}
	
	public void info(String msg,Throwable e) {
		showLog(INFO,msg,e);
	}
	
	public void info(String msg) {
		info(msg,null);
	}
	
	public void debug(String msg,Throwable e) {
		showLog(DEBUG,msg,e);
	}
	
	public void debug(String msg) {
		debug(msg,null);
	}
	
	public void warn(String msg,Throwable e) {
		showLog(WARN,msg,e);
	}
	
	public void warn(String msg) {
		warn(msg,null);
	}
	
	public void error(String msg,Throwable e) {
		showLog(ERROR,msg,e);
	}
	
	public void error(String msg) {
		error(msg,null);
	}
}
