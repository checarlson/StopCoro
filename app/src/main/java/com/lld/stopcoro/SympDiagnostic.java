package com.lld.stopcoro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SympDiagnostic extends AppCompatActivity {

    private static Button cont;
    private static Button back;
    private static Switch d, f, t, di;
    private  static int w,x,y,z=0;
    private static TextView sympweb;
   //private Object buttonView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symp_diagnostic);

        sympweb = (TextView) findViewById(R.id.symptxt);


        OnClickButtonContinue();
        OnClickButtonBack();
        OnclinkWeblink();

        d = (Switch) findViewById(R.id.drycough);
        f = (Switch) findViewById(R.id.fever);
        t = (Switch) findViewById(R.id.tiredness);
        di = (Switch) findViewById(R.id.breathing);

        /*d.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        f.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        t.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        di.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);*/

        d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                w=1;
            }
        });

        f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                x=1;
            }
        });
        t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                y=1;
            }
        });

        di.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                z=1;
            }
        });
    }




    //method for continue button
    public void OnClickButtonContinue(){
        cont = (Button)findViewById(R.id.button8con);
        cont.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  if (w==1 || x==1 || y==1 || z==1){
                                                      Intent intent = new Intent(getApplicationContext(), HavingSymptoms.class);
                                                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                      startActivity(intent);
                                                  } else if(w==0 || x==0 || y==0 || z==0){
                                                      Intent intent2 = new Intent(getApplicationContext(), NoSymptoms.class);
                                                      intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                      startActivity(intent2);
                                                  }
                                              }
                                          }
        );
    }

    //method for back button
    public void OnClickButtonBack(){
        back = (Button)findViewById(R.id.button3back);
        back.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent intent1 = new Intent(getApplicationContext(), Gender.class);
                                              intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                              startActivity(intent1);
                                              //finish();

                                          }
                                      }
        );
    }

    public void  OnclinkWeblink(){
        sympweb.setMovementMethod(LinkMovementMethod.getInstance());
        sympweb.setOnClickListener(new View.OnClickListener() {
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

        Intent intent1 = new Intent(getApplicationContext(), Gender.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        //finish();
    }

}
