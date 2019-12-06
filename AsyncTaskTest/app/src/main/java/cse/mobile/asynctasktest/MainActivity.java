package cse.mobile.asynctasktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "AsyncTaskTest";
    boolean mRunning = false;
    TextView mTVCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTVCount = findViewById(R.id.tvCount);
    }

    @Override
    protected void onStart() {
        super.onStart();

        CounterTask taskCounter = new CounterTask();
        mRunning = true;
        taskCounter.execute();
    }

    @Override
    protected void onStop() {
        super.onStop();

        mRunning = false;
    }

    private class CounterTask extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);

            mTVCount.setText("[" + Thread.currentThread().getName() + "] Count LAST: " + result);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            mTVCount.setText("[" + Thread.currentThread().getName() + "] Count: " + values[0]);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int i;
            for(i=0; i<10 && mRunning; i++) {
                Log.i(TAG, "[" + Thread.currentThread().getName() + "] Count: " + i);
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return i;
        }
    }
}
