package com.project.gridwirepro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class billandpay extends AppCompatActivity {
    CardView crd;
    EditText t;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billandpay);
        t=findViewById(R.id.ed1);
        tv=findViewById(R.id.billtext);
        crd=findViewById(R.id.crd);
    }
    //          view bill


    public void bill(View view)
    {
        String s=t.getText().toString();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Query query = reference.child("consumer").orderByChild("phno").equalTo(s);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    try {
                        for (DataSnapshot ca : dataSnapshot.getChildren()) {
                            consumerdata c=ca.getValue(consumerdata.class);
                            Toast.makeText(billandpay.this, "hii", Toast.LENGTH_SHORT).show();
                            tv.setText("ID :-\t\t\t"+c.getConsumerid()+"\nNAME :-\t\t\t"+c.getName()+"\nEMAIL :-\t\t\t"+c.getEmail()+"\nADDRESS :-\t\t\t"+c.getAddress()+"\nPHONE NUMBER :-\t\t\t"+c.getPhno()+"\nMETER READING :-\t\t\t"+c.getMeterreading()+"\nBILL AMOUNT :-\t\t\t"+c.getBillamnt());

                        }
                    }
                    catch (Exception e){
                        Toast.makeText(billandpay.this, e.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        crd.setVisibility(View.VISIBLE);
    }
    //        payment gateway googlepay


    public void payment(View view)
    {
        Context context=getApplicationContext();
        String packageName="com.google.android.apps.nbu.paisa.user";
        try {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent == null) {
                // Bring user to the market or let them choose an app?
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" + packageName));
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "INSTALL GOOGLE PAY APP TO COMPLETE PAYMENT ", Toast.LENGTH_SHORT).show();
        }
    }

}
