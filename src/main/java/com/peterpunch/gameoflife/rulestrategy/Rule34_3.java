package com.peterpunch.gameoflife.rulestrategy;

import com.peterpunch.gameoflife.model.Cell;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Position;
import com.peterpunch.gameoflife.utils.NeighbourhoodUtil;

public class Rule34_3 implements Rule
{
    private NeighbourhoodUtil neighbourhoodUtil;

    public Rule34_3()
    {
        this.neighbourhoodUtil = new NeighbourhoodUtil();
    }

    @Override
    public Field apply(Field field, Position position)
    {
        Cell cell = field.getCell(position);

        int livingCells = neighbourhoodUtil.getAmountOfLivingNeighbours(field, position);

        if (!cell.isAlive() && livingCells == 3) {
            cell.revive();

            return field;
        }

        if (livingCells != 4 && livingCells != 3) {
            cell.kill();
        }

        return field;
    }
}
