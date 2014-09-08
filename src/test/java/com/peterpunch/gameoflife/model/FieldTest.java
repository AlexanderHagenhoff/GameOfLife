package com.peterpunch.gameoflife.model;

import com.peterpunch.gameoflife.exception.FieldNotRectangularException;
import com.peterpunch.gameoflife.utils.FieldCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FieldTest
{
    private Field field;

    @Test(expected = FieldNotRectangularException.class)
    public void new_should_should_throw_field_not_valid_exception() throws Exception
    {
        Cell[][] cells = new Cell[2][];
        cells[0] = new Cell[1];
        cells[1] = new Cell[3];

        field = new Field(cells);
    }

    @Test
    public void new_should_create_field_with_correct_height() throws Exception
    {
        Cell[][] cells = new Cell[2][1];
        cells[0][0] = new Cell(true);

        field = new Field(cells);

        assertEquals(2, field.getHeight());
    }

    @Test
    public void new_should_create_field_with_correct_width() throws Exception
    {
        Cell[][] cells = new Cell[2][1];
        cells[0][0] = new Cell(true);

        field = new Field(cells);

        assertEquals(1, field.getWidth());
    }

    @Test
    public void get_cell_should_return_correct_cell() throws Exception
    {
        Cell[][] cells = new Cell[2][2];
        cells[0][0] = new Cell(true);
        cells[0][1] = new Cell(true);
        cells[1][0] = new Cell(true);
        cells[1][1] = new Cell(true);

        field = new Field(cells);

        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[y].length; x++) {
                Cell cell = field.getCell(new Position(y, x));
                assertSame(cells[y][x], cell);
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