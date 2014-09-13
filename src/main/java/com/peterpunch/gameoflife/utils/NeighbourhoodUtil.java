package com.peterpunch.gameoflife.utils;

import com.google.common.collect.Lists;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;

import java.util.List;

public class NeighbourhoodUtil
{
    public int getAmountOfLivingNeighbours(Field field, Pos pos)
    {
        int count = 0;

        count += field.isAlive(getLeftAbove(pos)) ? 1 : 0;
        count += field.isAlive(getAbove(pos)) ? 1 : 0;
        count += field.isAlive(getRightAbove(pos)) ? 1 : 0;

        count += field.isAlive(getLeft(pos)) ? 1 : 0;
        count += field.isAlive(getRight(pos)) ? 1 : 0;

        count += field.isAlive(getLeftUnder(pos)) ? 1 : 0;
        count += field.isAlive(getUnder(pos)) ? 1 : 0;
        count += field.isAlive(getRightUnder(pos)) ? 1 : 0;

        return count;
    }

    public List<Pos> getNeighbourhoodPositions(Pos pos)
    {
        List<Pos> positions = Lists.newArrayList();
        positions.add(getLeftAbove(pos));
        positions.add(getAbove(pos));
        positions.add(getRightAbove(pos));
        positions.add(getLeft(pos));
        positions.add(getRight(pos));
        positions.add(getLeftUnder(pos));
        positions.add(getUnder(pos));
        positions.add(getRightUnder(pos));

        return positions;
    }

    private Pos getLeftAbove(Pos pos)
    {
        return Pos.p(pos.y - 1, pos.x - 1);
    }

    private Pos getAbove(Pos pos)
    {
        return Pos.p(pos.y - 1, pos.x);
    }

    private Pos getRightAbove(Pos pos)
    {
        return Pos.p(pos.y - 1, pos.x + 1);
    }

    private Pos getLeft(Pos pos)
    {
        return Pos.p(pos.y, pos.x - 1);
    }

    private Pos getRight(Pos pos)
    {
        return Pos.p(pos.y, pos.x + 1);
    }

    private Pos getLeftUnder(Pos pos)
    {
        return Pos.p(pos.y + 1, pos.x - 1);
    }

    private Pos getUnder(Pos pos)
    {
        return Pos.p(pos.y + 1, pos.x);
    }

    private Pos getRightUnder(Pos pos)
    {
        return Pos.p(pos.y + 1, pos.x + 1);
    }
}
