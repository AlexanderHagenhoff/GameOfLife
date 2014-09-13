package com.peterpunch.gameoflife.controller;

import com.peterpunch.gameoflife.drawer.Drawer;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;
import com.peterpunch.gameoflife.rulestrategy.Rule;
import com.peterpunch.gameoflife.utils.NeighbourhoodUtil;

public class GameOfLife implements Runnable
{
    private final Field field;

    private final Rule rule;

    private final Drawer drawer;

    private final NeighbourhoodUtil util;

    private boolean run = true;

    public GameOfLife(Field field, Rule rule, Drawer drawer)
    {
        this.field = field;
        this.rule = rule;
        this.drawer = drawer;

        util = new NeighbourhoodUtil();
    }

    @Override
    public void run()
    {
        while (run) {

            try {
                drawer.drawField(field);

                Thread.sleep(150);

                for (Pos pos : field.getLivingPositions()) {
                    rule.apply(field, pos);
                    for (Pos neighbour : util.getNeighbourhoodPositions(pos)) {
                        rule.apply(field, neighbour);
                    }
                }

                field.commit();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
