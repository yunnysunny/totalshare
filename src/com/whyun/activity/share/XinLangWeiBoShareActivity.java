package com.whyun.activity.share;

import com.whyun.activity.share.bean.ShareUrl;

public class XinLangWeiBoShareActivity extends AbstractShareActivity {
	private static final ShareUrl SHARE_URL 
	= ShareUrlFactory.getInstance(IShare.XIN_LANG_WEI_BO);

	public XinLangWeiBoShareActivity() {
		super(SHARE_URL);
	}
}
