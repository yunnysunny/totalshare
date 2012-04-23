package com.whyun.activity.share;

import com.whyun.activity.share.bean.ShareUrl;

public class WangYiWeiBoShareActivity extends AbstractShareActivity {
	private static final ShareUrl SHARE_URL 
	= ShareUrlFactory.getInstance(IShare.WANG_YI_WEI_BO);

	public WangYiWeiBoShareActivity() {
		super(SHARE_URL);
	}
}
