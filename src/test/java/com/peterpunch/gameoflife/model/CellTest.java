package com.peterpunch.gameoflife.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CellTest
{
    private Cell cell;

    @Test
    public void new_cell_should_create_living_cell() throws Exception
    {
        cell = new Cell(true);

        assertTrue(cell.isAlive());
    }

    @Test
    public void new_cell_should_create_dead_cell() throws Exception
    {
        cell = new Cell(false);

        assertFalse(cell.isAlive());
    }

    @Test
    public void kill_should_make_living_cell_dead_after_commit() throws Exception
    {
        cell = new Cell(true);

        cell.kill();
        cell.commit();

        assertFalse(cell.isAlive());
    }

    @Test
    public void kill_should_leave_dead_cell_dead_after_commit() throws Exception
    {
        cell = new Cell(false);

        cell.kill();
        cell.commit();

        assertFalse(cell.isAlive());
    }

    @Test
    public void kill_should_stay_alive_before_commit() throws Exception
    {
        cell = new Cell(true);

        cell.kill();

        assertTrue(cell.isAlive());
    }

    @Test
    public void kill_should_stay_dead_before_commit() throws Exception
    {
        cell = new Cell(false);

        cell.kill();

        assertFalse(cell.isAlive());
    }

    @Test
    public void revive_should_make_dead_cell_alive_after_commit() throws Exception
    {
        cell = new Cell(false);

        cell.revive();
        cell.commit();

        assertTrue(cell.isAlive());
    }

    @Test
    public void revive_should_leave_living_cell_alive_after_commit() throws Exception
    {
        cell = new Cell(true);

        cell.revive();
        cell.commit();

        assertTrue(cell.isAlive());
    }

    @Test
    public void revive_should_stay_alive_before_commit() throws Exception
    {
        cell = new Cell(true);

        cell.revive();

        assertTrue(cell.isAlive());
    }

    @Test
    public void revive_should_stay_dead_before_commit() throws Exception
    {
        cell = new Cell(false);

        cell.revive();

        assertFalse(cell.isAlive());
    }
}