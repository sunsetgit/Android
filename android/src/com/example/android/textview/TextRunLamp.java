package com.example.android.textview;

import com.example.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * 跑马灯效果
 * 
 * @author Administrator
 *
 */
public class TextRunLamp extends Activity {

	private TextView tvRunLamp;

	public TextRunLamp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.runlamp_layout);

		tvRunLamp = (TextView) findViewById(R.id.tvRunLamp);
		String html = "之前讲解Android布局的时候，就已经说明，所有<a href='http://www.cnblogs.com/plokmju/p/androidUI_Layout.html'>Layout</a>都是View的子类或者间接子类。而TextView也一样，是View的直接子类。它是一个文本显示控件，提供了基本的显示文本的功能，并且是大部分UI控件的父类，因为大部分UI控件都需要展示信息。";
		CharSequence cs = Html.fromHtml(html);
		tvRunLamp.setText(cs);
		// 因为文本中设定了一个<a>标签，这里设置响应。
		tvRunLamp.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
