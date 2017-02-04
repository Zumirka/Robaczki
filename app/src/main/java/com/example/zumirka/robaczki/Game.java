package com.example.zumirka.robaczki;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Zumirka on 2017-02-04.
 */

public class Game  extends View implements View.OnClickListener{


    public Game(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    public void onDraw(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(50);
        c.drawText("Tap the screen to start",200,200,p);
    }

    @Override
    public void onClick(View v) {

    }
}
