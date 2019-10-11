package cse.mobile.checkboxtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbMeat = findViewById(R.id.cbMeat);
        CheckBox cbCheese = findViewById(R.id.cbCheese);
/*
        cbMeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox)view).isChecked();

                if(checked) {
                    Toast.makeText(getApplicationContext(), "Meat checked.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Meat unchecked.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox)view).isChecked();

                if(checked) {
                    Toast.makeText(getApplicationContext(), "Cheese checked.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cheese unchecked.", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/
        cbMeat.setOnClickListener(mCBClickListener);
        cbCheese.setOnClickListener(mCBClickListener);
    }

    View.OnClickListener mCBClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox)view).isChecked();

            switch(view.getId()) {
                case R.id.cbMeat:
                    if(checked) {
                        Toast.makeText(getApplicationContext(), "Meat checked 2.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Meat unchecked 2.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cbCheese:
                    if(checked) {
                        Toast.makeText(getApplicationContext(), "Cheese checked 2.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Cheese unchecked 2.", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

        }
    };


}
