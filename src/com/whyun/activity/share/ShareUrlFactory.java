package com.whyun.activity.share;

import com.whyun.activity.share.bean.ShareUrl;

public final class ShareUrlFactory {
	
	public static ShareUrl getInstance(int i) {
		return IShare.urlMap.get(i);
	}
}
