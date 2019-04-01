package com.project.gridwirepro;

import android.app.ActivityOptions;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;

public class admin_login extends AppCompatActivity {
    Button login,signup;

    EditText user,paswrd;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        user=findViewById(R.id.input_id);
        paswrd=findViewById(R.id.input_pass);
        auth = FirebaseAuth.getInstance();
    }


    public void admin(View view)
    {
        Intent i = new Intent(admin_login.this, admin_Activity.class);
        startActivity(i);
      /*  String txt = user.getText().toString();
        String pass = paswrd.getText().toString();
        auth.signInWithEmailAndPassword(txt,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent i = new Intent(admin_login.this, admin_Activity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(admin_login.this,"login failed",Toast.LENGTH_LONG).show();
                }
            }
        });
        if(txt.equals("")||pass.equals("")) {
            Toast.makeText(this,"username or password can't be null",Toast.LENGTH_LONG).show();
        }
        else {
            if (pass.equals("admin")) {
                Intent i = new Intent(this, admin_Activity.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_LONG).show();
            }
        }
        user.setText("");
        paswrd.setText("");
        user.requestFocus();*/
    }
}
