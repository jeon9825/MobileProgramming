package cse.mobile.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int REQ_CODE_SUBACTIVITY_0 = 0;
    TextView mTVMainRet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main2);

        mTVMainRet = findViewById(R.id.tvMainRet);

        Button btMainCall = findViewById(R.id.btMainCall);
        btMainCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sIntent = new Intent(getApplicationContext(), SubActivity.class);
//                startActivity(sIntent);
                sIntent.putExtra("mainRetStr", mTVMainRet.getText().toString());
                startActivityForResult(sIntent, REQ_CODE_SUBACTIVITY_0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case REQ_CODE_SUBACTIVITY_0:
                if(resultCode == RESULT_OK) {
                    mTVMainRet.setText(data.getStringExtra("subInput"));
                }
                break;
        }
    }
}
