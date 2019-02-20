package com.project.gridwirepro;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
public class emp extends AppCompatActivity {

    EditText emp_name;
    EditText emp_id;
    EditText emp_address;
    EditText emp_mobie;
    EditText emp_email;
    String name,mobile,id,address,email;
    Button emp_reg;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbref = database.getReference("employee");
    int f=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);
        emp_name=findViewById(R.id.emp_name);
        emp_id=findViewById(R.id.emp_id);
        emp_address=findViewById(R.id.emp_address);
        emp_mobie=findViewById(R.id.emp_mobile);
        emp_email=findViewById(R.id.emp_email);
        emp_reg=findViewById(R.id.emp_reg);
        name=emp_name.getText().toString();
        id=emp_id.getText().toString();
        address=emp_address.getText().toString();;
        mobile=emp_mobie.getText().toString();
        email=emp_email.getText().toString();
    }
    public void employee_reg(View view) {
        if (emp_name.getText().toString().trim().length() == 0) {
            f++;
            emp_name.setError("EMPLOYEE NAME is not entered");
            emp_name.requestFocus();

        }
        if (emp_id.getText().toString().trim().length() == 0) {
            f++;
            emp_id.setError("EMPLOYEE ID is not entered");
            emp_id.requestFocus();

        }
        if (emp_address.getText().toString().trim().length() == 0) {
            f++;
            emp_address.setError("EMPLOYEE ADDRESS is not entered");
            emp_address.requestFocus();

        }
        if (emp_mobie.getText().toString().trim().length() == 0) {
            f++;
            emp_mobie.setError("EMPLOYEE MOBILE is not entered");
            emp_mobie.requestFocus();

        }
        if (emp_email.getText().toString().trim().length() == 0) {
            f++;
            emp_email.setError("EMPLOYEE EMAIL is not entered");
            emp_email.requestFocus();

        }
        if (f == 0) {
            dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int noemp = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                    dbref.setValue(noemp + 1);
                    DatabaseReference empRef = database.getReference(dbref.getKey() + noemp);

                    empRef.child("Name").setValue(name);
                    empRef.child("id").setValue(id);
                    empRef.child("Phone").setValue(mobile);
                    empRef.child("address").setValue(address);
                    empRef.child("email").setValue(email);
                    empRef.child("password").setValue("password");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(emp.this, "Unable to connect. Please try again later.", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
