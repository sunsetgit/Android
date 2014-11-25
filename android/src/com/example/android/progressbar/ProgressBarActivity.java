package com.example.android.progressbar;

import com.example.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * 进度条
 * 
 * @author Administrator
 *
 */
public class ProgressBarActivity extends Activity {

	private Button btnAdd, btnReduce, btnVisible;
	private ProgressBar pbHor, pbLarge;

	public ProgressBarActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbabr_layout);

		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnReduce = (Button) findViewById(R.id.btnReduce);
		btnVisible = (Button) findViewById(R.id.btnVisible);
		pbHor = (ProgressBar) findViewById(R.id.pbHor);
		pbLarge = (ProgressBar) findViewById(R.id.pbLarge);

		btnAdd.setOnClickListener(mathClick);
		btnReduce.setOnClickListener(mathClick);
		btnVisible.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 判断large进度条是否显示,显示则隐藏,隐藏则显示
				if (pbLarge.getVisibility() == View.VISIBLE) {
					pbLarge.setVisibility(View.GONE);
				} else {
					pbLarge.setVisibility(View.VISIBLE);
				}
			}
		});
	}

	private View.OnClickListener mathClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btnAdd:
				// 如果是增加按钮,因为进度条的最大值在100,第一刻度限制在90
				// 在此限度内.以1.2倍递增
				// 使用setProgress()
				if (pbHor.getProgress() < 90) {
					pbHor.setProgress((int) (pbHor.getProgress() * 1.2));
				}
				if (pbHor.getSecondaryProgress() < 100) {
					pbHor.setSecondaryProgress((int) (pbHor
							.getSecondaryProgress() * 1.2));
				}
				break;
			case R.id.btnReduce:
				// 如果是递减按钮,因为进度条的最大值限制在100,第一刻度限制在10,第二刻度限制在20
				// 在此限度内,以5点为基数进行递减
				// 使用incermentXxxProgressBy(int)
				if (pbHor.getProgress() > 10) {
					pbHor.incrementProgressBy(-10);
				}
				if (pbHor.getSecondaryProgress() > 20) {
					pbHor.incrementSecondaryProgressBy(-10);
				}
				break;
			}
		}
	};
}
