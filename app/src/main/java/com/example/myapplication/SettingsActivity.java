package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import com.example.R;

public class SettingsActivity extends AppCompatActivity {

    private Switch nightModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // 初始化Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_settings);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        // 找到Switch控件
        nightModeSwitch = findViewById(R.id.nightMode);

        // 使用SharedPreferences来保存和读取夜间模式的状态
        SharedPreferences sharedPreferences = getSharedPreferences("AppSettingPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // 获取保存的夜间模式状态，默认为false（日间模式）
        boolean isNightMode = sharedPreferences.getBoolean("NightMode", false);
        nightModeSwitch.setChecked(isNightMode);

        // 为Switch控件设置状态变更监听器
        nightModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // 如果开关被选中，切换到夜间模式
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                editor.putBoolean("NightMode", true);
            } else {
                // 如果开关未被选中，切换到日间模式
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editor.putBoolean("NightMode", false);
            }
            // 保存更改
            editor.apply();
        });
    }
}