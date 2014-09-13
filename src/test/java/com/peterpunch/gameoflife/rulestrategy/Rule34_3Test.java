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
public class Rule34_3Test
{
    private Rule34_3 rule;

    private FieldCreator fieldCreator;

    @Before
    public void setUp() throws Exception
    {
        rule = new Rule34_3();
        fieldCreator = new FieldCreator();
    }

    @Test
    public void test_rule_1() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_dead_and_3.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertTrue(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void test_rule_2() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_dead_and_1.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void test_rule_3() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_alive_and_2.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void test_rule_4() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_alive_and_3.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertTrue(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void test_rule_5() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_alive_and_4.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertTrue(field.isAlive(Pos.p(1, 1)));
    }

    @Test
    public void test_rule_6() throws Exception
    {
        Field field = fieldCreator.create(new File(getClass().getResource("/3x3_rule_alive_and_2.txt").getFile()));

        field = rule.apply(field, Pos.p(1, 1));
        field.commit();

        assertFalse(field.isAlive(Pos.p(1, 1)));
    }
}
