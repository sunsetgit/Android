package com.example.android.button;

import com.example.android.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.Button;

/**
 * 图文混排
 * 
 * @author Administrator
 *
 */
public class ButtonStyle extends Activity {

	private Button btnSty;

	public ButtonStyle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_style);

		// 获得按钮控件
		btnSty = (Button) findViewById(R.id.btnSty);
		// 生成spannableString,用于图片的载体
		SpannableString spannableLeft = new SpannableString("left");
		Bitmap bitmapleft = BitmapFactory.decodeResource(getResources(),
				R.drawable.image9);
		ImageSpan imageSpanLeft = new ImageSpan(ButtonStyle.this, bitmapleft);
		spannableLeft.setSpan(imageSpanLeft, 0, 4,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		SpannableString spannableRight = new SpannableString("right");
		Bitmap bitmapright = BitmapFactory.decodeResource(getResources(),
				R.drawable.image9);
		ImageSpan imageSpanRight = new ImageSpan(ButtonStyle.this, bitmapright);
		spannableRight.setSpan(imageSpanRight, 0, 5,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// 把生成的spannableStirng追加到按钮上
		btnSty.append(spannableLeft);
		btnSty.append("aLi");
		btnSty.append(spannableRight);
	}

}
