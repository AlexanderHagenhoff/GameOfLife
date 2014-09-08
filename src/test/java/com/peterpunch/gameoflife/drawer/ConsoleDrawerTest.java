package com.peterpunch.gameoflife.drawer;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.utils.FieldCreator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

@RunWith(JUnit4.class)
public class ConsoleDrawerTest
{
    private ConsoleDrawer drawer;

    private FieldCreator fieldCreator;

    @Before
    public void setUp() throws Exception
    {
        fieldCreator = new FieldCreator();
        drawer = new ConsoleDrawer();
    }

    @Test
    public void draw_field() throws Exception
    {
        File file = new File(getClass().getResource("/drawing_file_static.txt").getFile());
        Field field = fieldCreator.create(file);

        drawer.drawField(field);
    }
}