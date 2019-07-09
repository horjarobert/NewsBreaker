package com.example.roby.newsbreakerGo;

import android.animation.AnimatorSet;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ImageView CNNImage;
    private ImageView HCKRImage;
    private ImageView TECHImage;
    private ImageView IDFImage;

    private TextView HCKRText;
    private TextView CNNText;
    private TextView TECHText;
    private TextView IDFText;
    private TextView news;
    private TextView breaker;

    private LinearLayout row1_lay;
    private LinearLayout row2_lay;
    private LinearLayout row3_lay;
    private LinearLayout row4_lay;

    private Animation cnnImg, cnnTxt, hckrImg, hckrTxt, idfImg, idfTxt, techImg, techTxt, newsAnim, breakAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //navbar-fullscreen
        hideNavigationBar();

        //for sharedAction
        CNNImage = (ImageView) findViewById(R.id.cnn_image);
        HCKRImage = (ImageView) findViewById(R.id.hckr_image);
        TECHImage = (ImageView) findViewById(R.id.tech_image);
        IDFImage = (ImageView) findViewById(R.id.idf_image);

        CNNText = (TextView) findViewById(R.id.cnn_text);
        HCKRText = (TextView) findViewById(R.id.hckr_text);
        TECHText = (TextView) findViewById(R.id.tech_text);
        IDFText = (TextView) findViewById(R.id.idf_text);
        news = (TextView) findViewById(R.id.news);
        breaker = (TextView) findViewById(R.id.breaker);

        row1_lay = (LinearLayout) findViewById(R.id.row1_lay);
        row2_lay = (LinearLayout) findViewById(R.id.row2_lay);
        row3_lay = (LinearLayout) findViewById(R.id.row3_lay);
        row4_lay = (LinearLayout) findViewById(R.id.row4_lay);


        //animation onLoad
        cnnTxt = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        cnnImg = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        hckrTxt = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        hckrImg = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        idfImg = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        idfTxt = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        techImg = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        techTxt = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        newsAnim = AnimationUtils.loadAnimation(this, R.anim.down_to_top);
        breakAnim = AnimationUtils.loadAnimation(this, R.anim.top_to_down);


        CNNText.setAnimation(cnnTxt);
        CNNImage.setAnimation(cnnImg);
        HCKRText.setAnimation(hckrTxt);
        HCKRImage.setAnimation(hckrImg);
        IDFImage.setAnimation(idfImg);
        IDFText.setAnimation(idfTxt);
        TECHImage.setAnimation(techImg);
        TECHText.setAnimation(techTxt);
        news.setAnimation(newsAnim);
        breaker.setAnimation(breakAnim);

        row1_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCNN = new Intent(MainActivity.this, cnn.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(CNNImage, "imageTransition");
                pairs[1] = new Pair<View, String>(CNNText, "textTransition");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);


                startActivity(goToCNN, options.toBundle());

            }
        });


        row2_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHckr = new Intent(MainActivity.this, hckr.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(HCKRImage, "imageTransitionHCKR");
                pairs[1] = new Pair<View, String>(HCKRText, "textTransitionHCKR");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);


                startActivity(goToHckr, options.toBundle());

            }
        });

        row3_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToIdf = new Intent(MainActivity.this, idf.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(IDFImage, "imageTransitionIDF");
                pairs[1] = new Pair<View, String>(IDFText, "textTransitionIDF");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);


                startActivity(goToIdf, options.toBundle());

            }
        });


        row4_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTech = new Intent(MainActivity.this, tech.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(TECHImage, "imageTransitionTECH");
                pairs[1] = new Pair<View, String>(TECHText, "textTransitionTECH");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);


                startActivity(goToTech, options.toBundle());

            }
        });

    }

    //hide the navigation bar and make full screen all app
    private void hideNavigationBar(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }

    //when I exit for a moment from the app and I'll come back, the same effect must be continue
    @Override
    protected void onResume(){
        super.onResume();

        hideNavigationBar();
    }

    public void Architect(View v){
        Toast.makeText(this, "Architect: Horja Robert Emanuel", Toast.LENGTH_LONG).show();

    }
}
