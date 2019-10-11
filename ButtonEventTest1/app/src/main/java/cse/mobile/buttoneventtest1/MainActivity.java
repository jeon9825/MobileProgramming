package cse.mobile.buttoneventtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

//        ButtonClickListener buttonClickListener = new ButtonClickListener();
//        button.setOnClickListener(buttonClickListener);

//        button.setOnClickListener(new ButtonClickListener());

//        button.setOnClickListener(mButtonClickListener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Clicked 4.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class ButtonClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Button Clicked 2.", Toast.LENGTH_SHORT).show();
        }
    }

    View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Button Clicked 3.", Toast.LENGTH_SHORT).show();
        }
    };

}
