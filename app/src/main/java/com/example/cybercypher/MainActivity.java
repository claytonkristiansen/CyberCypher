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
        //((Button)findViewById(R.id.button)).setText("DONKEY");
    }

    public void OpenEncrypt(View view)
    {
        ((Button)findViewById(R.id.button)).setText(i.toString());
        i++;
    }


}