package com.project.gridwirepro;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class front_page extends AppCompatActivity {
    Button emp,cons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);
    }

    public void employee(View view) {
        Intent i = new Intent(front_page.this, admin_login.class);
        startActivity(i);

    }

    public void consumer(View view) {
        Intent i = new Intent(front_page.this, MainActivity.class);
        startActivity(i);


    }
}

