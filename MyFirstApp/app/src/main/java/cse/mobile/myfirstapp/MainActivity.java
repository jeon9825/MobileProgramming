package cse.mobile.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        TextView tvHello = new TextView(this);
        tvHello.setText("안녕하세요, 안드로이드프로그래밍 수업입니다.");
        setContentView(tvHello);
    }
}
