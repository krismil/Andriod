package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.R;
public class SettingsActivity extends AppCompatActivity
{
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}
