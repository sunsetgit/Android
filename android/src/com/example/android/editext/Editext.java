package com.example.android.editext;

import java.util.Random;

import com.example.android.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * EdiText
 * 
 * @author Administrator
 *
 */
public class Editext extends Activity {

	public Editext() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 插入图片
	private Button btnImage;
	private EditText edImage;
	// 验证输入
	private Button btnValidation;
	private EditText etNum;

	// 获取Drawble资源的id数组
	private final int[] DRAW_IMG_ID = { R.drawable.image1, R.drawable.image2,
			R.drawable.image3, R.drawable.image4 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editext);

		// ============插入图片
		btnImage = (Button) findViewById(R.id.btnImage);
		edImage = (EditText) findViewById(R.id.ediImage);

		btnImage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 参数一个0-4的随机数,共4张图片资源
				int random = new Random().nextInt(4);
				// 通过bitmpFactory获得位图资源
				Bitmap bit = BitmapFactory.decodeResource(getResources(),
						DRAW_IMG_ID[random]);
				// 一个imageSpan,用于插入的存放插入的图片
				ImageSpan imageSpan = new ImageSpan(Editext.this, bit);
				SpannableString spannableString = new SpannableString("img");
				spannableString.setSpan(imageSpan, 0, 3,
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				edImage.append(spannableString);
			}
		});

		// ===============验证输入
		btnValidation = (Button) findViewById(R.id.btnValidation);
		etNum = (EditText) findViewById(R.id.etNum);

		btnValidation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String num = etNum.getText().toString().trim();
				if (!num.equals("123")) {
					etNum.setError("请输入123");
				} else {
					etNum.setText("输入正确!");
				}
			}
		});
	}

}
