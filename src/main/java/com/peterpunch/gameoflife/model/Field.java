package com.peterpunch.gameoflife.model;

import java.util.Map;

public class Field
{
    private int height;

    private int width;

    private Map<Position, Cell> cells;

    public Field(int height, int width, Map<Position, Cell> cells)
    {
        this.height = height;
        this.width = width;
        this.cells = cells;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public Cell getCell(Position position)
    {
        Position normalized = position.normalize(getHeight(), getWidth());
        Cell cell = cells.get(normalized);

        if (cell == null) {
            cell = new Cell(false);
            cells.put(normalized, cell);
        }

        return cell;
    }

    public void commit()
    {
        for (Position position : cells.keySet()) {
            Cell cell = cells.get(position);

            if (cell != null) {
                cell.commit();
            }
        }
    }
}
