package AIOFiremaking.Methods;

import AIOFiremaking.Data.Data;
import xobot.client.callback.listeners.MessageListener;
import xobot.client.events.MessageEvent;
import xobot.script.methods.*;
import xobot.script.methods.input.KeyBoard;
import xobot.script.methods.tabs.Inventory;
import xobot.script.util.Random;
import xobot.script.util.Time;
import xobot.script.wrappers.Tile;
import xobot.script.wrappers.interactive.GameObject;
import xobot.script.wrappers.interactive.Player;

public class Methods implements MessageListener {
    private static final Player myPlayer = Players.getMyPlayer();
    public static boolean cantLightFire = false;
    public static boolean hasWalkedToTile = false;

    public static void makeFires() {
        if (hasWalkedToTile) {
            walkToAreaTile();
        } else {
            if (myPlayer.getAnimation() == -1 && !myPlayer.isMoving()) {
                int slot = Inventory.getItem(Data.logs_ID).getSlot();
                int boxslot = Inventory.getItem(590).getSlot();
                Tile currentloc = myPlayer.getLocation();
                GameObject fire = GameObjects.getNearest(2732);
                if (fire != null && fire.getLocation().equals(currentloc)) {
                    cantLightFire = true;
                } else if (Inventory.Contains(590)) {
                    Packets.sendAction(447, 590, boxslot, 3214);
                    Packets.sendAction(870, 1519, slot, 3214);
                    Time.sleep(1000);
                } else {
                    System.out.println("No tinderbox in inventory!");
                    Time.sleep(2000);
                }
            }
        }
    }

    public static void walkToAreaTile() {
        if (Data.selectedArea.equals("Donator Zone")) {
            if (Data.bankTileDZ.isReachable()) {
                int i = Random.nextInt(0, 2);
                switch (i) {
                    case 0:
                        Walking.walkTo(Data.fireTileDZ1);
                        break;
                    case 1:
                        Walking.walkTo(Data.fireTileDZ2);
                        break;
                }
            } else {
                goToDZ();
            }

        } else if (Data.selectedArea.equals("Edgeville")) {
            if (Data.bankTileEdgeville.isReachable()) {
                int i = Random.nextInt(0, 3);
                switch (i) {
                    case 0:
                        Walking.walkTo(Data.fireTileEdgeville1);
                        break;
                    case 1:
                        Walking.walkTo(Data.fireTileEdgeville2);
                        break;
                    case 2:
                        Walking.walkTo(Data.fireTileEdgeville3);
                        break;
                }
            } else {
                goToEdge();
            }


        }

        cantLightFire = false;
        hasWalkedToTile = true;

    }

    private static void goToEdge() {
        Packets.sendAction(315, 1, -2, 25654);
        Time.sleep(4000, 5500);
        walkToAreaTile();
        Time.sleep(3000);
        hasWalkedToTile = true;

    }

    private static void goToDZ() {
        KeyBoard.typeWord("::dz", true);
        Time.sleep(1000, 1200);
        walkToAreaTile();
        Time.sleep(3000);
        hasWalkedToTile = true;
    }

    public static void getLogs() {
        GameObject booth = GameObjects.getNearest(Data.booth_ID);
        if (booth != null && !Bank.isOpen() && booth.getDistance() < 5 && !myPlayer.isMoving() && booth.isOnScreen()) {
            booth.interact("Use ");
            hasWalkedToTile = false;
            Time.sleep(2500);
        } else if (myPlayer.getAnimation() == -1 && !Inventory.Contains(Data.logs_ID) && !Bank.isOpen()) {
            walkToSelectedAreaBank();
        } else if (Bank.isOpen()) {
            if (Bank.getItem(Data.logs_ID) != null) {
                Bank.withdraw(Data.logs_ID, 27);
                Time.sleep(1000, 1200);
                Packets.sendAction(200, 4155, 19, 5384);
                Time.sleep(1000, 1300);
            }
        } else {
            System.out.println("No logs found!");
            Time.sleep(2000);
        }
    }

    private static void walkToSelectedAreaBank() {
        if (Data.selectedArea.equals("Edgeville")) {
            Walking.walkTo(Data.bankTileEdgeville);
        } else if (Data.selectedArea.equals("Donator Zone")) {
            Walking.walkTo(Data.bankTileDZ);
        }

    }
    @Override
    public void MessageRecieved(MessageEvent str) {
        if (str.getMessage().contains("cannot light")) {
           hasWalkedToTile = false;
        }

    }
}
