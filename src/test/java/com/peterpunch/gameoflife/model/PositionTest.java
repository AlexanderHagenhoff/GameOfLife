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
        Pos pos = Pos.p(0, 0);

        Pos normalized = pos.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_do_nothing_when_not_0_and_lt_size() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(1, 2);

        Pos normalized = pos.normalize(height, width);

        assertEquals(1, normalized.y);
        assertEquals(2, normalized.x);
    }

    @Test
    public void normalize_should_correct_y() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(3, 0);

        Pos normalized = pos.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_x() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(0, 3);

        Pos normalized = pos.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_y_plus_2() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(4, 0);

        Pos normalized = pos.normalize(height, width);

        assertEquals(1, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_x_plus_2() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(0, 4);

        Pos normalized = pos.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(1, normalized.x);
    }

    @Test
    public void normalize_should_correct_x_minus_1() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(0, -1);

        Pos normalized = pos.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(2, normalized.x);
    }

    @Test
    public void normalize_should_correct_y_minus_1() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(-1, 0);

        Pos normalized = pos.normalize(height, width);

        assertEquals(2, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_y_minus_2() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(-2, 0);

        Pos normalized = pos.normalize(height, width);

        assertEquals(1, normalized.y);
        assertEquals(0, normalized.x);
    }

    @Test
    public void normalize_should_correct_x_minus_2() throws Exception
    {
        int width = 3;
        int height = 3;
        Pos pos = Pos.p(0, -2);

        Pos normalized = pos.normalize(height, width);

        assertEquals(0, normalized.y);
        assertEquals(1, normalized.x);
    }

    @Test
    public void equals_should_return_true() throws Exception
    {
        Pos pos = Pos.p(1, 1);

        assertTrue(pos.equals(Pos.p(1, 1)));
    }

    @Test
    public void equals_should_return_true_on_same_object() throws Exception
    {
        Pos pos = Pos.p(1, 1);

        assertTrue(pos.equals(pos));
    }

    @Test
    public void equals_should_return_false() throws Exception
    {
        Pos pos = Pos.p(1, 1);

        assertFalse(pos.equals(Pos.p(1, 2)));
    }
}