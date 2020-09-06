package com.example.cybercypher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.cybercypher.KEY_MESSAGE";
    public static String key = null;

    Integer i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.encryptLaunchButton)).setOnClickListener(new OpenEncrypt());
        ((Button)findViewById(R.id.decryptLaunchButton)).setOnClickListener(new OpenDecrypt());
        if(key != null)
        {
            ((EditText)findViewById(R.id.keyText)).setText(key);
        }
    }


    class OpenEncrypt implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            StartEncryptorDecryptActivity(EncryptActivity.class);
        }
    }

    class OpenDecrypt implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            StartEncryptorDecryptActivity(DecryptActivity.class);
        }
    }

    private void StartEncryptorDecryptActivity(Class activity)
    {
        Intent intent = new Intent(this, activity);
        EditText keyEditText = (EditText)findViewById(R.id.keyText);
        key = keyEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, key);
        startActivityForResult(intent, 1);
    }

//    public static String GetKey()
//    {
//        return key;
//    }
//    public static void SetKey(String input)
//    {
//        key = input;
//    }

}