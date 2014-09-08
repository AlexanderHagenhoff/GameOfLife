package com.peterpunch.gameoflife.controller;

import com.peterpunch.gameoflife.drawer.ConsoleDrawer;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.rulestrategy.Rule23_3;
import com.peterpunch.gameoflife.utils.FieldCreator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

@RunWith(JUnit4.class)
public class GameOfLifeTest
{
    private GameOfLife gameOfLife;

    @Before
    public void setUp() throws Exception
    {
        FieldCreator fieldCreator = new FieldCreator();
        File file = new File(getClass().getResource("/drawing_file_geil.txt").getFile());
        Field field = fieldCreator.create(file);

        gameOfLife = new GameOfLife(field, new Rule23_3(), new ConsoleDrawer());
    }

    @Test
    @Ignore
    public void run() throws Exception
    {
        Thread thread = new Thread(gameOfLife);
        thread.run();
    }
}