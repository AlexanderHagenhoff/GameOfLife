package com.peterpunch.gameoflife.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PositionTest
{
    @Test
    public void normalize_should_do_nothing() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(0, 0);

        Position normalized = position.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_do_nothing_when_not_0_and_lt_size() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(1, 2);

        Position normalized = position.normalize(height, width);

        assertEquals(1, normalized.y);
        assertEquals(2, normalized.x);
    }

    @Test
    public void normalize_should_correct_y() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(3, 0);

        Position normalized = position.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_x() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(0, 3);

        Position normalized = position.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_y_plus_2() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(4, 0);

        Position normalized = position.normalize(height, width);

        assertEquals(1, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_x_plus_2() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(0, 4);

        Position normalized = position.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(1, normalized.x);
    }

    @Test
    public void normalize_should_correct_x_minus_1() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(0, -1);

        Position normalized = position.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(2, normalized.x);
    }

    @Test
    public void normalize_should_correct_y_minus_1() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(-1, 0);

        Position normalized = position.normalize(height, width);

        assertEquals(2, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_y_minus_2() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(-2, 0);

        Position normalized = position.normalize(height, width);

        assertEquals(1, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_x_minus_2() throws Exception
    {
        int width = 3;
        int height = 3;
        Position position = new Position(0, -2);

        Position normalized = position.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(1, normalized.x);
    }
}