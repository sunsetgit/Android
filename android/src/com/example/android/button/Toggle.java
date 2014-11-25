package com.example.android.button;

import com.example.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/*
 * toggle开关按钮
 */
public class Toggle extends Activity {

	private ToggleButton togBtn;
	private LinearLayout linearLayout;

	public Toggle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toggle_layout);

		togBtn = (ToggleButton) findViewById(R.id.togBtn);
		linearLayout = (LinearLayout) findViewById(R.id.oriLayout);

		togBtn.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				// 通过判断是否选中,来设置LinertLayout的纵向横向排列
				if (isChecked) {
					linearLayout.setOrientation(1);
				} else {
					linearLayout.setOrientation(0);
				}
			}
		});
	}

}
