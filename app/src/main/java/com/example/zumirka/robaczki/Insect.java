package com.example.zumirka.robaczki;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Insect {
    private RectF oval;
    public Insect(int x,int y,int w,int h)
    {

        oval=new RectF(x,y,x+w,y+h);


    }
    public RectF getRect(){

        return this.oval;
    }
    public  void drawInsect(Canvas c)
    {
        Paint paint = new Paint();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        c.drawOval(getRect(), paint);
    }

}
