package com.project.gridwirepro;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class consumer extends AppCompatActivity {
    EditText con_name;
    EditText con_id;
    EditText con_address;
    EditText con_mobile;
    EditText con_email;
    EditText con_reading;
    String name,mobile,id,address,email,reading;
    Button con_reg;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbref1 = database.getReference();
    int f=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer);
        con_name=findViewById(R.id.con_name);
        con_id=findViewById(R.id.con_id);
        con_address=findViewById(R.id.con_address);
        con_mobile=findViewById(R.id.con_mobile);
        con_email=findViewById(R.id.con_email);
        con_reg=findViewById(R.id.con_reg);
        con_reading=findViewById(R.id.con_reading);
        name=con_name.getText().toString();
        id=con_id.getText().toString();
        address=con_address.getText().toString();
        mobile=con_mobile.getText().toString();
        email=con_email.getText().toString();
        reading=con_reading.getText().toString();

    }
    public void consumer_reg(View view) {
        if (con_name.getText().toString().trim().length() == 0) {
            f++;
            con_name.setError("CONSUMER NAME is not entered");
            con_name.requestFocus();

        }
        if (con_id.getText().toString().trim().length() == 0) {
            f++;
            con_id.setError("CONSUMER ID is not entered");
            con_id.requestFocus();

        }
        if (con_address.getText().toString().trim().length() == 0) {
            f++;
            con_address.setError("CONSUMER ADDRESS is not entered");
            con_address.requestFocus();

        }
        if (con_mobile.getText().toString().trim().length() == 0) {
            f++;
            con_mobile.setError("CONSUMER MOBILE is not entered");
            con_mobile.requestFocus();

        }
        if (con_email.getText().toString().trim().length() == 0) {
            f++;
            con_email.setError("CONSUMER EMAIL is not entered");
            con_email.requestFocus();

        }
        if (con_reading.getText().toString().trim().length() == 0) {
            f++;
            con_reading.setError("CONSUMER METER READING is not entered");
            con_reading.requestFocus();

        }
        if (f == 0) {

            DatabaseReference databasereference2= FirebaseDatabase.getInstance().getReference("consumer");
            String id = databasereference2.push().getKey();
            float billamnt= (float) 0.00;
           consumerdata cd=new consumerdata(con_mobile.getText().toString(),con_address.getText().toString(),con_email.getText().toString(),con_reading.getText().toString(),con_name.getText().toString(),con_id.getText().toString(),billamnt);
            databasereference2.child(con_id.getText().toString()).setValue(cd);

        }
    }
}
