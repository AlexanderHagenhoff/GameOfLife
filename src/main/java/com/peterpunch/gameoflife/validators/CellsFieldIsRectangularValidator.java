package com.peterpunch.gameoflife.validators;

import com.peterpunch.gameoflife.model.Cell;

public class CellsFieldIsRectangularValidator implements Validator<Cell[][]>
{
    @Override
    public boolean isValid(Cell[][] validation)
    {
        if (validation == null) {
            return false;
        }

        int width = validation.length;
        if (width == 0) {
            return false;
        }

        int height = validation[0].length;
        for (int i = 1; i < width; i++) {
            if (height != validation[i].length) {
                return false;
            }
        }

        return true;
    }
}
