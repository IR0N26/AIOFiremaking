
import AIOFiremaking.Methods.Methods;
import xobot.client.callback.listeners.MessageListener;
import xobot.client.events.MessageEvent;
import xobot.script.ActiveScript;
import xobot.script.Manifest;
import xobot.script.methods.tabs.Inventory;
import xobot.script.methods.tabs.Skills;
import xobot.script.util.Timer;
import AIOFiremaking.Utils.gui;
import AIOFiremaking.Data.Data;

@Manifest(
        authors = {"IR0N" },
        name = "IR0N's AIOFiremaker",
        description = "Burns logs in Edge or DZ.",
        version = 1.1)
class AIOFiremaking extends ActiveScript implements MessageListener{

    private Timer startTime;
    private int startLvl;
    private int startXP;

    public boolean onStart() {
        gui g = new gui();
        g.setVisible(true);
        startTime = new Timer(System.currentTimeMillis());
        startLvl = Skills.FIREMAKING.getCurrentLevel();
        startXP = Skills.FIREMAKING.getCurrentExp();
        return true;
    }

    public int loop() {
        if (Inventory.Contains(Data.logs_ID) && !Methods.cantLightFire) {
                Methods.makeFires();
            } else if (!Methods.cantLightFire && !Inventory.Contains(Data.logs_ID)) {
                Methods.getLogs();
            } else if (Methods.cantLightFire) {
                Methods.walkToAreaTile();
            }

        return 700;

    }




    /*@Override
    public void repaint(Graphics g) {
        if (started) {
            int currentLvl = Skills.FIREMAKING.getCurrentLevel();
            int currentXP = Skills.FIREMAKING.getCurrentExp();
            int xph = (int) ((currentXP - startXP) * 3600000D / (startTime.getElapsed()));
            g.drawString(startTime.toElapsedString(), 408, 365);
            g.drawString("Exp Gained: " + (currentXP - startXP), 448, 400);
            g.drawString("Levels Gained: " + (currentLvl - startLvl), 485, 382);

            g.drawString(String.valueOf(xph), 430, 418);
        }
    }*/

    @Override
    public void MessageRecieved(MessageEvent str) {
        if (str.getMessage().contains("cannot light")) {
            Methods.hasWalkedToTile = false;
        }

    }


}

