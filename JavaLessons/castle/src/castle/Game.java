package castle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private Room currentRoom;
    private List<Room> rooms = new ArrayList<>();
    private Map<String, Handler> handlers = new HashMap<>();
        
    public Game() 
    {
    	handlers.put("go", new Handler() {
    		@Override
    		public void doCmd(String value) {
    			goRoom(value);
    		}
    	});
    	handlers.put("help",new Handler() {
    		@Override
    		public void doCmd(String value) {
    			System.out.println("迷路了吗？你可以做的命令有：");
    			for (String s : getHandlers()) {
    				System.out.print(s+" ");
    			}
    			System.out.println();
    			System.out.println("如：\tgo east");
    		}
    	});
    	handlers.put("bye", new Handler() {
    		@Override
    		public boolean isBye() {
    			return true;
    		}
    	});
    	handlers.put("next", new Handler() {
    		@Override
    		public void doCmd(String word) {
    			nextRoom();
    		}
    	});
        handlers.put("random", new Handler() {
        	@Override
        	public void doCmd(String word) {
        		useRandomDoor();
        	}
        });
//        handlers.put("talk", new HandlerTalk(this));
//        handlers.put("search", new HandlerSearch(this));
    	createRooms();
    }

    private void createRooms()
    {
        //	制造房间
        Room outside = new Room("城堡外","假山");
        Room lobby = new Room("大堂","大理石雕像");
        Room pub = new Room("小酒吧","酒柜");
        Room study = new Room("书房","藏书和橘猫");
        Room bedroom = new Room("卧室","老婆大人");
        Room winestore = new Room("酒窖","拉菲");
        Room toilet = new Room("卫生间","黄金马桶");
        Room bathroom = new Room("浴室","水晶浴缸");
        Room dinner = new Room("餐厅","面包蟹");
        Room kitchen = new Room("厨房","厨神菜刀");
        Room store = new Room("储藏室","金子");
        rooms.add(outside);
        rooms.add(lobby);
        rooms.add(pub);
        rooms.add(study);
        rooms.add(bedroom);
        rooms.add(winestore);
        rooms.add(toilet);
        rooms.add(bathroom);
        rooms.add(dinner);
        rooms.add(kitchen);
        rooms.add(store);
        
        // 初始化Npc
//        Npc passerby = new Npc(10, 10, 10, 10, "passerby", "common");
//        Npc housekeeper = new Npc(10, 10, 10, 10, "housekeeper", "common");
//        Npc waiter = new Npc(10, 10, 10, 10, "waiter", "common");
//        Npc wife = new Npc(10, 10, 10, 10, "wife", "common");
        
        //	初始化房间的出口
        outside.setExit("north", lobby);
        outside.setExit("west", pub);
        lobby.setExit("south", outside);
        lobby.setExit("east", study);
        lobby.setExit("west", dinner);
        study.setExit("west", lobby);
        study.setExit("east", bedroom);        
        bedroom.setExit("west", study);
        bedroom.setExit("north", bathroom);
        bathroom.setExit("south", bedroom);
        dinner.setExit("east", lobby);
        dinner.setExit("north", kitchen);
        dinner.setExit("south", pub);
        kitchen.setExit("south", dinner);
        kitchen.setExit("down", store);
        store.setExit("up", kitchen);
        pub.setExit("east", outside);
        pub.setExit("north", dinner);
        pub.setExit("west", toilet);
        pub.setExit("down", winestore);
        toilet.setExit("east", pub);
        winestore.setExit("up", pub);
        
        // 初始化Npc信息
//        outside.setNpc("passerby", passerby);
//        lobby.setNpc("housekeeper", housekeeper);
//        pub.setNpc("waiter", waiter);
//        bedroom.setNpc("wife", wife);
//         
//        passerby.setTalk("common", "日子越来越难过了。");
//        housekeeper.setTalk("common", "老爷，今天您想吃点什么？。");
//        waiter.setTalk("common", "要来一瓶酒吗？。");
//        wife.setTalk("common", "老公，怎么了？。");
        
        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help'。");
        System.out.println();
        showPrompt();
    }
    
    private void printBye() {
    	System.out.println("感谢你来玩这个无聊的游戏");
    	System.out.println("期待您的下次光临。再见！");
    }

    // 以下为用户命令

    public Set<String> getHandlers() {
    	return handlers.keySet();
    }
    
    public void useRandomDoor() {
		currentRoom = rooms.get((int)(Math.random()*rooms.size()));
    	showPrompt();
    }
    
    public void nextRoom() {
    	currentRoom = currentRoom.getOneOfExit();
    	showPrompt();
    }
    
    public void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }
    
    public void showPrompt() {
    	 System.out.println("现在你在" + currentRoom);
    	 System.out.println("这里有"+currentRoom.getTreasure());
         System.out.print("出口有：");
         System.out.print(currentRoom.getExitsDesc());
         System.out.println("next random");
//         System.out.print("你看到了");
//         System.out.println(currentRoom.getNpcsum());
    }
    
//    public void showSearch(String npcname) {
//    	Npc npc = currentRoom.getNpc(npcname);
//    	System.out.println(npc.toString());
//    }
//    
//    public void showTalk(String npcname) {
//    	Npc npc = currentRoom.getNpc(npcname);
//    	if (npc == null) {
//    		System.out.println("没有这个人。");
//    	} else {
//    		System.out.println(npc.getTalk(npc.getMood()));
//    	}
//    }
    
    public void play() {
    	Scanner in = new Scanner(System.in);
    	while ( true ) {
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		if (!handlers.containsKey(words[0])) {
    			System.out.println("命令不正确，您是否需要帮助？");
    		}
    		Handler handler = handlers.get(words[0]);
    		String value = "";
    		if (words.length > 1) {
    			value = words[1];
    		}
    		if (handler != null) {
    			handler.doCmd(value);
    			if (handler.isBye()) {
    				break;
    			}
    		}
    	}
        in.close();
    }
	
	public static void main(String[] args) {
		Game game = new Game();
		game.printWelcome();
		game.play();
		game.printBye();
	}
}
