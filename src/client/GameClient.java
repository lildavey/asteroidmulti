package client;

import mayflower.Actor;
import mayflower.net.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GameClient extends Client implements GameMode
{
    private GameWorld world;
    private String tempProcess = "";

    public GameClient()
    {
        this("localhost");
    }

    public GameClient(String ip)
    {
        System.out.println("Connecting");
        this.connect(ip, 1234);
        System.out.println("Connected");
    }

    public void setWorld(GameWorld world)
    {
        this.world = world;
    }

    @Override
    public void process(String s)
    {
        //if(s.equals(tempProcess)) return;
        //System.out.println("Message From Server: " + s);

        List<Actor> actors = new LinkedList<Actor>();
        ArrayList<String> parts =new ArrayList<>(Arrays.asList(s.split(":")));
        //String[] parts = s.split(":");

/*        ArrayList<String> tempParts = new ArrayList<>();
        if(!tempProcess.isEmpty())
        tempParts =new ArrayList<>(Arrays.asList(tempProcess.split(":")));
        else tempParts.add("");

        for(int q = 0; q<tempParts.size();q++)
        for(int i =0; i< parts.size();i++)
        {
            System.out.println(parts.get(i).equals(tempParts.get(q)));
            //System.out.println(tempParts.get(q));
            if(parts.get(i).equals(tempParts.get(q))) parts.remove(i);

        }*/
        for (String part: parts) {
            if (!"".equals(part) ) {
                ArrayList<String> parts2 = new ArrayList<>(Arrays.asList(part.split(",")));
                //if(parts2[0].equals("spaceship")) {
                String img = "img/" + parts2.get(0) + ".png";
                int x = Integer.parseInt(parts2.get(1));
                int y = Integer.parseInt(parts2.get(2));
                int r = Integer.parseInt(parts2.get(3));
                double v = Double.parseDouble(parts2.get(4));
                System.out.println("v = " + v);

                actors.add(new spaceshipActor(x, y, r, (int)v));
                //System.out.println("added Actor");

            }

        }
        if(null != world) {
            world.update(actors);
        }
        tempProcess = s;

    }

    @Override
    public void onDisconnect(String s) {
        System.out.println("Disconnected from server");
    }

    @Override
    public void onConnect() {
        System.out.println("Connected to server!");
    }

    @Override
    public void processPress(String action) {
        System.out.println("Sending Press: " + action+"Pressed");
        send(action+"Pressed");
    }

    @Override
    public void processRelease(String action) {
        //System.out.println("Sending Release: " + action+"Released");
        send(action+"Released");

    }
}
