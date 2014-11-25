package com.example.android.button;

import com.example.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * radio单选按钮
 * 
 * @author Administrator
 *
 */
public class RadioButton extends Activity {

	private RadioGroup group;
	private Button btnGender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio_button);

		group = (RadioGroup) findViewById(R.id.gender);
		btnGender = (Button) findViewById(R.id.btnGender);
		btnGender.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 获取单选按钮的选项个数
				int len = group.getChildCount();
				String msgString = "";
				for (int i = 0; i < len; i++) {
					// RadioGroup中包含的子View就是一个RadioButton
					android.widget.RadioButton radiobutton = (android.widget.RadioButton) group
							.getChildAt(i);
					if (radiobutton.isChecked()) {
						// 如果被选中,则break循环,并记录下选择的信息
						msgString = "你选中了:" + radiobutton.getText().toString();
						break;
					}
				}
				if (msgString.equals("")) {
					Toast.makeText(RadioButton.this, "请选择", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(RadioButton.this, msgString,
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

}
