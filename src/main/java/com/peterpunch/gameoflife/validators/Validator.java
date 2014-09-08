package com.peterpunch.gameoflife.validators;

public interface Validator<T>
{
    public boolean isValid(T validation);
}
