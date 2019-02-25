package com.project.gridwirepro;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_login extends AppCompatActivity {
    Button login,signup;

    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        user=findViewById(R.id.input_id);
        pass=findViewById(R.id.input_pass);
    }


    public void admin(View view)
    {
       // if((user.getText().equals("admin"))&&pass.getText().equals("admin"))
        //{
            Intent i = new Intent(this, admin_Activity.class);
            startActivity(i);
        /*}
        else
        {
        Toast.makeText(this, "WRONG USER ID OR PASSWORD", Toast.LENGTH_SHORT).show();
        }*/
    }
}
