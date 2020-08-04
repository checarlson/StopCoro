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
import android.widget.TextView;

public class Precaution extends AppCompatActivity {

    private static TextView pretextview, preweb;
    private static Button backbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precaution);
        pretextview = (TextView) findViewById(R.id.preview);
        pretextview.setMovementMethod(new ScrollingMovementMethod());
        preweb = (TextView) findViewById(R.id.pretxt);

        OnclickButtonBacklistener();
        OnclinkWeblink();
    }

    //method for back button
    public void OnclickButtonBacklistener(){
        backbut = (Button) findViewById(R.id.backButton);
        backbut.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                  startActivity(intent);
                                                 // finish();

                                              }
                                          }
        );
    }

    public void  OnclinkWeblink(){
        preweb.setMovementMethod(LinkMovementMethod.getInstance());
        preweb.setOnClickListener(new View.OnClickListener() {
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
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        //finish();
    }
}
