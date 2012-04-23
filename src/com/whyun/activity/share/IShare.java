package com.whyun.activity.share;

import java.util.HashMap;

import com.whyun.activity.share.bean.ShareUrl;

public interface IShare {
	/**
	 * http://www.kaixin001.com/~repaste/repaste.php?
	 * &rurl=http://whyun.com&rtitle=dddd&rcontent=cesi
	 * */
	public static final int KAI_XIN = 1;
	/**
	 * http://share.renren.com/share/buttonshare?
	 * link=http://www.whyun.com&title=
	 * */
	public static final int REN_REN = 2;//
	/**
	 * 新浪微博分享url格式：
	 * http://v.t.sina.com.cn/share/share.php?title=xx
	 * */
	public static final int XIN_LANG_WEI_BO = 3;//
	/**
	 * 
	 * */
	public static final int BAI_DU_SOU_CANG = 4;
	/**
	 * */
	public static final int YAHU_SHOU_CANG = 5;
	/**
	 * http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?
	 * url=whyun.com&title=cesh
	 * */
	public static final int QQ_ZONE = 6;
	
	/**
	 * http://v.t.qq.com/share/share.php?title=xx
	 * */
	public static final int TENG_XUN_WEI_BO = 7;//
	
	/**
	 * http://www.douban.com/recommend/
	 * ?title=&url=
	 * */
	public static final int DOU_BAN = 8;
	
	/**
	 * http://t.sohu.com/third/post.jsp?
	 * url=&title=&content=&pic=
	 * */
	public static final int SOHU_WEI_BO = 9;
	
	/** 
	 * http://t.163.com/article/user/checkLogin.do?
	 * source=&info=&images=
	 *  */
	public static final int WANG_YI_WEI_BO = 10;
	
	public static final HashMap<Integer,ShareUrl/*urlname,titlename,contentname*/> urlMap
		= new HashMap<Integer,ShareUrl>() {
			private static final long serialVersionUID = 1L;

		{
			put(KAI_XIN,new ShareUrl("http://www.kaixin001.com/~repaste/repaste.php?",
					"rurl","rtitle","rcontent"));
			put(REN_REN,new ShareUrl("http://share.renren.com/share/buttonshare?",
					"link","title",null));
			put(XIN_LANG_WEI_BO,new ShareUrl("http://v.t.sina.com.cn/share/share.php?",
					null,"title",null));
			put(TENG_XUN_WEI_BO,new ShareUrl("http://v.t.qq.com/share/share.php?",
					null,"title",null));
			put(SOHU_WEI_BO,new ShareUrl("http://t.sohu.com/third/post.jsp?",
					"url","title","content"));
			put(WANG_YI_WEI_BO,new ShareUrl("http://t.163.com/article/user/checkLogin.do?",
					null,"info",null));
		}
	};
	
}
