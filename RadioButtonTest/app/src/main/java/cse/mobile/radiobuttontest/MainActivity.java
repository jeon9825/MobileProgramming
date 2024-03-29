package cse.mobile.radiobuttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        RadioButton rbRed = findViewById(R.id.rbRed);
        RadioButton rbGreen = findViewById(R.id.rbGreen);
        RadioButton rbBlue = findViewById(R.id.rbBlue);

        rbRed.setOnClickListener(mRBClickListener);
        rbGreen.setOnClickListener(mRBClickListener);
        rbBlue.setOnClickListener(mRBClickListener);
*/

        RadioGroup rgColor = findViewById(R.id.rgColor);
        rgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rbColor = radioGroup.findViewById(checkedId);

                switch(checkedId) {
                    case R.id.rbRed:
                        Toast.makeText(getApplicationContext(), rbColor.getText() + " checked 4.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbGreen:
                        Toast.makeText(getApplicationContext(), rbColor.getText() + " checked 4.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbBlue:
                        Toast.makeText(getApplicationContext(), rbColor.getText() + " checked 4.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    View.OnClickListener mRBClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((RadioButton)view).isChecked();

            switch(view.getId()) {
                case R.id.rbRed:
                    if(checked) {
                        Toast.makeText(getApplicationContext(), ((RadioButton)view).getText() + " clicked.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.rbGreen:
                    if(checked) {
                        Toast.makeText(getApplicationContext(), ((RadioButton)view).getText() + " clicked.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.rbBlue:
                    if(checked) {
                        Toast.makeText(getApplicationContext(), ((RadioButton)view).getText() + " clicked.", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
}
