package com.lld.stopcoro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CANPrform extends AppCompatActivity {

    private static Button cont;
    private static Button back;
    private static RadioButton yes, no;
    private  static  int x=0, y=0;
    private static TextView canweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canprform);

        canweb = (TextView) findViewById(R.id.cantxt);

        OnClickButtonContinue();
        OnClickButtonBack();
        OnclinkWeblink();

        yes = (RadioButton) findViewById(R.id.radioButtonYes);
        no = (RadioButton) findViewById(R.id.radioButtonNo);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonYes:
                        x = 1;
                        y= 0;
                        Toast.makeText(getApplicationContext(),"YES", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonNo:
                        y = 1;
                        x = 0;
                        Toast.makeText(getApplicationContext(),"NO", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return;
                }
            }
        });


    }


    //method for continue button
    public void OnClickButtonContinue(){
        cont = (Button)findViewById(R.id.buttonConti);
        cont.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (x == 1) {
                                            Intent intent = new Intent(getApplicationContext(), LiklyToKoro.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                        }

                                         else if (y == 1){
                                            Intent intent1 = new Intent(getApplicationContext(), YouHavecorona.class);
                                             intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent1);
                                        }

                                    }
                                }
        );
    }

    //method for back button
    public void OnClickButtonBack(){
        back = (Button)findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent2 = new Intent(getApplicationContext(), FatalDiagnost.class);
                                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent2);
                                        //finish();

                                    }
                                }
        );
    }

    public void  OnclinkWeblink(){
        canweb.setMovementMethod(LinkMovementMethod.getInstance());
        canweb.setOnClickListener(new View.OnClickListener() {
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

        Intent intent1 = new Intent(getApplicationContext(), FatalDiagnost.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        //finish();
    }

}
