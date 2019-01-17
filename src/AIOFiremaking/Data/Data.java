package AIOFiremaking.Data;

import xobot.script.util.Timer;
import xobot.script.wrappers.Tile;

public class Data {
    public static Timer startTime;
    public static Timer runtime;
    public static int startLevel;
    public static int startXp;
    public static int logs_ID = 0;
    public static String selectedLog = "";
    public static String selectedArea = "";
    public static final int[] booth_ID = {2213, 26972, 11758};

    public static final Tile fireTileDZ1 = new Tile(2537, 3860);
    public static final Tile fireTileDZ2 = new Tile(2537, 3859);
    public static final Tile walkDZtile1 = new Tile(2534, 3871);
    public static final Tile walkDZtile2 = new Tile(2537, 3886);
    public static final Tile fireTileEdgeville1 = new Tile(3104, 3486);
    public static final Tile fireTileEdgeville2 = new Tile(3104, 3485);
    public static final Tile fireTileEdgeville3 = new Tile(3104, 3484);
    public static final Tile bankTileDZ = new Tile(2540, 3889);
    public static final Tile bankTileEdgeville = new Tile(3094, 3491);
}
