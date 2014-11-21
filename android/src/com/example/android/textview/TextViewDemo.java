package com.example.android.textview;

import com.example.android.R;
import com.example.android.R.id;
import com.example.android.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * textView
 * 
 * @author Administrator 注意:在编写layout.xml文件时,文件的命名要唯一,否则
 *         R.layout.xx自动生成就会失败,R.id.xx同样;
 */
public class TextViewDemo extends Activity {

	private TextView textView1, textView2;

	public TextViewDemo() {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_view);
		// 通过两个id获得两个textView控件
		textView1 = (TextView) findViewById(R.id.textView_1);
		textView2 = (TextView) findViewById(R.id.textView_2);

		// 设置需要显示的字符串
		String html = "<font color='red'>Hello android</font></br>";
		html += "<font color='#0000ff'><big><i>Hello android</i></big></font><p> ";
		html += "<big><a href='http://www.baidu.com'>百度</a></big></p>";
		// 使用Html.fromHtml,把含html标签的字符串转换成可显示的文本样式
		CharSequence charSequence = Html.fromHtml(html);
		// 通过setText给TextView赋值
		textView1.setText(charSequence);
		// 设定一个点击相应
		textView1.setMovementMethod(LinkMovementMethod.getInstance());

		String text = "我的URL:http://www...\n";//\n换行
		text += "我的email:xxx@sina.com\n";
		text += "我的电话:110";
		// 因为textView2中有autoLink="all"的属性设定,所以会自动识别对应的链接,点击出发对应的链接
		textView2.setText(text);
	}

}
