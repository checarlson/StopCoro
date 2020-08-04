package com.lld.stopcoro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class NoSymptoms extends AppCompatActivity {

    private static ImageButton finish;
    private static TextView NoSymtext, noweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_symptoms);
        NoSymtext = (TextView) findViewById(R.id.textViewNo);
        NoSymtext.setMovementMethod(new ScrollingMovementMethod());

        noweb = (TextView) findViewById(R.id.notxt);

        OnclickfinishButton();
        OnclinkWeblink();
    }

    public void OnclickfinishButton(){
        finish = (ImageButton) findViewById(R.id.finishButton);
        finish.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        //finish();

                                    }
                                }
        );
    }

    public void  OnclinkWeblink(){
        noweb.setMovementMethod(LinkMovementMethod.getInstance());
        noweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse("https://www.stopcoro.com"));
                browser.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(browser);
            }
        });
    }

    public void onBackPressed(){
        super.onBackPressed();

        Intent intent1 = new Intent(getApplicationContext(), SympDiagnostic.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        //finish();
    }
}

