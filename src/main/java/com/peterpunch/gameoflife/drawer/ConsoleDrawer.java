package com.peterpunch.gameoflife.drawer;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;

public class ConsoleDrawer implements Drawer
{
    @Override
    public void drawField(final Field field)
    {
        printStats(field);
        drawHeader(field);

        for (int y = 0; y < field.getHeight(); y++) {

            System.out.print("|");

            for (int x = 0; x < field.getWidth(); x++) {
                Pos pos = Pos.p(y, x);
                drawCell(field.isAlive(pos));
            }

            System.out.println("|");
        }

        drawHeader(field);
        System.out.println("\n");
    }

    private void printStats(Field field)
    {
        System.out.println("size: " + field.getLivingPositions().size());
    }

    private void drawHeader(Field field)
    {
        System.out.print(" ");
        for (int width = 0; width < field.getWidth(); width++) {
            System.out.print("---");
        }
        System.out.println(" ");
    }

    private void drawCell(boolean alive)
    {
        String icon = alive ? " 0 " : "   ";
        System.out.print(icon);
    }
}
