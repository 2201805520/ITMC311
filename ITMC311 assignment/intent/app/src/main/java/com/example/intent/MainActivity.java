package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // العثور على الزر
        Button openWebButton = findViewById(R.id.open_web_button);

        // تعيين حدث النقر مع رسالة Toast
        openWebButton.setOnClickListener(v -> {
            // رسالة Toast عند النقر
            Toast.makeText(MainActivity.this, "Opening Google...", Toast.LENGTH_SHORT).show();

            // إنشاء Intent لفتح الرابط
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });
    }
}
