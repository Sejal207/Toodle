package com.example.madfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomepageActivity extends AppCompatActivity {

    private LottieAnimationView lottieSun, lottieClouds, lottieMascotDino, lottieShapeMonsterIcon;
    private Button btnShapeMonster, btnCardsCraze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Initialize Lottie animations
        lottieSun = findViewById(R.id.lottieSun);
        lottieClouds = findViewById(R.id.lottieClouds);
        lottieMascotDino = findViewById(R.id.lottieMascotDino);
        lottieShapeMonsterIcon = findViewById(R.id.lottieShapeMonsterIcon);

        // Set Lottie animations
        lottieSun.setAnimation(R.raw.sun);
        lottieClouds.setAnimation(R.raw.clouds);
        lottieMascotDino.setAnimation(R.raw.mascot_dino);
        lottieShapeMonsterIcon.setAnimation(R.raw.shape_monster_icon);

        // Ensure animations are playing
        lottieSun.playAnimation();
        lottieClouds.playAnimation();
        lottieMascotDino.playAnimation();
        lottieShapeMonsterIcon.playAnimation();

        // Initialize buttons
        btnShapeMonster = findViewById(R.id.btnShapeMonster);
        btnCardsCraze = findViewById(R.id.btnCardsCraze);

        // Set click listeners for game buttons
        btnShapeMonster.setOnClickListener(v -> {
            Toast.makeText(HomepageActivity.this, "Starting Shape Monster Game", Toast.LENGTH_SHORT).show();
            // Intent to launch Shape Monster game activity will go here
        });

        btnCardsCraze.setOnClickListener(v -> {
            Toast.makeText(HomepageActivity.this, "Starting Cards Craze Game", Toast.LENGTH_SHORT).show();
            // Intent to launch Cards Craze game activity will go here
        });

        // Initialize BottomNavigationView
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // Set listener for navigation item selection
        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navHome) {
                Toast.makeText(HomepageActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                // Already on home screen
                return true;
            } else if (itemId == R.id.navProgress) {
                Toast.makeText(HomepageActivity.this, "Progress Selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomepageActivity.this, ProfileAndProgressActivity.class));
                return true;
            } else if (itemId == R.id.navProfile) {
                Toast.makeText(HomepageActivity.this, "Profile Selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomepageActivity.this, ProfileAndProgressActivity.class));
                return true;
            } else if (itemId == R.id.navSettings) {
                Toast.makeText(HomepageActivity.this, "Settings Selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomepageActivity.this, SettingsActivity.class));
                return true;
            }
            return false;
        });
    }
}
