package com.whyun.activity.share;

import android.os.Bundle;

import com.whyun.activity.share.bean.ShareUrl;

public class KaiXinShareActivity extends AbstractShareActivity {
	private static final ShareUrl SHARE_URL 
		= ShareUrlFactory.getInstance(IShare.KAI_XIN);

	public KaiXinShareActivity() {
		super(SHARE_URL);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}	
}
