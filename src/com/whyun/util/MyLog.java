package com.whyun.util;

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
	
	public void showLog(int level,String msg,Throwable e) {
		if (level < IConst.TOP_LEVEL_LOG) {
			//不做操作
		} else {
			String msgStr = "[" + LOG_LEVEL_STR.get(level) + "]"
				+ "["+tag + "]" + msg;
			Log.println(level, androidTag, msgStr);
			if (e != null) {
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
		info(msg,null);
	}
	
	public void warn(String msg,Throwable e) {
		showLog(WARN,msg,e);
	}
	
	public void warn(String msg) {
		info(msg,null);
	}
	
	public void error(String msg,Throwable e) {
		showLog(ERROR,msg,e);
	}
	
	public void error(String msg) {
		info(msg,null);
	}
}
