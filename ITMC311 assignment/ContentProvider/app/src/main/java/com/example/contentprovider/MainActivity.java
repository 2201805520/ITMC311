package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;

import android.content.ContentValues;
import android.content.CursorLoader;

import android.database.Cursor;

import android.view.Menu;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(StudentsProvider.NAME,
                ((EditText)findViewById(R.id.editText2)).getText().toString());

        values.put(StudentsProvider.GRADE,
                ((EditText)findViewById(R.id.editText3)).getText().toString());

        Uri uri = getContentResolver().insert(
                StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();

    }
    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://com.example.contentprovider.StudentsProvider";

        Uri students = Uri.parse(URL);
        Cursor c;

        c =getContentResolver().query(students, null, null, null, "_ID");
        if (c.moveToFirst()) {
            do{
                int id = c.getColumnIndex(StudentsProvider._ID);
                String Sid = c.getString(id);
                int name = c.getColumnIndex(StudentsProvider.NAME);
                String Sname = c.getString(name);
                int grade = c.getColumnIndex(StudentsProvider.GRADE);
                String Sgrade = c.getString(grade);
                Toast.makeText(this,Sid+","+Sname+","+Sgrade,
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}