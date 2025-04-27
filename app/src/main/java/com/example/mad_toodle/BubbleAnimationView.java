package com.example.mad_toodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleAnimationView extends View {

    private Paint paint;
    private List<Bubble> bubbles;
    private final Handler handler = new Handler();
    private boolean isExploding = false;

    public BubbleAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bubbles = new ArrayList<>();
        post(this::generateBubbles); // delay until view size is known
        handler.post(updateRunnable);
    }

    private void generateBubbles() {
        Random random = new Random();
        int width = getWidth();
        int height = getHeight();

        int numBubbles = 28;

        for (int i = 0; i < numBubbles; i++) {
            int radius = random.nextInt(120) + 160; // 120–220 px for variety

            // Position bubbles randomly across screen
            int x = random.nextInt(width + radius) - radius / 2;
            int y = random.nextInt(height + radius) - radius / 2;

            int color = getRandomColor();
            bubbles.add(new Bubble(x, y, radius, color));
        }
    }



    private int getRandomColor() {
        int[] colors = {
                Color.parseColor("#F1C40F"),
                Color.parseColor("#3F703B"),
                Color.parseColor("#457B9D")
        };
        return colors[new Random().nextInt(colors.length)];
    }

    private final Runnable updateRunnable = new Runnable() {
        @Override
        public void run() {
            updateBubbles();
            invalidate();
            handler.postDelayed(this, 16);
        }
    };

    private void updateBubbles() {
        if (!isExploding) return; // Don’t move until explosion

        for (Bubble bubble : bubbles) {
            bubble.x += bubble.dx;
            bubble.y += bubble.dy;
        }
    }


    public void explodeBubbles() {
        isExploding = true;
        Random random = new Random();
        for (Bubble bubble : bubbles) {
            bubble.dx = random.nextInt(40) - 20; // -20 to +20
            bubble.dy = random.nextInt(40) - 20;
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for (Bubble bubble : bubbles) {
            paint.setColor(bubble.color);
            canvas.drawCircle(bubble.x, bubble.y, bubble.radius, paint);
        }
    }

    private static class Bubble {
        float x, y;
        int radius, color;
        float dx = 0, dy = 0;

        Bubble(int x, int y, int radius, int color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
        }
    }
}

