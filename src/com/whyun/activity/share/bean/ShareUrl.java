package com.whyun.activity.share.bean;

import java.util.HashMap;

public class ShareUrl {
	private String baseUrl;
	private String urlLinkName;
	private String titleName;
	private String contentName;	
	private HashMap<String,String> extraData
		= new HashMap<String,String>();
	
	/**
	 * Instantiates a new share url.
	 *
	 * @param baseUrl the base url
	 * @param urlLinkName the url link
	 * @param titleName the title
	 * @param contentName the content
	 * @param extraData the extra data
	 */
	public ShareUrl(String baseUrl, String urlLinkName, String titleName, String contentName,
			HashMap<String,String> extraData) {
		this.baseUrl = baseUrl;
		this.urlLinkName = urlLinkName;
		this.titleName = titleName;
		this.contentName = contentName;
		if (extraData != null) {
			this.extraData = extraData;
		}
	}
	
	public ShareUrl(String baseUrl, String urlLink, String title, String content) {
		this(baseUrl,urlLink,title,content,null);
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getUrlLinkName() {
		return urlLinkName;
	}

	public void setUrlLinkName(String urlLinkName) {
		this.urlLinkName = urlLinkName;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public HashMap<String, String> getExtraData() {
		return extraData;
	}

	public void setExtraData(HashMap<String, String> extraData) {
		this.extraData = extraData;
	}		
}
