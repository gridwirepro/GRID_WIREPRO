package com.project.gridwirepro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class complaint extends AppCompatActivity {
    EditText complaint;
    EditText complaint_id;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbref3 = database.getReference();
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaint);
        complaint=findViewById(R.id.complaint);
        complaint_id=findViewById(R.id.complaint_id);
    }
    public void complaint_reg(View view)
    {
        if (complaint_id.getText().toString().trim().length() == 0) {
            f++;
            complaint_id.setError("CONSUMER ID is not entered");
            complaint_id.requestFocus();

        }
        if (complaint.getText().toString().trim().length() == 0) {
            f++;
            complaint.setError("COMPLAINT is not entered");
            complaint.requestFocus();

        }
        if (f == 0) {
            dbref3.child("complaint").child(complaint_id.getText().toString());
            dbref3.child("complaint").child(complaint_id.getText().toString()).child("complaint").setValue(complaint.getText().toString());
        }
    }
}
