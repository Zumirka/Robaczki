package com.example.zumirka.robaczki;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Insect {
    private RectF oval;
    private int x,y,w,h,move_x,move_y;
    public Insect(int x,int y,int w,int h)
    {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        oval=new RectF(x,y,x+w,y+h);
    }
    public RectF getRect(){

        float x=(this.x+move_x );
        float y=( this.y+move_y) ;
        oval.left=x;
        oval.top= y;
        oval.bottom=x+w;
        oval.right=y+h;
        return this.oval;
    }
    public int  getX()
    {
        return x;
    }
    public  int getY()
    {
        return y;
    }
    public  int getW()
    {
        return w;
    }
    public  int getH()
    {
        return h;
    }
    public  void drawInsect(Canvas c)
    {
        Paint paint = new Paint();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        c.drawOval(getRect(), paint);
    }
    public void setMove(int move_x,int move_y)
    {
        this.move_x=move_x;
        this.move_y=move_y;
        x+=move_x;
        y+=move_y;

    }

}
