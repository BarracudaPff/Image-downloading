package com.samsung.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadImageTask extends AsyncTask<String, Integer, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            InputStream in = new URL(strings[0]).openStream();
            return BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
