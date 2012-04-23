package com.whyun.activity.share;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import whyun.com.choose.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

import com.whyun.IConst;
import com.whyun.activity.component.CommBrowser;
import com.whyun.activity.share.bean.ShareUrl;
import com.whyun.util.MyLog;

public abstract class AbstractShareActivity extends Activity {
	protected String url;	
	protected WebView browser;
	protected ShareUrl shareUrl;
	
	public static final String INTENT_LINK_URL = "linkUrl";
	private MyLog logger = MyLog.getLogger(AbstractShareActivity.class);
	
	protected AbstractShareActivity(String url) {
		this.url = url;
	}
	
	private String getEncodeUrl(String orginalUrl) {
		try {
			return java.net.URLEncoder.encode(orginalUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 初始化要跳转的URL字符串.
	 *
	 * @param shareUrl ShareUrl类型的javabean对象，包含baseurl，还有关键的三个属性的名字
	 * @param userUrlLink 自定义的分享连接的url的值
	 * @param userTitle 自定义的分享标题的值
	 * @param userContent 自定义的分享内容的值
	 */
	private void initUrl(String userUrlLink,String userTitle,
			String userContent) {
		logger.debug("userUrlLink:" + userUrlLink + ",userTitle:" + userTitle
				+ ",userContent:" + userContent);
		if (shareUrl != null) {
			String baseUrl = shareUrl.getBaseUrl();
			
			if (baseUrl != null) {
				String urlLinkName = shareUrl.getUrlLinkName();
				String titleName = shareUrl.getTitleName();
				String contentName = shareUrl.getContentName();
				url = baseUrl;
				
				HashMap<String,String> data = shareUrl.getExtraData();
				if (data != null && data.size() > 0) {
					for(Map.Entry <String,   String>   entry   :   data.entrySet()) {
						String key = entry.getKey();
						String value = entry.getValue();
						//if (key.equals(urlLinkName) || key.equals(titleName) || key.equals(contentName))
						url +=  key + "=" + value + "&";
					}
				}
				
				if (urlLinkName != null && data.get(urlLinkName) == null) {
					String urlLinkValue = userUrlLink == null ? IConst.URL_LINK : userUrlLink;
					url += urlLinkName + "=" + getEncodeUrl(urlLinkValue) + "&";
				}
				
				String contentValue = userContent == null ? IConst.SHARE_CONTENT : userContent;
				if (contentName != null && data.get(contentName) == null) {					
					url += contentName + "=" + (contentValue);
				}			
				
				if (titleName != null && data.get(titleName) == null) {
					String titleValue = "";
					if (contentName == null) {
						titleValue = contentValue;
					} else {
						titleValue= userTitle == null ? IConst.SHARE_TITLE : userTitle;
					}
					logger.info("titleValue:" + titleValue);
					
					url += titleName + "=" + (titleValue)  + "&";
				}					
				
				if (url.endsWith("&")) {
					url = url.substring(0, url.length()-2);
				}
			} else {
				//
			}
		} else {
			//
		}
	}
	
	protected AbstractShareActivity(ShareUrl shareUrl) {
		this.shareUrl = shareUrl;
	}	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);//在标题栏上显示进度条
		setContentView(R.layout.web);
		browser = (WebView)findViewById(R.id.webview);
		Intent i = getIntent();
		String userUrlLink = i.getStringExtra(INTENT_LINK_URL);
		String userTitle = i.getStringExtra(Intent.EXTRA_SUBJECT);
		String userContent = i.getStringExtra(Intent.EXTRA_TEXT);
		initUrl(userUrlLink,userTitle,userContent);
		
		logger.info("the url to load is " + url);
		new CommBrowser(this,browser,url);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		browser = null;
	}	
}
