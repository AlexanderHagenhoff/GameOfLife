package com.peterpunch.gameoflife.model;

public class Position
{
    public int y = 0;

    public int x = 0;

    public Position(int y, int x)
    {
        this.y = y;
        this.x = x;
    }

    public Position normalize(int height, int width)
    {
        return new Position(normalizeSingle(height, y), normalizeSingle(width, x));
    }

    private int normalizeSingle(int size, int position)
    {
        if (position < 0) {
            position = Math.abs(size + position);
        }

        if (position == 0) {
            return 0;
        }


        return position % size;
    }
}