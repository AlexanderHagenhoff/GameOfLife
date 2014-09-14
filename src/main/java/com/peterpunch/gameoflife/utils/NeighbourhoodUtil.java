package com.peterpunch.gameoflife.utils;

import com.google.common.collect.Lists;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;

import java.util.List;

public class NeighbourhoodUtil
{
    private static Pos[] ADDITIONS;

    static {
        ADDITIONS = new Pos[]{
            Pos.p(-1, -1), Pos.p(-1, 0), Pos.p(-1, 1),
            Pos.p(0, -1), Pos.p(0, 1),
            Pos.p(+1, -1), Pos.p(+1, 0), Pos.p(+1, 1)
        };
    }

    public int getAmountOfLivingNeighbours(Field field, Pos pos)
    {
        int count = 0;

        for (Pos neighbour : getNeighbourhoodPositions(pos)) {
            count += field.isAlive(neighbour) ? 1 : 0;
        }

        return count;
    }

    public List<Pos> getNeighbourhoodPositions(Pos pos)
    {
        List<Pos> positions = Lists.newArrayList();

        for (Pos toAdd : ADDITIONS) {
            positions.add(pos.add(toAdd));
        }

        return positions;
    }
}
