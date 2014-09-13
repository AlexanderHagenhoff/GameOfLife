package com.peterpunch.gameoflife.utils;

import com.peterpunch.gameoflife.model.Cell;
import com.peterpunch.gameoflife.model.Field;
import com.peterpunch.gameoflife.model.Position;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Map<Position, Cell> cells = new HashMap<Position, Cell>();
        FieldCreationDto dto = new FieldCreationDto();

        int y = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fileCells = line.split("\\s+");

            int x = 0;
            for (String cell : fileCells) {
                if (cell.equals("x")) {
                    cells.put(new Position(y, x), new Cell(cell.equals("x")));
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
        private Map<Position, Cell> cells;

        private int height = 0;

        private int width = 0;

    }
}
