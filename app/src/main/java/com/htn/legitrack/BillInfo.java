package com.htn.legitrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class BillInfo extends AppCompatActivity {

    TextView titleView;
    TextView summaryView;
    TextView subjectView;
    TextView urlView;

    Bill bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_info);

        titleView = findViewById(R.id.bill_info_title);
        summaryView = findViewById(R.id.bill_info_summary);
        subjectView = findViewById(R.id.bill_info_subjects);
        urlView = findViewById(R.id.textView6);

        Intent intent = getIntent();
        bill = (Bill)intent.getSerializableExtra("bill");

        loadBill(bill);
    }

    private void loadBill(Bill bill) {
        titleView.setText(bill.title);
        summaryView.setText(bill.summary);
        subjectView.setText(convertListToString(bill.sources));
        subjectView.setMovementMethod(LinkMovementMethod.getInstance());
        urlView.setText(bill.publicID);
    }

    public static String convertListToString(ArrayList<String> list) {
        String stringList = "";
        for (int i = 0; i < list.size(); i++) {
            stringList = stringList.concat(list.get(i));
            if (i != list.size() - 1) {
                stringList = stringList.concat(", ");
            }
        }
        return stringList;
    }

    public void sendComment(View view) {
        Intent intent = new Intent(getApplicationContext(), Reaction.class);
        intent.putExtra("Bill", bill);
        startActivity(intent);
    }

    public void viewComments(View view) {
        Intent intent = new Intent(getApplicationContext(), ViewComments.class);
        intent.putExtra("thisBill", bill);
        startActivity(intent);
    }

    public void share(View v) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, bill.title);
        shareIntent.putExtra(Intent.EXTRA_TEXT, bill.sources.get(0));
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}