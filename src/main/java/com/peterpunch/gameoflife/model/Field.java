package com.peterpunch.gameoflife.model;

import com.peterpunch.gameoflife.exception.FieldNotRectangularException;
import com.peterpunch.gameoflife.validators.CellsFieldIsRectangularValidator;

public class Field
{
    private static CellsFieldIsRectangularValidator validator = new CellsFieldIsRectangularValidator();

    private final Cell[][] cells;

    public Field(Cell[][] cells)
    {
        if (!validator.isValid(cells)) {
            throw new FieldNotRectangularException();
        }

        this.cells = cells;
    }

    public int getHeight()
    {
        return cells.length;
    }

    public int getWidth()
    {
        return cells[0].length;
    }

    public Cell getCell(Position position)
    {
        Position normalized = position.normalize(getHeight(), getWidth());
        return cells[normalized.y][normalized.x];
    }

    public void commit()
    {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                Cell cell = cells[i][j];
                cell.commit();
            }
        }

    }
}
