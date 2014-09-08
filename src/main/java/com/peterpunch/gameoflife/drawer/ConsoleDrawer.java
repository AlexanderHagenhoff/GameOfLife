package com.peterpunch.gameoflife.drawer;

import com.peterpunch.gameoflife.model.Cell;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Position;

public class ConsoleDrawer implements Drawer
{
    @Override
    public void drawCell(Cell cell)
    {
        String icon = cell.isAlive() ? " @ " : "   ";
        System.out.print(icon);
    }

    @Override
    public void drawField(final Field field)
    {
        drawHeader(field);

        for (int y = 0; y < field.getHeight(); y++) {

            System.out.print("|");

            for (int x = 0; x < field.getWidth(); x++) {
                drawCell(field.getCell(new Position(y, x)));
            }

            System.out.println("|");
        }

        drawHeader(field);
        System.out.println("\n");
    }

    private void drawHeader(Field field)
    {
        System.out.print(" ");
        for (int width = 0; width < field.getWidth(); width++) {
            System.out.print("---");
        }
        System.out.println(" ");
    }
}
