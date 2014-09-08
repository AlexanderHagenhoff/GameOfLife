package com.peterpunch.gameoflife.model;

public class Cell
{
    private boolean alive;

    private boolean tmpStatus;

    public Cell(boolean alive)
    {
        this.alive = alive;
        this.tmpStatus = this.alive;
    }

    public boolean isAlive()
    {
        return alive;
    }

    public void kill()
    {
        this.tmpStatus = false;
    }

    public void revive()
    {
        this.tmpStatus = true;
    }

    public void commit()
    {
        this.alive = this.tmpStatus;
    }
}
