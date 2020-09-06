package com.example.cybercypher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{


    Integer i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button)).setOnClickListener(new OpenEncrypt());
    }

    class OpenEncrypt implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            ((Button)view).setText(i.toString());
            i++;
        }
    }

    class OpenEncrypt implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            ((Button)view).setText(i.toString());
            i++;
        }
    }



}