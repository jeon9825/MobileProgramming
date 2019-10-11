package cse.mobile.togglebuttontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ComputableLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton tbDecision = findViewById(R.id.tbDecision);
        tbDecision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((ToggleButton)view).isChecked();

                if(checked) {
                    Toast.makeText(getApplicationContext(), "YES decided.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "NO decided.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Switch swWiFi = findViewById(R.id.swWiFi);
        swWiFi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(getApplicationContext(), "WiFi ON.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "WiFi OFF.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
