package com.example.cybercypher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

enum ENCRYPTION_TYPE {CLAYTON, NISHI_1, NISHI_2, NISHI_3}

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.cybercypher.KEY_MESSAGE";
    public static String key = null;
    public static ENCRYPTION_TYPE type;

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

        Spinner spinner = (Spinner) findViewById(R.id.encrpytionTypeSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Encryption_Array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener());
    }

    public class SpinnerListener implements AdapterView.OnItemSelectedListener
    {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using

            if(pos == 0)
            {
                ((EditText)findViewById(R.id.keyText)).setVisibility(View.VISIBLE);
            }
            else {
                ((EditText) findViewById(R.id.keyText)).setVisibility(View.INVISIBLE);
            }
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
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
        startActivity(intent);
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