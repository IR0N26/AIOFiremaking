
import AIOFiremaking.Methods.Methods;

import java.awt.Graphics;

import xobot.client.callback.listeners.PaintListener;
import xobot.client.callback.listeners.MessageListener;
import xobot.client.events.MessageEvent;
import xobot.script.ActiveScript;
import xobot.script.Manifest;
import xobot.script.methods.tabs.Inventory;
import xobot.script.methods.tabs.Skills;
import xobot.script.util.Timer;
import AIOFiremaking.Utils.Gui;
import AIOFiremaking.Data.Data;
import AIOFiremaking.Utils.PaintUtil;
import xobot.script.util.Time;

@Manifest(
        authors = {"IR0N" },
        name = "IR0N's AIOFiremaker",
        description = "Burns logs in Edge or DZ. Start with a tinderbox in inventory",
        version = 1.2)
public class AIOFiremaking extends ActiveScript implements MessageListener, PaintListener {



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

    public boolean onStart() {

        Gui.g.setVisible(true);
        while(Gui.guiWait) Time.sleep(500);
        Data.runtime = new Timer(0);
        Data.startTime = new Timer(System.currentTimeMillis());
        Data.startLevel = Skills.FIREMAKING.getCurrentLevel();
        Data.startXp = Skills.FIREMAKING.getCurrentExp();
        return true;
    }


    @Override
    public void MessageRecieved(MessageEvent str) {
        if (str.getMessage().contains("cannot light")) {
            Methods.hasWalkedToTile = false;
        }

    }


    @Override
    public void repaint(Graphics g1) {
        PaintUtil.draw(g1);
        }

}


