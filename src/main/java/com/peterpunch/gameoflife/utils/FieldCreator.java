package com.peterpunch.gameoflife.utils;

import com.google.common.collect.Maps;
import com.peterpunch.gameoflife.model.Cell;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Pos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FieldCreator
{
    public Field create(File file) throws IOException
    {
        FieldCreationDto field = getCells(file);

        return new Field(field.height, field.width, field.cells);
    }

    private FieldCreationDto getCells(File file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Map<Pos, Cell> cells = Maps.newHashMap();
        FieldCreationDto dto = new FieldCreationDto();

        int y = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fileCells = line.split("\\s+");

            int x = 0;
            for (String cell : fileCells) {
                if (cell.equals("x")) {
                    cells.put(Pos.p(y, x), new Cell(cell.equals("x")));
                }
                x++;
            }
            if (dto.width < x) {
                dto.width = x;
            }

            y++;
        }

        dto.cells = cells;
        dto.height = y;


        return dto;
    }

    private class FieldCreationDto
    {
        private Map<Pos, Cell> cells;

        private int height = 0;

        private int width = 0;

    }
}
