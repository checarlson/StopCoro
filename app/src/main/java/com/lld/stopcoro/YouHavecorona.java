package com.lld.stopcoro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class YouHavecorona extends AppCompatActivity {

    private  static ImageButton finish;
    private static TextView youhavetextview, youweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_havecorona);

        youweb = (TextView) findViewById(R.id.youtxt);

        youhavetextview = (TextView) findViewById(R.id.textViewYouhave);
        youhavetextview.setMovementMethod(new ScrollingMovementMethod());

        OnclickfinishButton();
        OnclinkWeblink();
    }

    public void OnclickfinishButton(){
        finish = (ImageButton) findViewById(R.id.imageButtonfin);
        finish.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                                          intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                          startActivity(intent1);
                                         // finish();

                                      }
                                  }
        );
    }

    public void  OnclinkWeblink(){
        youweb.setMovementMethod(LinkMovementMethod.getInstance());
        youweb.setOnClickListener(new View.OnClickListener() {
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

        Intent intent1 = new Intent(getApplicationContext(), CANPrform.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        //finish();
    }
}
