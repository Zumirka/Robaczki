package com.example.zumirka.robaczki;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;


public class Game  extends View implements View.OnClickListener{

    private Insect insect;
    Paint p = new Paint();
    Handler h;
    Runnable runnable;
    long startTime = 0;



    public Game(Context context, AttributeSet attrs) {
        super(context,attrs);
        insect=new Insect(100,100,30,80);
        this.setOnClickListener(this);
    }
    public void onDraw(Canvas c) {

        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {

        }
        long time_interim = System.currentTimeMillis();
        int adj_move = (int) (time_interim - startTime);
        startTime = time_interim;
        invalidate();
        insect.setMove(5,5);
        insect.drawInsect(c);



    }
    @Override
    public void onClick(View v) {



    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        p.setColor(Color.RED);
        p.setTextSize(50);
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_MOVE:
                //delete insect
                moveInsect();

        }
        return false;
    }
    public void moveInsect()
    {

    }
}
