package com.example.zumirka.robaczki;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;

public class Insect {
    private RectF oval;
    private int x,y,w,h;
    int move_x,move_y,color;
    public Insect(int x,int y,int w,int h, int color)
    {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.color=color;
        oval=new RectF(x,y,this.w,this.h);
    }
    public RectF getInsect(){

        oval.left=x;
        oval.top= y;
        oval.bottom=y+h;
        oval.right=x+w;

        return oval;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getMove_x()
    {
        return move_x;
    }
    public int getMove_y()
    {
        return move_y;
    }
    public void setMove_x(int x)
    {
        move_x=x;
    }
    public void setMove_y(int y)
    {
        move_y=y;
    }


    public  void drawInsect(Canvas c)
    {
        Paint paint = new Paint();
       // paint.setStyle(Paint.Style.FILL);
        if(color==1)
            paint.setColor(Color.WHITE);
        if(color==2)
            paint.setColor(Color.RED);
        if(color==3)
            paint.setColor(Color.CYAN);
        if(color==0)
            paint.setColor(Color.YELLOW);


        c.drawOval(getInsect(), paint);
    }

    public void updateInsect()
    {

        x+=(move_x);
        y+=(move_y);

    }

}
