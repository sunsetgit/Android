package com.example.android.textview;


import com.example.android.MainActivity;
import com.example.android.R;
import com.example.android.R.id;
import com.example.android.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/**
 * 点击activity间跳转
 * 
 * @author Administrator
 *
 */
public class TextViewOnClick extends Activity {

	private TextView clickTextView1, clickTextView2, clickTextView3;

	public TextViewOnClick() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_view);

		clickTextView1 = (TextView) findViewById(R.id.textView_1);
		clickTextView2 = (TextView) findViewById(R.id.textView_2);
		clickTextView3 = (TextView) findViewById(R.id.textView_3);

		String text1 = "显示activity1";
		String text2 = "显示activity2";
		// 使用SpannableString存放字符串
		SpannableString spannableString = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);
		// 通过setSpan设定文本块相应的点击事件
		// 此处只设定文本的索引为2开始的文本块:acitivity1
		spannableString.setSpan(new ClickableSpan() {

			@Override
			public void onClick(View widget) {
				// TODO Auto-generated method stub
				// 导航到一个新的activity中
				Intent intent = new Intent(TextViewOnClick.this,
						MainActivity.class);
				startActivity(intent);
			}
		}, 2, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannableString2.setSpan(new ClickableSpan() {

			@Override
			public void onClick(View widget) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(TextViewOnClick.this,
						TextViewDemo.class);
				startActivity(intent);
			}
		}, 2, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		// 对textView文本进行赋值
		clickTextView1.setText(spannableString);
		// 设置点击相应
		clickTextView1.setMovementMethod(LinkMovementMethod.getInstance());
		clickTextView2.setText(spannableString2);
		clickTextView2.setMovementMethod(LinkMovementMethod.getInstance());
	}

}
