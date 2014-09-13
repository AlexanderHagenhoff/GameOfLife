package com.peterpunch.gameoflife.model;

import com.peterpunch.gameoflife.exception.FieldNotRectangularException;
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

    private Map<Position, Cell> cells;

    @Before
    public void setUp() throws Exception
    {
        cells = new HashMap<Position, Cell>();
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
    public void get_cell_should_return_correct_cell() throws Exception
    {
        cells.put(new Position(0, 0), new Cell(true));
        cells.put(new Position(0, 1), new Cell(true));
        cells.put(new Position(1, 0), new Cell(true));
        cells.put(new Position(1, 1), new Cell(true));

        field = new Field(2, 2, cells);

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                Cell cell = field.getCell(new Position(y, x));
                assertSame(cells.get(new Position(y, x)), cell);
            }
        }
    }

    @Test
    public void get_cell_should_return_correct_cell_on_edge_x() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_001.txt").getFile()));

        assertEquals(field.getCell(new Position(0, 2)), field.getCell(new Position(0, -1)));

    }

    @Test
    public void get_cell_should_return_correct_cell_on_edge_y() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_001.txt").getFile()));

        assertEquals(field.getCell(new Position(2, 0)), field.getCell(new Position(-1, 0)));

    }

    @Test
    public void get_cell_should_return_correct_cell_on_edge_2_x() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_001.txt").getFile()));

        assertEquals(field.getCell(new Position(0, 1)), field.getCell(new Position(0, -2)));

    }

    @Test
    public void get_cell_should_return_correct_cell_on_edge_2_y() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_001.txt").getFile()));

        assertEquals(field.getCell(new Position(1, 0)), field.getCell(new Position(-2, 0)));
    }

    @Test
    public void commit_should_commit_all_cells() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        field = fieldCreator.create(new File(getClass().getResource("/3x3_dead.txt").getFile()));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell cell = field.getCell(new Position(i, j));
                cell.revive();
            }
        }

        field.commit();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell cell = field.getCell(new Position(i, j));
                assertTrue(cell.isAlive());
            }
        }

    }
}