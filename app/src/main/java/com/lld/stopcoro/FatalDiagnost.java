package com.lld.stopcoro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FatalDiagnost extends AppCompatActivity {

    private static Button cont;
    private static Button back;
    private static TextView fatalweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatal_diagnost);
        fatalweb = (TextView) findViewById(R.id.fataltxt);


        OnClickButtonContinue();
        OnClickButtonBack();
        OnclinkWeblink();
    }

    //method for continue button
    public void OnClickButtonContinue(){
        cont = (Button)findViewById(R.id.conbutton);
        cont.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(getApplicationContext(), CANPrform.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);

                                    }
                                }
        );
    }

    //method for back button
    public void OnClickButtonBack(){
        back = (Button)findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent1 = new Intent(getApplicationContext(), HavingSymptoms.class);
                                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent1);
                                        //finish();

                                    }
                                }
        );
    }

    public void  OnclinkWeblink(){
        fatalweb.setMovementMethod(LinkMovementMethod.getInstance());
        fatalweb.setOnClickListener(new View.OnClickListener() {
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

        Intent intent1 = new Intent(getApplicationContext(), HavingSymptoms.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        //finish();
    }
}
