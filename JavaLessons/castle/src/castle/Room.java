package castle;

import java.util.HashMap;
import java.util.Map;

public class Room {
	private String description;
	private String treasure;
	private Map<String, Room> exits = new HashMap<>();

    public Room(String description) 
    {
        this.description = description;
    }
    
    public Room(String description, String treasure) {
    	this.description = description;
    	this.treasure = treasure;
    }
    
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    public Room getOneOfExit() {
    	Object[] obj = exits.keySet().toArray();
    	return exits.get(obj[(int)(Math.random()*obj.length)]);
    }
    
    public String getExitsDesc() {
    	StringBuffer sb = new StringBuffer();
    	for (String dir : exits.keySet()) {
    		sb.append(dir);
    		sb.append(' ');
    	}
    	return sb.toString();
    }
    
    public void setExit(String dir, Room room) {
    	exits.put(dir, room);
    }
    
    public String getTreasure() {
    	return this.treasure;
    }
    
//    public Npc getNpc(String npcname) {
//    	Npc npc = new Npc();
//    	return npc;
//    }
//    
//    public void getNpcsum() {
//    	
//    }
//    
//    public void setNpc(String npcname, Npc npc) {
//    	
//    }

    @Override
    public String toString()
    {
        return description;
    }
}
