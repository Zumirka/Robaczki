package com.example.zumirka.robaczki;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Insect {
    private RectF oval;
    private int x,y,w,h;
    int move_x=5;
    int move_y=5;
    public Insect(int x,int y,int w,int h)
    {
        this.x=x;
        this.y=y;
        this.w=w+x;
        this.h=h+x;
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
    public int getMove_x()
    {
        return move_x;
    }
    public int getMove_y()
    {
        return move_y;
    }
    public  void drawInsect(Canvas c)
    {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        c.drawOval(getRect(), paint);
    }
    public void setMove_x(int x)
    {
        move_x=x;
    }
    public void setMove_y(int y)
    {
        move_y=y;
    }
    public void updateInsect()
    {
        x+=(move_x);
        y+=(move_y);

    }

}
