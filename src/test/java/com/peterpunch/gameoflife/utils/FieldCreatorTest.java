package com.peterpunch.gameoflife.utils;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FieldCreatorTest
{
    private FieldCreator fieldCreator;

    private File five001;

    private File fiveSix001;

    @Before
    public void setUp() throws Exception
    {
        this.fieldCreator = new FieldCreator();
        five001 = new File(getClass().getResource("/5x5.txt").getFile());
        fiveSix001 = new File(getClass().getResource("/5x6.txt").getFile());
    }

    @Test
    public void create_should_create_non_null_field_from_file() throws Exception
    {
        Field field = fieldCreator.create(five001);

        assertNotNull(field);
    }

    @Test
    public void create_should_create_correct_dimension_from_file() throws Exception
    {
        Field field = fieldCreator.create(five001);

        assertEquals(5, field.getHeight());
        assertEquals(5, field.getWidth());
    }

    @Test
    public void create_should_create_correct_dimension_from_file_5_6() throws Exception
    {
        Field field = fieldCreator.create(fiveSix001);

        assertEquals(5, field.getHeight());
        assertEquals(6, field.getWidth());
    }

    @Test
    public void create_should_create_correct_cells_from_file_5_5() throws Exception
    {
        Field field = fieldCreator.create(five001);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boolean cell = field.isAlive(Pos.p(i, j));

                if (j != 1) {
                    assertFalse(cell);
                } else {
                    assertTrue(cell);
                }
            }
        }
    }

    @Test
    public void create_should_create_correct_cells_from_file_5_6() throws Exception
    {
        Field field = fieldCreator.create(fiveSix001);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boolean cell = field.isAlive(Pos.p(i, j));

                if (j != 1 && j != 6) {
                    assertFalse(cell);
                } else {
                    assertTrue(cell);
                }
            }
        }
    }
}