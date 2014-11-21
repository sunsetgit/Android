package com.example.android.textview;

import java.lang.reflect.Field;

import com.example.android.R;
import com.example.android.R.drawable;
import com.example.android.R.id;
import com.example.android.R.layout;

import android.R.color;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * textView 显示img
 * 
 * @author Administrator
 *
 */
public class TextViewForImg extends Activity {

	private TextView textViewImg;

	public TextViewForImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_view);

		textViewImg = (TextView) findViewById(R.id.textImg_1);
		textViewImg.setTextColor(color.white);
		textViewImg.setBackgroundColor(color.black);
		textViewImg.setTextSize(20);
		// 设定html标签样式,图片3为一个超链接标签
		String html = "图像1<img src='image1'/>图像2<img src='image2'/>\n";
		html += "图像3<a href='http://www.baidu.com'><img src='image3'/></a>";
		// fromhtml中imageGetter选择html中<img>图片资源
		CharSequence charSequence = Html.fromHtml(html, new ImageGetter() {

			@Override
			public Drawable getDrawable(String source) {
				// TODO Auto-generated method stub
				// source为html字符串中的定义的<img>的src的内容
				// 返回值Frawable就是对应的<img>显示的图片资源
				Drawable draw = null;
				if (source.equals("image1")) {
					draw = getResources().getDrawable(R.drawable.image1);
					draw.setBounds(0, 0, draw.getIntrinsicWidth(),
							draw.getIntrinsicHeight());
				} else if (source.equals("image2")) {
					// 设置image2尺寸等比缩小
					draw = getResources().getDrawable(R.drawable.image2);
					draw.setBounds(0, 0, draw.getIntrinsicWidth(),
							draw.getIntrinsicHeight());
				} else {
					// 使用反射会更简便,无需知道src与资源Id的对应关系
					draw = getResources().getDrawable(getResourceId(source));
					draw.setBounds(0, 0, draw.getIntrinsicWidth(),
							draw.getIntrinsicHeight());
				}
				return draw;
			}
		}, null);
		textViewImg.setText(charSequence);
		textViewImg.setMovementMethod(LinkMovementMethod.getInstance());
	}

	public int getResourceId(String source) {
		// 使用反射机制,通过属性名称,得到其内的值
		Field field;
		try {
			field = R.drawable.class.getField(source);
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
