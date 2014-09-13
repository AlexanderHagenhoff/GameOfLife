package com.peterpunch.gameoflife.rulestrategy;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;
import com.peterpunch.gameoflife.utils.FieldCreator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Rule23_3Test
{
    private Rule23_3 rule;

    private FieldCreator fieldCreator;

    @Before
    public void setUp() throws Exception
    {
        rule = new Rule23_3();
        fieldCreator = new FieldCreator();
    }

    @Test
    public void apply_one_dead_cell_with_no_neighbours_should_stay_dead() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_dead.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void apply_rule_1() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_1.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertTrue(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void apply_rule_2() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_2.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void apply_rule_3() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_3.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertTrue(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void apply_rule_4() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_4.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }
}