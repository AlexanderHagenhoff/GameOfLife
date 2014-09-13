package com.peterpunch.gameoflife.model;

public class Pos
{
    public int y = 0;

    public int x = 0;

    public static Pos p(int y, int x)
    {
        return new Pos(y, x);
    }

    private Pos(int y, int x)
    {
        this.y = y;
        this.x = x;
    }

    public Pos normalize(int height, int width)
    {
        return new Pos(normalizeSingle(height, y), normalizeSingle(width, x));
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pos pos = (Pos) o;

        if (x != pos.x) return false;
        if (y != pos.y) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = y;
        result = 31 * result + x;
        return result;
    }
}
