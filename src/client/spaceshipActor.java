package client;

import server.SpaceActor;

public class spaceshipActor extends SpaceActor {

    private int x,y,r,maxV;
    private double velocity;

    public spaceshipActor(int xCoord, int yCoord, int rotation,double velocity)
    {
        super("img/spaceship.png", xCoord, yCoord, rotation);
        this.x = xCoord; this.y = yCoord; this.r = rotation;
        this.velocity = velocity;
        maxV = 25;
    }

    public void addVelocity()
    {
        if(velocity<maxV){velocity+=5;}
    }

    public void lessVelocity()
    {
        if(velocity>0){velocity-=5;}
    }

    public void turnLeft()
    {
        turn(-2);
    }

    public void turnRight()
    {
        turn(2);
    }

    @Override
    public void tick()
    {
        super.tick();
        //System.out.println(velocity);
        this.move(velocity);
    }

    @Override
    public double getVelocity() {
        return velocity;
    }

    public String toString()
    {
        return "ship,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
    }
}