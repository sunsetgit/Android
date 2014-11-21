package com.example.android.button;

import com.example.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

/**
 * Button
 * 
 * @author Administrator 通过实现接口,对其进行click,touch事件的支持
 */
public class ButtonListener extends Activity implements OnClickListener,
		OnTouchListener {

	public ButtonListener() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Button btnChangeSize;
	private Button btnChangeImg;
	private int flag = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_layout);

		btnChangeSize = (Button) findViewById(R.id.btnChangeSize);
		btnChangeImg = (Button) findViewById(R.id.btnChangeImg);

		// 对两个按钮进行事件绑定
		btnChangeSize.setOnClickListener(this);
		btnChangeImg.setOnClickListener(this);
		//btnChangeImg.setOnTouchListener(this);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		// 获取触发事件的Button控件
		Button btn = (Button) v;
		if (event.getAction() == MotionEvent.ACTION_UP) {
			// 当触摸时按下,则替换展示图片为image1
			btn.setBackgroundResource(R.drawable.image8);
		} else {
			btn.setBackgroundResource(R.drawable.image9);
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//
		Button btn = (Button) v;
		if (flag == 1
				&& btn.getWidth() == getWindowManager().getDefaultDisplay()
						.getWidth()) {
			// 如果等于屏幕的宽度,则修改表示flag为-1
			flag = -1;
		} else if (flag == -1 && btn.getWidth() < 100) {
			flag = 1;
		}
		// 设置button控件尺寸
		btn.setWidth(btn.getWidth() + (int) (btn.getWidth() * 0.1) * flag);
		btn.setHeight((btn.getHeight() + (int) (btn.getHeight() * 0.1) * flag));

	}

}
