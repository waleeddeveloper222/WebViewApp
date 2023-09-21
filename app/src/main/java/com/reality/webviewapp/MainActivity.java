package com.reality.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    public String TAG = "WebViewTag";

    String testUrl = "https://bh-dev.sidevs.com/store/login/1";

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = findViewById(R.id.test_web_view);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.requestFocusFromTouch();

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {

                Log.d(TAG, "onJsAlert message = " + message);
                Log.d(TAG, "onJsAlert result = " + result.toString());
                Log.d(TAG, "onJsAlert url = " + url);

                return super.onJsAlert(view, url, message, result);

            }

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {

                Log.d(TAG, "onConsoleMessage message = " + consoleMessage.message());
                Log.d(TAG, "onConsoleMessage lineNumber = " + consoleMessage.lineNumber());
                Log.d(TAG, "onConsoleMessage sourceId = " + consoleMessage.sourceId());
                Log.d(TAG, "onConsoleMessage messageLevel = " + consoleMessage.messageLevel());
                Log.d(TAG, "onConsoleMessage url = " + testUrl);

                return super.onConsoleMessage(consoleMessage);
            }
        });

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });


        webView.loadUrl(testUrl);

    }
}