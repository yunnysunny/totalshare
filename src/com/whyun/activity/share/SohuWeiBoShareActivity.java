package com.whyun.activity.share;

import com.whyun.activity.share.bean.ShareUrl;

/**
 * The Class SohuWeiBoShareActivity.
 * 中文显示乱码
 */
public class SohuWeiBoShareActivity extends AbstractShareActivity {
	private static final ShareUrl SHARE_URL 
	= ShareUrlFactory.getInstance(IShare.SOHU_WEI_BO);

	public SohuWeiBoShareActivity() {
		super(SHARE_URL);
	}
}
