package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    private TextView mainNamer;
    private Button onButtonClick;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        onButtonClick = findViewById(R.id.onButtonClick);
        backButton = findViewById(R.id.backbutton);
        mainNamer = findViewById(R.id.secondname);
        String fname = getIntent().getStringExtra("keyname");
        mainNamer.setText(fname);

        onButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText secondName = (EditText) findViewById(R.id.secondname);
                String stringToPassBack = secondName.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("keyName", stringToPassBack);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.image_s);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            int res_image = bundle.getInt("IUCA");
            imageView.setImageResource(res_image);
        }



    }
}