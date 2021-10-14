# Web-App

**Implement Webpage in Android App.** 





This is the application for add a webpage in a android app and act like a browser. There is many actions are included like home,back,forward and refresh buttons.
<br>

## Preview
<img src="/Screenshot/1.jpg" width="300"  align="left">
<img src="/Screenshot/2.jpg" width="300" align="left">
<img src="/Screenshot/3.jpg" width="300" align="left">
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


## Implementation

First we can need the user permission pakages follows
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

And there is a link to specify the web address also and the buttons are work in event based.

```@Override
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
```


## Follow me
<h4>Hey, while you're here why don't you think of following me for awesome projects like this, ah? <a href="https://github.com/ankit-p-chandran">Follow Me on my Profile!</a></h4>

<br>
Lets grab code with chai.


