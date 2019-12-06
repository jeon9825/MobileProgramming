package cse.mobile.threadtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "ThreadTest";
    static final int MSG_CODE_THCOUNTER = 0;

    boolean mRunning = false;

    TextView mTVCount;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what) {
                case MSG_CODE_THCOUNTER:
                    mTVCount.setText("[" + Thread.currentThread().getName() + "] Count: " + msg.arg1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*        Thread thCounter = new Thread(new CounterThread());
        mRunning = true;
        thCounter.start(); */

        mTVCount = findViewById(R.id.tvCount);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Thread thCounter = new Thread(new CounterThread());
        mRunning = true;
        thCounter.start();


    }

    @Override
    protected void onStop() {
        super.onStop();

        mRunning = false;
    }

    private class CounterThread implements Runnable {
        @Override
        public void run() {
            for(int i=0; i<10 && mRunning; i++) {
                Log.i(TAG, "[" + Thread.currentThread().getName() + "] Count: " + i);
//                mTVCount.setText("[" + Thread.currentThread().getName() + "] Count: " + i);
                Message msg = new Message();
                msg.what = MSG_CODE_THCOUNTER;
                msg.arg1 =i;
                mHandler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
