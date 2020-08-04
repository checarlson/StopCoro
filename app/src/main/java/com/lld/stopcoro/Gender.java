package com.lld.stopcoro;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Gender extends AppCompatActivity {
    private static Button continuebutton;
    private static Button backbutton;
    private static TextView genweb;
    private static EditText age;
    private static String Age;
    private static ImageView imageMan, imageWoman;
    private static int age1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        genweb = (TextView) findViewById(R.id.gentxt);
        age = (EditText) findViewById(R.id.age);

        OnclickButtonContinuelistener();
        OnclickButtonBacklistener();
        OnclinkWeblink();
        //onImageMale();
        //onImageWoman();

         imageMan = (ImageView) findViewById(R.id.male);
         imageWoman = (ImageView) findViewById(R.id.female);
       /* imageMan.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(Gender.this, "Male gender selected", Toast.LENGTH_SHORT).show();
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    imageMan.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    imageMan.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE){
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())){
                        imageMan.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return true;
            }

        });

        imageWoman.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect1;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(Gender.this, "Female gender selected", Toast.LENGTH_SHORT).show();
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    imageWoman.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect1 = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    imageWoman.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE){
                    if (!rect1.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())){
                        imageWoman.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return true;
            }

        }); */


            imageMan.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Toast.makeText(Gender.this, "Male gender selected", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });



            imageWoman.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Toast.makeText(Gender.this, "Female gender selected", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });



    }

    //method for continue button
    public void OnclickButtonContinuelistener(){
        continuebutton = (Button)findViewById(R.id.buttonCon);
        continuebutton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Age = age.getText().toString();

                                                  try {
                                                      age1 = Integer.parseInt(Age);
                                                  }
                                                  catch (NumberFormatException e){
                                                      age1 = 0;
                                                  }
                                                  //age1 = -1;
                                                  if(age1 <=0 ) {
                                                      Toast.makeText(Gender.this,"Age shouldn't be less than 1", Toast.LENGTH_SHORT).show();
                                                  }
                                                  if (age1 >= 1){
                                                      Intent intent = new Intent(getApplicationContext(), SympDiagnostic.class);
                                                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                      startActivity(intent);
                                                  }
                                                  else {
                                                      Toast.makeText(Gender.this, "Please fill in the required info" , Toast.LENGTH_SHORT).show();
                                                  }

                                              }
                                          }
        );
    }

    //method for back button
    public void OnclickButtonBacklistener(){
        backbutton = (Button)findViewById(R.id.buttonback);
        backbutton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent1 = new Intent(getApplicationContext(), CheckupIntro.class);
                                                  intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                  startActivity(intent1);
                                                  //finish();

                                              }
                                          }
        );
    }

    public void  OnclinkWeblink(){
        genweb.setMovementMethod(LinkMovementMethod.getInstance());
        genweb.setOnClickListener(new View.OnClickListener() {
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
        Intent intent1 = new Intent(getApplicationContext(), CheckupIntro.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        //finish();
    }


}