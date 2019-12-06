package cse.mobile.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sub);
        setContentView(R.layout.activity_sub2);
/*
        Button btSubExit = findViewById(R.id.btSubExit);
        btSubExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        }); */

        final EditText etSubInput = findViewById(R.id.etSubInput);

        if(getIntent().getStringExtra("mainRetStr") != null) {
            etSubInput.setHint(getIntent().getStringExtra("mainRetStr"));
        }

        Button btSubOK = findViewById(R.id.btSubOK);
        btSubOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sIntent = new Intent();
                sIntent.putExtra("subInput", etSubInput.getText().toString());
                setResult(RESULT_OK, sIntent);
                finish();
            }
        });

        Button btSubCancel = findViewById(R.id.btSubCancel);
        btSubCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
