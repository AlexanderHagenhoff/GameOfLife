package com.peterpunch.gameoflife.controller;

import com.peterpunch.gameoflife.drawer.Drawer;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;
import com.peterpunch.gameoflife.rulestrategy.Rule;

public class GameOfLife implements Runnable
{
    private final Field field;

    private final Rule rule;

    private final Drawer drawer;

    private boolean run = true;

    public GameOfLife(Field field, Rule rule, Drawer drawer)
    {
        this.field = field;
        this.rule = rule;
        this.drawer = drawer;
    }

    @Override
    public void run()
    {
        while (run) {

            try {
                drawer.drawField(field);

                Thread.sleep(150);

                for (int i = 0; i < field.getHeight(); i++) {
                    for (int j = 0; j < field.getWidth(); j++) {
                        rule.apply(field, Pos.p(i, j));
                    }
                }

                field.commit();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
