package com.how.randomnumber;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    TextView textView1;//숫자 입력하라는 글씨 부분
    EditText editText1;// 끝번호를 입력받는 부분
    int max; // 사용자가 입력하는 끝 번호
    TextView textView2; // 랜덤 결과를 보여주는 부분
    int [] ran = new int[max];
    int cnt=0;//숫자 확인하는 부분



  @Override
    public void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      textView1 = (TextView) findViewById(R.id.textView1);
      editText1 = (EditText) findViewById(R.id.editText1);
      textView2 = (TextView) findViewById(R.id.textView2);
      findViewById(R.id.btn1).setOnClickListener(mClick1Listener);
      findViewById(R.id.btn2).setOnClickListener(mClick2Listener);
  }
Button.OnClickListener mClick1Listener = new Button.OnClickListener() {
    public void onClick(View v) {
        for (int i = 0; i < ran.length; i++) {
            ran[i] = new Random().nextInt(max) + 1;
            for (int j = 0; j < i; j++) {
                if (ran[i] == ran[j]) {
                    i--;
                    break;
                }
            }
        }
        textView2.setText(String.valueOf(ran[0]));
        cnt++;
    }


};
   Button.OnClickListener mClick2Listener = new Button.OnClickListener(){
       public void onClick(View v)

    {

        textView2.setText(Integer.toString(ran[cnt]));
        cnt++;
        if(cnt == max)
        {
            textView2.setText("한번 더 누르면 모두 표시 됩니다");
        }
    }

};

}
