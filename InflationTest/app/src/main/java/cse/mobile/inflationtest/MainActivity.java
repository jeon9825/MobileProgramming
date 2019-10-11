package cse.mobile.inflationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        Button btOK = findViewById(R.id.btOK);
//        btOK.setText("YES");

        TextView tvHello = new TextView(this);
        tvHello.setText("Hello, Android in Code.");

//        Button btOK = new Button(this);
//        btOK.setText("OK in Code");

//        LayoutInflater inflater = getLayoutInflater();
//        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LayoutInflater inflater = LayoutInflater.from(this);
//        Button btMybutton = (Button)inflater.inflate(R.layout.mybutton, null);

        Button btMybutton = (Button)View.inflate(this, R.layout.mybutton, null);

        LinearLayout llManager = new LinearLayout(this);
        llManager.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        llManager.addView(tvHello, llParams);
//        llManager.addView(btOK, llParams);
        llManager.addView(btMybutton, llParams);

        setContentView(llManager);

    }
}
