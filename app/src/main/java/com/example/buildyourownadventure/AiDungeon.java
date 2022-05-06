package com.example.buildyourownadventure;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.buildyourownadventure.databinding.ActivityAiDungeonBinding;

public class AiDungeon extends AppCompatActivity {
    private WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_dungeon);

        webView = (WebView) findViewById(R.id.aiWebview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://play.aidungeon.io/");
    }
}



