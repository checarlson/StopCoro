package com.lld.stopcoro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckupIntro extends AppCompatActivity {

    private static Button button_cont;
    private static Button button_back;
    private static TextView checkweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkup_intro);
        checkweb = (TextView) findViewById(R.id.checktxt);

        OnclickButtonContinlistener();
        OnclickButtonBacklistener();
        OnclinkWeblink();


    }

    //method for continu button
    public void OnclickButtonContinlistener(){
        button_cont = (Button)findViewById(R.id.buttoncontinue);
        button_cont.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent intent = new Intent(getApplicationContext(), Gender.class);
                                                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                 startActivity(intent);

                                             }
                                         }
        );
    }

    //method for back button
    public void OnclickButtonBacklistener(){
        button_back = (Button)findViewById(R.id.buttonback0);
        button_back.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                                               intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                               startActivity(intent1);
                                               //finish();

                                           }
                                       }
        );
    }

    public void  OnclinkWeblink(){
        checkweb.setMovementMethod(LinkMovementMethod.getInstance());
        checkweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse("https://www.stopcoro.com"));
                //browser.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(browser);
            }
        });
    }

    public void onBackPressed(){
        super.onBackPressed();

        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent2);
        //finish();
    }


}
