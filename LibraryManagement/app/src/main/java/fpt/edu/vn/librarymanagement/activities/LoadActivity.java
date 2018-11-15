package fpt.edu.vn.librarymanagement.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import fpt.edu.vn.librarymanagement.R;

public class LoadActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.getProgressDrawable().setColorFilter(
                Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        final AppCompatActivity main = this;
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(final Void... params) {
                for (int i = 0; i < 101; i = i + 10) {
                    progressBar.setProgress(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(final Void result) {
                // Jump to search screen
                super.onPostExecute(result);
                Intent intent = new Intent(main, BookListActivity.class);
                startActivity(intent);
            }
        }.execute();
    }
}
