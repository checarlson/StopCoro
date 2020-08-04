package com.lld.stopcoro;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Button button_checkup;
    private static Button button_pre;
    private static Button button_close;
    private static TextView mainweb;
    //private static ImageButton test1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainweb = (TextView) findViewById(R.id.maintxt);

        OnclickButtoncheckuplistener();
        OnclickButtonPrelistener();
        OnclickButtonCloselistener();
        OnclinkWeblink();

    }

    //method for checkup button
    public void OnclickButtoncheckuplistener(){
        button_checkup = (Button)findViewById(R.id.checkup);
        button_checkup.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent intent = new Intent(getApplicationContext(), CheckupIntro.class);
                                              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                              startActivity(intent);

                                          }
                                      }
        );
    }

    //method for precaution button
    public void OnclickButtonPrelistener(){
        button_pre = (Button)findViewById(R.id.precaution);
        button_pre.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent intent1 = new Intent(getApplicationContext(), Precaution.class);
                                              intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                              startActivity(intent1);

                                          }
                                      }
        );
    }

    //method for close button
    public void OnclickButtonCloselistener(){
        button_close = (Button)findViewById(R.id.buttonclose);
        button_close.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Toast.makeText(getApplicationContext(),"App was closed!", Toast.LENGTH_SHORT).show();
                                                  finish();
                                                  //finish();
                                              }
                                          }
        );
    }

    public void  OnclinkWeblink(){
        mainweb.setMovementMethod(LinkMovementMethod.getInstance());
        mainweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse("https://www.stopcoro.com"));
                browser.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(browser);
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;
    public void onBackPressed(){
        if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(),"Click Back again to exit!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }




}
