package com.whyun.activity.component;

import com.whyun.util.MyLog;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CommBrowser {
	private WebView browser;
	private String url;
	private boolean loadSuccess = false;
	private MyLog logger = MyLog.getLogger(CommBrowser.class);
	private Activity activity;

	public CommBrowser(Activity activity, WebView browser,String url) {
		this.activity = activity;
		this.browser = browser;
		this.url = url;
		init();
	}
	
	private void init() {
		WebSettings settings = browser.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setBuiltInZoomControls(false);//

		DisplayMetrics dm = new DisplayMetrics();
 		
 		if (dm.densityDpi == DisplayMetrics.DENSITY_HIGH) {
 			settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
 			logger.info("-------the desity is high.--------");
 		} else if (dm.densityDpi == DisplayMetrics.DENSITY_MEDIUM) {
 			settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
 			logger.info("-------the desity is medium.--------");
 		} else {
 			settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
 			logger.info("-------the desity is low.--------");
 		}
 			
 		
 		browser.setWebViewClient(new WebViewClient() { 			
 			 public boolean shouldOverrideUrlLoading(WebView view, String url) {
 				logger.info("the url now is " + url);
 				view.loadUrl(url);
 				return true;
 			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				logger.info("[pageStarted]url:" + url);
			}
 			
 		});	
 		browser.setWebChromeClient(new MyWebChromeClient()); 	
 		
 		try {			
 			browser.loadUrl(url); 		
 			loadSuccess = true;
 		} catch (Exception e) {
 			logger.error("load url:" + url + "failed.",e);
 		}
	}
	
	private final class MyWebChromeClient extends WebChromeClient {
		public boolean onJsAlert(WebView view, String url, String message,
				 final android.webkit.JsResult result) {
			logger.info(message);
			result.confirm();

			return false;
		}	
		public void onProgressChanged(WebView view, int progress) {  
            //Activity和Webview根据加载程度决定进度条的进度大小  
           //当加载到100%的时候 进度条自动消失  
			activity.setProgress(progress * 100);
		}  
    }

	public boolean isLoadSuccess() {
		return loadSuccess;
	}
}
