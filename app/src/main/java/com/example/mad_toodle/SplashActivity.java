package com.example.mad_toodle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private BubbleAnimationView bubbleView;
    private LinearLayout logoContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bubbleView = findViewById(R.id.bubbleView);
        logoContainer = findViewById(R.id.logoContainer);

        // Step 1: Explode after 2s
        new Handler().postDelayed(() -> {
            bubbleView.explodeBubbles();
        }, 2000);

// Step 2: Show logo AFTER bubbles are offscreen (e.g., after 4s total)
        new Handler().postDelayed(() -> {
            logoContainer.setAlpha(0f);
            logoContainer.setVisibility(View.VISIBLE);
            logoContainer.animate().alpha(1f).setDuration(1000).start();
        }, 4000);

// Step 3: Navigate to Login screen later (e.g., at 6.5s)
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }, 10000);

    }
}
