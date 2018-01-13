package com.creativecenter.cc.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.creativecenter.cc.R;


public class VerifiedActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_setpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verified);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setView();
        setlistner();
    }
    private void setView()
    {
        txt_setpin=(TextView)findViewById(R.id.txt_setPin);
    }
    private void setlistner()
    {
        txt_setpin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.txt_setPin:
                startActivity(new Intent(getApplicationContext(),SetupPinActivity.class));
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
