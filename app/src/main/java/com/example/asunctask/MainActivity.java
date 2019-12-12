package com.example.asunctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // 1 : param - tham số truyền vào doInBackground
    // 2 : Progress - tham số dùng cập nhật dữ liệu khi doIn xử lí
    // 2 : result - tham số sau khi doIn xử lí xong  trả về cho onPost
//    class Datientrinh extends AsyncTask<Void, String, String> {
//
//    }
}
