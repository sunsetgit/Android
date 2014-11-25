package com.example.android.button;

import java.util.ArrayList;
import java.util.List;

import com.example.android.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * 复选
 * 
 * @author Administrator
 *
 */
public class Checkbox extends Activity implements OnClickListener {

	private List<CheckBox> checkBoxs = new ArrayList<CheckBox>();
	private Button checkBtn;

	public Checkbox() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		chooseMethod(true);// 选择加载方式
		checkBtn = (Button) findViewById(R.id.checkBtn);
		checkBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String s = "";
		// 循环checkBoxs
		for (CheckBox i : checkBoxs) {
			if (i.isChecked()) {
				// 如果选中就添加结果到msg中
				s += i.getText();
			}
		}
		if ("".equals(s)) {
			s = "您没有选中选项";
		}
		// 使用对话框弹出选中的信息
		new AlertDialog.Builder(this).setMessage(s)
				.setPositiveButton("Exit", null).show();
	}

	private void chooseMethod(boolean b) {
		String[] chenckBoxText = new String[] { "你是学生?", "你是男孩?", "你在中国?" };
		if (b) {
			// 使用文本中提到的第一种方式.通过id动态加载
			setContentView(R.layout.checkbox_layout);
			// 获得带填充的布局控件
			LinearLayout linearLayout = (LinearLayout) this
					.findViewById(R.id.checkLayout);
			// 根据数组循环添加内容
			for (int i = 0; i < chenckBoxText.length; i++) {
				CheckBox checkBox = new CheckBox(this);
				checkBoxs.add(checkBox);
				checkBoxs.get(i).setText(chenckBoxText[i]);
				// 把checkBox加入到布局控件中
				linearLayout.addView(checkBox);
			}
		} else {
			// 通过动态填充的方式,找到布局文件
			LinearLayout linearLayout = (LinearLayout) getLayoutInflater()
					.inflate(R.layout.checkbox_layout, null);
			for (int i = 0; i < chenckBoxText.length; i++) {
				// 在通过动态填充的方式找到checkbox的文件
				CheckBox checkbox = (CheckBox) getLayoutInflater().inflate(
						R.layout.checkbox, null);
				checkBoxs.add(checkbox);
				checkBoxs.get(i).setText(chenckBoxText[i]);
				linearLayout.addView(checkbox);
			}
			// 最后把这个布局文件加载显示
			setContentView(linearLayout);
		}
	}
}
