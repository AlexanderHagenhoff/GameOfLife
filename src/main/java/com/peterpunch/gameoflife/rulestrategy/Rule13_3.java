package com.peterpunch.gameoflife.rulestrategy;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;
import com.peterpunch.gameoflife.utils.NeighbourhoodUtil;

public class Rule13_3 implements Rule
{
    private NeighbourhoodUtil neighbourhoodUtil;

    public Rule13_3()
    {
        this.neighbourhoodUtil = new NeighbourhoodUtil();
    }

    @Override
    public Field apply(Field field, Pos pos)
    {
        boolean alive = field.isAlive(pos);
        int livingCells = neighbourhoodUtil.getAmountOfLivingNeighbours(field, pos);

        if (!alive && livingCells == 3) {
            field.revive(pos);

            return field;
        }

        if (alive && livingCells != 1 && livingCells != 3) {
            field.kill(pos);
        }

        return field;
    }
}
