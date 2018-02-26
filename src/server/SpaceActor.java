package server;

import mayflower.Actor;

public class SpaceActor extends Actor
{
    private double velocity, maxV;

    private double acceleration, deceleration =0;


    public SpaceActor(String img, int x, int y, int r)
    {
        setImage(img);
        setLocation(x, y);
        setRotation(r);
        maxV = 25;
    }
    public SpaceActor()
    {

    }

    public double getVelocity()
    {
        return velocity;
    }

    public void addVelocity()
    {
        if(velocity <maxV){
            velocity +=acceleration;}
    }

    public void removeVelocity()
    {
        if(velocity >0){
            velocity -=deceleration;}
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void setDeceleration(double deceleration) {
        this.deceleration = deceleration;
    }

    public void fireLaser()
    {
        System.out.println("Fired");
        getWorld().addObject(new Laser(getX(),getY(),getRotation()),getX(),getY());
    }


    public void warp()
    {
        int x = this.getX();
        int y = this.getY();

        if( x < -(this.getImage().getHeight()) )
        {
            this.setLocation(1024, y );

        }
        if( x > 1024 )
        {
            this.setLocation( 0, y );

        }
        if( y < -(this.getImage().getHeight()) )
        {
            this.setLocation( x, 768 );

        }
        if( y > 768 )
        {
            this.setLocation( x, 0);

        }
    }

    public String toString()
    {
        return getImage().toString() + "_" + getX() + "_" + getY() + "_" + getRotation();
    }

    @Override
    public void act()
    {
    }

    public void tick(){
        warp();
    }
}

