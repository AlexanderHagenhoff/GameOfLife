package com.peterpunch.gameoflife.utils;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class NeighbourhoodUtilTest
{
    private NeighbourhoodUtil util;

    @Before
    public void setUp() throws Exception
    {
        util = new NeighbourhoodUtil();
    }

    @Test
    public void getAmountOfLivindNeighbours_should_return_8() throws Exception
    {
        File file = new File(getClass().getResource("/10x10_alive.txt").getFile());
        Field field = new FieldCreator().create(file);

        int amount = util.getAmountOfLivingNeighbours(field, Pos.p(4, 4));

        assertEquals(8, amount);
    }

    @Test
    public void getAmountOfLivindNeighbours_should_return_8_on_edge() throws Exception
    {
        File file = new File(getClass().getResource("/10x10_alive.txt").getFile());
        Field field = new FieldCreator().create(file);

        int amount = util.getAmountOfLivingNeighbours(field, Pos.p(0, 0));

        assertEquals(8, amount);
    }

    @Test
    public void getAmountOfLivindNeighbours_should_return_2() throws Exception
    {
        File file = new File(getClass().getResource("/3x3_001.txt").getFile());
        Field field = new FieldCreator().create(file);

        int amount = util.getAmountOfLivingNeighbours(field, Pos.p(1, 1));

        assertEquals(2, amount);
    }

    @Test
    public void get_neighbourhood_positions_should_return_correct_positions() throws Exception
    {
        final List<Pos> positions = util.getNeighbourhoodPositions(Pos.p(1, 1));

        assertEquals(8, positions.size());
    }
}
