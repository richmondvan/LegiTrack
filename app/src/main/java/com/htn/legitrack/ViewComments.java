package com.htn.legitrack;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewComments extends AppCompatActivity {

    private static final String TAG = "ViewComments";

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_comments);

        //Intent intent = getIntent();
        //newBill = (Bill) getIntent().getSerializableExtra("Bill");


        // Read from the database
        //myRef.addValueEventListener(new ValueEventListener() {
        ValueEventListener postListener = new ValueEventListener() {

                @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                DBobjects myObj  = dataSnapshot.getValue(DBobjects.class);
                //Log.d(TAG, "Comment: " + myObj.comments);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        }//)
        ;
        }












}
