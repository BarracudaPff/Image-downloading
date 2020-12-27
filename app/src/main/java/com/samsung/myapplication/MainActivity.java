package com.samsung.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editTextTextPersonName);
        ImageView imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadImageTask task = new DownloadImageTask();
                task.execute(editText.getText().toString());
                try {
                    Bitmap bm = task.get(1, TimeUnit.SECONDS);
                    imageView.setImageBitmap(bm);
                } catch (ExecutionException | InterruptedException | TimeoutException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}