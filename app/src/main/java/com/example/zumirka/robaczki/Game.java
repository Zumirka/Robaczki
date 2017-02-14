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

import java.util.ArrayList;
import java.util.Random;

public class Game  extends View implements View.OnClickListener{

    ArrayList<Insect> insects= new ArrayList<>();
    private Insect insect;
    Paint p = new Paint();
    int width,height;
    long startTime = 0;
    private int move;
    int w,h,t,b=0;
    int insect_count=10;
    long time=0;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Game(Context context, AttributeSet attrs) {
        super(context,attrs);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        width = size.x;
        height = size.y;
        Random rand=new Random();
        for(int i=0;i<=5;i++) {
            t=rand.nextInt(100)+70;
            b=rand.nextInt(100)+80;
            w = rand.nextInt(width - t);
            h = rand.nextInt(height - b);
            int color=rand.nextInt(4);
            insects.add(new Insect(w, h, t,b,color));
        }
        for (Insect x : insects) {
            move=rand.nextInt(15)+8;
            x.setMove_x(move);
            x.setMove_y(move);
        }
    }
    public void onDraw(Canvas c) {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {

        }
        time++;
        long time_interim = System.currentTimeMillis();
        int adj_move = (int) (time_interim - startTime);
        startTime = time_interim;
        invalidate();
        checkWallColision();
        for(Insect x: insects) {
            x.updateInsect();
            x.drawInsect(c);
        }
        if(insects.isEmpty())
        {
            p.setColor(Color.CYAN);
            p.setTextSize(90);
            c.drawText("You win",width/3,height/2,p);
        }
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

                for(int i=0;i<insects.size();i++)
                {
                    if(insects.get(i).getInsect().contains(x,y))
                    {
                        insects.remove(i);
                        if(insect_count!=0) {
                            CreateNewInsect();
                            insect_count--;
                        }
                        break;
                    }
                }

        return false;
    }
    public void CreateNewInsect()
    {
        Random rand=new Random();
        t=rand.nextInt(100)+70;
        b=rand.nextInt(100)+80;
        w = rand.nextInt(width - t);
        h = rand.nextInt(height - b);
        int color=rand.nextInt(4);
            Insect ins1=new Insect(w,h,t,b,color);
          int sign=rand.nextInt(2);
        move=rand.nextInt(15)+10;
        if(sign==0)
            ins1.setMove_y(move);
        else
        ins1.setMove_y(-move);

        sign=rand.nextInt(2);
        move=rand.nextInt(15)+10;
        if(sign==0)
            ins1.setMove_x(-move);
        else
            ins1.setMove_x(move);


            insects.add(ins1);

    }
    public void checkWallColision()
    {

        for(int i=0;i<insects.size();i++)
        {
            if(time%150==0) {
                Random r=new Random();
                int sign=r.nextInt(2);
                int move=r.nextInt(15)+10;
                if(sign==2||sign==1) {
                    if (insects.get(i).getMove_x() + move <= 0)
                        insects.get(i).setMove_x(move+sign);
                    else
                        insects.get(i).setMove_x(insects.get(i).getMove_x()+move);
                }
                else {
                    if(insects.get(i).getMove_x()-move<=0)
                    insects.get(i).setMove_x( move-sign);
                    else
                        insects.get(i).setMove_x(insects.get(i).getMove_x()-move);
                }
               move=r.nextInt(15)+10;
                 sign=r.nextInt(1);
                if(sign==0||sign==1) {
                    if (insects.get(i).getMove_y() + move <= 0)
                        insects.get(i).setMove_y(move+sign);
                    else
                        insects.get(i).setMove_y(insects.get(i).getMove_y()+move);
                }
                else {
                    if(insects.get(i).getMove_y()-move<=0)
                        insects.get(i).setMove_y( move -sign);
                    else
                        insects.get(i).setMove_y(insects.get(i).getMove_y()-move);
                }

            }
           if( insects.get(i).getInsect().left <0||insects.get(i).getInsect().right>width) {


              insects.get(i).setMove_x(-(insects.get(i).getMove_x()));
           }
            if(insects.get(i).getInsect().top <0||insects.get(i).getInsect().bottom>height)
            {
                insects.get(i).setMove_y(-(insects.get(i).getMove_y()));

            }
        }

    }
}
