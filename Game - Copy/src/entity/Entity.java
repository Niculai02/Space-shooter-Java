package entity;

import java.awt.*;

import static java.lang.Math.sqrt;

public class Entity {

    public int x, y;
    public double speed;
    public double diagSpeed;

    {
        diagSpeed = speed / sqrt(2);
    }

    public int counter=0;
    public int k=0;
    public void edge(){
        if (x <= 0)
            x=0;
        if( x >= 576-48)
            x=576-48;
        if( y <=0 )
            y=0;
        if( y >= 672-48)
            y=672-48;
    }
    public void moveU(){
        y-=speed;
    }
    public void moveD(){
        y+=speed;
    }
    public void moveL(){
        x-=speed;
    }
    public void moveR(){
        x+=speed;
    }
    public void moveUL(){
        diagSpeed = speed / sqrt(2);
        y-=diagSpeed;
        x-=diagSpeed;
    }
    public void moveUR(){
        diagSpeed = speed / sqrt(2);
        y-=diagSpeed;
        x+=diagSpeed;
    }
    public void moveDL(){
        diagSpeed = speed / sqrt(2);
        y+=diagSpeed;
        x-=diagSpeed;
    }
    public void moveDR(){
        diagSpeed = speed / sqrt(2);
        y+=diagSpeed;
        x+=diagSpeed;
    }

    public void movementDRUR(){
        if(counter>60)
            counter=0;
        if(counter<35)
            moveDR();
        else
            moveUR();
    }

    public void movementDLUL(){
        if(counter>60)
            counter=0;
        if(counter<35)
            moveDL();
        else
            moveUL();

    }

    public void movement1(){
        if (k<3){
            if (counter > 60){
                counter=0;
                k++;
            }
            if (counter < 30)
                moveDR();
            else
                moveUR();
        }
        else{
                if (counter > 60){
                    counter=0;
                    k++;
                    if(k>6)
                        k=0;
                }
                if (counter < 30)
                    moveDL();
                else
                    moveUL();
            }
    }           ////Miscare in zig-zag
    public void movement2(){
        if(k==0){
            movementDRUR();
            if(x >= 576 - 48)
                k=1;
        }
        else{
            moveL();
            if(x <= 0)
                k=0;
        }

    }
    public void movement3(){
        if(k==0){
            moveR();
            if(x >= 576 - 48)
                k=1;
        }
        else{
            moveL();
            if(x <= 0)
                k=0;
        }
    }
    public void movement4(){
        if(k==0){
            movementDRUR();
            if(x >= 576 - 48)
                k=1;
        }
        else{
            movementDLUL();
            if(x <= 0)
                k=0;
        }

    }

    public Rectangle getBounds(int width, int height){
        return new Rectangle(x, y, width, height);
    }
   // public void delete(){
    //    this = null;
   // }



}
