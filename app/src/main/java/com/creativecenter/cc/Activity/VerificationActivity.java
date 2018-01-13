package com.creativecenter.cc.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.creativecenter.cc.R;

public class VerificationActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        setView();
        setListner();
    }

    private void setView()
    {
        txt_continue=(TextView) findViewById(R.id.txt_continue);
    }
    private void setListner()
    {
        txt_continue.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.txt_continue:
                startActivity(new Intent(getApplicationContext(),VerifiedActivity.class));
                break;
        }
    }
}
