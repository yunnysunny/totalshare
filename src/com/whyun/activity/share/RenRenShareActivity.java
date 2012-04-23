package com.whyun.activity.share;

import com.whyun.activity.share.bean.ShareUrl;

public class RenRenShareActivity extends AbstractShareActivity  {
	
	private static final ShareUrl SHARE_URL 
	= ShareUrlFactory.getInstance(IShare.REN_REN);

	public RenRenShareActivity() {
		super(SHARE_URL);
	}
}
