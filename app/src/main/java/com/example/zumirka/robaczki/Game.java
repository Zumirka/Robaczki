package com.example.zumirka.robaczki;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class Game  extends View implements View.OnClickListener{

    private Insect insect;
    Paint p = new Paint();
    int width,height;
    long startTime = 0;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Game(Context context, AttributeSet attrs) {
        super(context,attrs);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        width = size.x;
        height = size.y;
        insect=new Insect(100,100,30,80);

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
        insect.updateInsect();
        checkWallCOlision();
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


        }
        return false;
    }
    public void checkWallCOlision()
    {
        if(insect.getRect().left<0||insect.getRect().right>width)
        {

            insect.setMove_x(-insect.getMove_x());
        }
        if(insect.getRect().top<0||insect.getRect().bottom>height)
        {

            insect.setMove_y(-insect.getMove_y());
        }
    }
}
