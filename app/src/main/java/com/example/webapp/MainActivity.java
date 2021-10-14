package com.example.webapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.myWebView);
        progressBar = findViewById(R.id.progressBar);

        myWebView.loadUrl("https://www.google.com");
        myWebView.getSettings().setJavaScriptEnabled(true);


        myWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                setTitle(title);
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBar.setProgress(newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });


        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
//                progressBar.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.backMenu){
            if(myWebView.canGoBack()){
                myWebView.goBack();
            }
            else {
                showExitDialoge();

//                finish();
//            super.onBackPressed();
            }
        }
        else if(item.getItemId() == R.id.forwardMenu){
            if(myWebView.canGoForward()){
                myWebView.goForward();
            }
        }
        else if(item.getItemId()==R.id.refreshMenu){
            myWebView.reload();
        }
        else {
            myWebView.loadUrl("https://www.google.com");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(myWebView.canGoBack()){
            myWebView.goBack();
        }
        else {
            showExitDialoge();
//            finish();
//            super.onBackPressed();
        }
//        super.onBackPressed();
    }
    private void showExitDialoge(){
        AlertDialog.Builder myExist = new AlertDialog.Builder(MainActivity.this);
        myExist.setTitle("Exit App?");
        myExist.setMessage("Are you sure want to exit?");
        myExist.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        myExist.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        myExist.create();
        myExist.show();

    }

}