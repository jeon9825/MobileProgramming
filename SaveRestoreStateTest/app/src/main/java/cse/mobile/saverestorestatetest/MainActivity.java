package cse.mobile.saverestorestatetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            mCount = savedInstanceState.getInt("mCount");
        }

        final TextView tvOrder = findViewById(R.id.tvOrder);
        tvOrder.setText("Total amount of order: " + mCount);

        Button btIncrease = findViewById(R.id.btIncrease);
        btIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount++;
                tvOrder.setText("Total amount of order: " + mCount);
            }
        });

        Button btDecrease = findViewById(R.id.btDecrease);
        btDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(--mCount < 0) {
                    mCount = 0;
                }
                tvOrder.setText("Total amount of order: " + mCount);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);

        outState.putInt("mCount", mCount);
    }
}
