package com.peterpunch.gameoflife.rulestrategy;

import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Position;

public interface Rule
{
    public Field apply(Field field, Position position);
}
