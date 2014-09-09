package com.peterpunch.gameoflife.utils;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Position;

public class NeighbourhoodUtil
{
    public int getAmountOfDeadNeighbours(Field field, Position position)
    {
        int count = 0;

        count += !field.getCell(getLeftAbove(position)).isAlive() ? 1 : 0;
        count += !field.getCell(getAbove(position)).isAlive() ? 1 : 0;
        count += !field.getCell(getRightAbove(position)).isAlive() ? 1 : 0;

        count += !field.getCell(getLeft(position)).isAlive() ? 1 : 0;
        count += !field.getCell(getRight(position)).isAlive() ? 1 : 0;

        count += !field.getCell(getLeftUnder(position)).isAlive() ? 1 : 0;
        count += !field.getCell(getUnder(position)).isAlive() ? 1 : 0;
        count += !field.getCell(getRightUnder(position)).isAlive() ? 1 : 0;

        return count;
    }

    public int getAmountOfLivingNeighbours(Field field, Position position)
    {
        int count = 0;

        count += field.getCell(getLeftAbove(position)).isAlive() ? 1 : 0;
        count += field.getCell(getAbove(position)).isAlive() ? 1 : 0;
        count += field.getCell(getRightAbove(position)).isAlive() ? 1 : 0;

        count += field.getCell(getLeft(position)).isAlive() ? 1 : 0;
        count += field.getCell(getRight(position)).isAlive() ? 1 : 0;

        count += field.getCell(getLeftUnder(position)).isAlive() ? 1 : 0;
        count += field.getCell(getUnder(position)).isAlive() ? 1 : 0;
        count += field.getCell(getRightUnder(position)).isAlive() ? 1 : 0;

        return count;
    }

    private Position getLeftAbove(Position position)
    {
        return new Position(position.y - 1, position.x - 1);
    }

    private Position getAbove(Position position)
    {
        return new Position(position.y - 1, position.x);
    }

    private Position getRightAbove(Position position)
    {
        return new Position(position.y - 1, position.x + 1);
    }

    private Position getLeft(Position position)
    {
        return new Position(position.y, position.x - 1);
    }

    private Position getRight(Position position)
    {
        return new Position(position.y, position.x + 1);
    }

    private Position getLeftUnder(Position position)
    {
        return new Position(position.y + 1, position.x - 1);
    }

    private Position getUnder(Position position)
    {
        return new Position(position.y + 1, position.x);
    }

    private Position getRightUnder(Position position)
    {
        return new Position(position.y + 1, position.x + 1);
    }
}
