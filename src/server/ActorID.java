package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ActorID {
    Map<Integer, SpaceActor> actors = new HashMap<Integer, SpaceActor>();
    String[] positions = {"pilot", "gunner"};
}
