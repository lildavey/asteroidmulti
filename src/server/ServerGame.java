package server;

import mayflower.*;
import mayflower.net.Server;

import java.util.HashMap;
import java.util.Map;

public class ServerGame extends Mayflower
{
    private Map<Integer, SpaceActor> actors;
    private ServerWorld world;

    public ServerGame(Server server)
    {
        super("Server", 1024, 768);
        actors = new HashMap<Integer, SpaceActor>();

        world = new ServerWorld(server);
        this.setWorld(world);
    }

    public void process(int i, String s)
    {
        SpaceActor actor = actors.get(i);
        if(actor != null)
        {

            /*switch(s)
            {
                case "up":
                    actor.setAcceleration(1);
                    break;
                case "down":
                    break;
                case "left":
                    actor.turn(-5);
                    break;
                case "right":
                    actor.turn(5);
                    break;

            }*/

            if(s.equals("upPressed")) {
                actor.setAcceleration(3);
                actor.setDeceleration(0);
            }
            else if(!s.equals("upPressed")){
                actor.setAcceleration(0);
                actor.setDeceleration(.05);
            }
            //if(s.equals("downPressed"))
            if(s.equals("leftPressed")) actor.turn(-5);
            if(s.equals("rightPressed")) actor.turn(5);

            System.out.println(s);


        }
    }

    public void join(int i)
    {

        int x = (int)(Math.random() * 700) + 50;
        int y = (int)(Math.random() * 500) + 50;
        SpaceActor actor = new spaceshipActor(x,y,0,0);
        world.addObject(actor, x, y);

        actors.put(i, actor);
    }

    public void leave(int i)
    {
        Actor actor = actors.get(i);
        if(null != actor)
        {
            world.removeObject(actor);
        }
    }

    @Override
    public void init()
    {
    }
}
