package com.peterpunch.gameoflife.model;

import com.peterpunch.gameoflife.utils.FieldCreator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FieldTest
{
    private Field field;

    private Map<Pos, Cell> cells;

    @Before
    public void setUp() throws Exception
    {
        cells = new HashMap<Pos, Cell>();
    }

    @Test
    public void new_should_create_field_with_correct_height() throws Exception
    {
        field = new Field(2, 2, cells);

        assertEquals(2, field.getHeight());
    }

    @Test
    public void new_should_create_field_with_correct_width() throws Exception
    {
        field = new Field(2, 1, cells);

        assertEquals(1, field.getWidth());
    }

    @Test
    public void is_alive_should_return_true() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_alive_and_0.txt").getFile()));

        assertTrue(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void is_alive_should_return_false() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_dead.txt").getFile()));

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void kill_should_kill_correct_cell() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_alive_and_0.txt").getFile()));
        assertTrue(field.isAlive(Pos.p(1, 1)));

        field.kill(Pos.p(1, 1));
        field.commit();

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void kill_should_let_cell_dead() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_dead.txt").getFile()));
        assertFalse(field.isAlive(Pos.p(1, 1)));

        field.kill(Pos.p(1, 1));
        field.commit();

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void revive_should_revive_correct_cell() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_dead.txt").getFile()));
        assertFalse(field.isAlive(Pos.p(1, 1)));

        field.revive(Pos.p(1, 1));
        field.commit();

        assertTrue(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void revive_should_leave_cell_alive() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_alive_and_0.txt").getFile()));
        assertTrue(field.isAlive(Pos.p(1, 1)));

        field.revive(Pos.p(1, 1));
        field.commit();

        assertTrue(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void commit_should_commit_all_cells() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_dead.txt").getFile()));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field.revive(Pos.p(i, j));
            }
        }

        field.commit();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(field.isAlive(Pos.p(i, j)));
            }
        }
    }
}
