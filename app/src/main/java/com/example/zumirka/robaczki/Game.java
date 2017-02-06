package com.example.zumirka.robaczki;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Game  extends View implements View.OnClickListener{

    private Insect insect;

    public Game(Context context, AttributeSet attrs) {
        super(context,attrs);
        insect=new Insect(100,100,30,80);
    }
    public void onDraw(Canvas c) {

        insect.drawInsect(c);
    }

    @Override
    public void onClick(View v) {

    }
}
