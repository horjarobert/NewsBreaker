package com.example.roby.newsbreakerGo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class hckr extends AppCompatActivity {

    private WebView webView;
    private ImageView HCKRimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hckr);

        //navbar-fullscreen
        hideNavigationBar();

        //for webview...
        webView = (WebView) findViewById(R.id.webview_hckr);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://news.ycombinator.com/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //for sharedAction
        HCKRimage = (ImageView) findViewById(R.id.hckr_image);

        //HCKRimage go back to MainACtivity
        HCKRimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMain = new Intent(hckr.this, MainActivity.class);


                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(HCKRimage, "imageTransitionHCKR");
                pairs[1] = new Pair<View, String>(webView, "textTransitionHCKR");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(hckr.this, pairs);


                startActivity(goToMain, options.toBundle());
            }
        });
    }

    //for webview, to keep in mind GoBack function
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {

            super.onBackPressed();
        }
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
}
