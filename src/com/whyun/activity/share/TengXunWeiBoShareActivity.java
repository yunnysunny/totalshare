package com.whyun.activity.share;

import com.whyun.activity.share.bean.ShareUrl;

public class TengXunWeiBoShareActivity  extends AbstractShareActivity {
	private static final ShareUrl SHARE_URL 
	= ShareUrlFactory.getInstance(IShare.TENG_XUN_WEI_BO);

	public TengXunWeiBoShareActivity() {
		super(SHARE_URL);
	}
}
