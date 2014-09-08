package com.peterpunch.gameoflife.drawer;

import com.peterpunch.gameoflife.model.Cell;
import com.peterpunch.gameoflife.model.Field;

public interface Drawer
{
    public void drawCell(Cell cell);

    public void drawField(Field field);
}
