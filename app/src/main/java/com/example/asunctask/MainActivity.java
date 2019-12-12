package com.example.asunctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnDownload;
    ImageView img;
    ProgressBar progressBar;
    TextView txtProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDownload = findViewById(R.id.buttonDownLoad);
        img = findViewById(R.id.imageDownLoad);
        progressBar = findViewById(R.id.progressbar);
        txtProgress = findViewById(R.id.textviewPercent);


        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Xulidownload().execute();

            }
        });


    }

    private void showView(View v) {
        v.setVisibility(View.VISIBLE);
    }

    private void hideView(View v) {
        v.setVisibility(View.GONE);
    }

    class Xulidownload extends AsyncTask<Void, String, Integer> {

        @Override
        protected void onPreExecute() {
            showView(txtProgress);
            showView(progressBar);
            hideView(btnDownload);
            Toast.makeText(MainActivity.this, "Bắt đầu download", Toast.LENGTH_SHORT).show();
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            synchronized (Thread.currentThread()) {
                int valuerandom = 0;
                Random random = new Random();
                for (; valuerandom <= 100; ) {
                    valuerandom += random.nextInt(10);
                    try {
                        Thread.currentThread().wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(String.valueOf(valuerandom));

                }
                return R.mipmap.ic_launcher;
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            assert values[0] != null;
            if (Integer.parseInt(values[0]) >= 100) {
                progressBar.setProgress(100);
                txtProgress.setText(100 + "");
                return;
            }
            progressBar.setProgress(Integer.parseInt(values[0]));
            txtProgress.setText(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            hideView(txtProgress);
            hideView(progressBar);
            showView(img);
            img.setImageResource(integer);

            super.onPostExecute(integer);
        }
    }

    // 1 : param - tham số truyền vào doInBackground
    // 2 : Progress - tham số dùng cập nhật dữ liệu khi doIn xử lí
    // 2 : result - tham số sau khi doIn xử lí xong  trả về cho onPost
//    class Datientrinh extends AsyncTask<Void, String, String> {
//
//    }
}
