package com.peterpunch.gameoflife.validators;

import com.peterpunch.gameoflife.model.Cell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CellsFieldIsRectangleValidatorTest
{
    private CellsFieldIsRectangularValidator validator;

    @Before
    public void setUp() throws Exception
    {
        validator = new CellsFieldIsRectangularValidator();
    }

    @Test
    public void is_valid_should_return_true() throws Exception
    {
        Cell[][] cells = new Cell[2][2];

        boolean valid = validator.isValid(cells);

        assertTrue(valid);
    }

    @Test
    public void is_valid_should_return_false() throws Exception
    {
        Cell[] cellRow1 = new Cell[2];
        Cell[] cellRow2 = new Cell[3];
        Cell[][] cells = {cellRow1, cellRow2};

        boolean valid = validator.isValid(cells);

        assertFalse(valid);
    }

    @Test
    public void is_valid_should_return_false_on_empty_arrays() throws Exception
    {
        Cell[][] cells = new Cell[0][0];

        boolean valid = validator.isValid(cells);

        assertFalse(valid);
    }

    @Test
    public void is_valid_should_return_false_on_null() throws Exception
    {
        boolean valid = validator.isValid(null);

        assertFalse(valid);
    }
}