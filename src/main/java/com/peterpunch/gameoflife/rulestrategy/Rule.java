package com.peterpunch.gameoflife.rulestrategy;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;

public interface Rule
{
    public Field apply(Field field, Pos pos);
}
