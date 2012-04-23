package com.whyun.choose;

import whyun.com.choose.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.whyun.IConst;

public class ChooserActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImageView share = (ImageView)findViewById(R.id.share);
        
        share.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Intent.ACTION_SEND);
		        intent.setType("text/plain");
		        intent.putExtra(Intent.EXTRA_SUBJECT, IConst.SHARE_TITLE);
		        intent.putExtra(Intent.EXTRA_TEXT, IConst.SHARE_CONTENT);
		        startActivity(Intent.createChooser(intent, "分享到"));
			}
		});
        
          
    }
}