package com.creativecenter.cc.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.creativecenter.cc.R;

import org.w3c.dom.Text;

public class SetupPinActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt1, txt2, txt3, txt4, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, txt_delete, txt_info;
    private RelativeLayout ll_num1, ll_num2, ll_num3, ll_num4, ll_num5, ll_num6, ll_num7, ll_num8, ll_num9, ll_num0, ll_delete;
    private String pin[] = new String[4];
    private String lastEnteredPin[] = new String[4];
    private String isFrom;
    private boolean isOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_pin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setView();
        getIntentData();
        setListner();

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SetupPinActivity.this, "button click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getIntentData() {
        if (getIntent().hasExtra("isFrom")) {
            isFrom = getIntent().getStringExtra("isFrom");
            lastEnteredPin = getIntent().getStringArrayExtra("pinArray");
            txt_info.setText("Confirm your Pin");
        }

    }

    private void setListner() {
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        num0.setOnClickListener(this);
        txt_delete.setOnClickListener(this);
    }

    private void setView() {
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        num3 = (TextView) findViewById(R.id.num3);
        num4 = (TextView) findViewById(R.id.num4);
        num5 = (TextView) findViewById(R.id.num5);
        num6 = (TextView) findViewById(R.id.num6);
        num7 = (TextView) findViewById(R.id.num7);
        num8 = (TextView) findViewById(R.id.num8);
        num9 = (TextView) findViewById(R.id.num9);
        num0 = (TextView) findViewById(R.id.num0);
        txt_info = (TextView) findViewById(R.id.txt_info);
        txt_delete = (TextView) findViewById(R.id.txt_delete);
    }

    private void setNumberPin(View v) {
        String number = ((TextView) v).getText().toString();
        TextView[] textViews = {txt1, txt2, txt3, txt4};
        int count = 0;
        for (TextView text : textViews) {
            if (text.getText().toString().equalsIgnoreCase("")) {
                text.setText(number);
                pin[count] = number;
                break;
            } else {
                Log.e("result", "not found");
            }
            count++;
        }
        if (!txt4.getText().toString().equalsIgnoreCase("")) {
            if (isFrom != null) {
                int num = 0;
                for (String newPin : pin) {
                    if (newPin.equalsIgnoreCase(lastEnteredPin[num])) {
                        isOk = true;
                    } else {
                        isOk = false;
                    }
                }
                if (isOk) {
                    Toast.makeText(this, "pin updated sucessfully..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "pin dosent match", Toast.LENGTH_SHORT).show();
                }


            } else {
                startActivity(new Intent(getApplicationContext(), SetupPinActivity.class)
                        .putExtra("isFrom", "pin")
                        .putExtra("pinArray", pin));
                finish();
            }
        }

    }

    private void deleteNumberPin() {
        TextView[] textViews = {txt4, txt3, txt2, txt1};
        for (TextView text : textViews) {
            if (!text.getText().toString().isEmpty()) {
                text.setText("");
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.num1:
            case R.id.num2:
            case R.id.num3:
            case R.id.num4:
            case R.id.num5:
            case R.id.num6:
            case R.id.num7:
            case R.id.num8:
            case R.id.num9:
            case R.id.num0:
                setNumberPin(view);
                break;
            case R.id.txt_delete:
                deleteNumberPin();
                break;
        }
    }
}
