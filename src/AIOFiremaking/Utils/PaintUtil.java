package AIOFiremaking.Utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;

import AIOFiremaking.Data.Data;

import xobot.script.methods.tabs.Skills;

public class PaintUtil {
    private static FontMetrics FONTMETRICS = null;

    public static void draw(Graphics g) {
        int x = 15;
        int y = 18;

        int gainedXp = Skills.FIREMAKING.getCurrentExp() - Data.startXp;
        int gainedLevels = Skills.FIREMAKING.getCurrentLevel() - Data.startLevel;

        if (FONTMETRICS == null)
            FONTMETRICS = g.getFontMetrics();

        drawGradientText(g, "AIOFiremaking", x, y += 18, Color.GREEN, 0);
        drawGradientText(g, Data.runtime.toElapsedString(), x, y += 18, Color.WHITE, -1);
        drawGradientText(
                g,
                "XP gained: " + formatNumber(gainedXp) + " /h: " + perHour(gainedXp),
                x,
                y += 18,
                Color.WHITE,
                -1
        );
        drawGradientText(g, "Levels gained: " + gainedLevels, x, y += 18, Color.WHITE, -1);

    }

    public static void drawGradientText(Graphics g, String text, int x, int y, Color c, int rectangleIndex) {

        Graphics2D g2 = (Graphics2D) g;
        Color color3 = new Color(51, 51, 51, 205);
        Font font1 = new Font("Arial", 0, 12);

        g.setFont(font1);
        FONTMETRICS = g.getFontMetrics();

        Rectangle textBox = new Rectangle(
                x,
                y - g.getFont().getSize(),
                (int) FONTMETRICS.getStringBounds(text, g).getWidth() + 8,
                (int) FONTMETRICS.getStringBounds(text, g).getHeight() + 5
        );

        Paint defaultPaint = g2.getPaint();

        g2.setPaint(
                new RadialGradientPaint(
                        new Point.Double(
                                textBox.x + textBox.width / 2.0D,
                                textBox.y + textBox.height / 2.0D
                        ),
                        (float) (textBox.getWidth() / 2.0D),
                        new float[] { 0.5F, 1.0F },
                        new Color[] {
                                new Color(color3.getRed(), color3.getGreen(), color3.getBlue(), 175),
                                new Color(0.0F, 0.0F, 0.0F, 0.8F)
                        }
                )
        );

        g.fillRect(textBox.x, textBox.y + 12, textBox.width, textBox.height);
        g2.setPaint((java.awt.Paint) defaultPaint);
        g.setColor(Color.BLACK);
        g.drawRect(textBox.x, textBox.y + 12, textBox.width, textBox.height);
        g.setColor(c);
        g.drawString(text, x + 4, y + 15);

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                g.setColor(new Color(255, 255, 255));
                g.drawString(
                        "" + text.charAt(i),
                        x + FONTMETRICS.stringWidth(text.substring(0, i)) + 4,
                        y + 15
                );
            }
        }
    }

    public static String getPercent(int value, int total) {
        if (total == 0)
            return String.format("%.2f", 0f);

        return String.format("%.2f", (double) ((double) (value * 100.00f) / total));
    }

    public static String getPercent(long value, long total) {
        if (total == 0)
            return String.format("%.2f", 0f);

        return String.format("%.2f", (double) ((double) (value * 100.00f) / total));
    }

    public static String perHour(int gained) {
        return formatNumber((int) ((gained) * 3600000D / (Data.runtime.getElapsed())));
    }

    public static String perHour(long gained) {
        return formatNumber((long) ((gained) * 3600000D / (Data.runtime.getElapsed())));
    }

    public static String formatNumber(int start) {
        double i = start;

        if (i >= 1000000) {
            return String.format("%.2f", (i / 1000000)) + "m";
        }

        if (i >= 1000) {
            return String.format("%.2f", (i / 1000)) + "k";
        }

        return "" + start;
    }

    public static String formatNumber(long start) {
        double i = start;

        if (i >= 1000000) {
            return String.format("%.2f", (i / 1000000)) + "m";
        }

        if (i >= 1000) {
            return String.format("%.2f", (i / 1000)) + "k";
        }

        return "" + start;
    }
}