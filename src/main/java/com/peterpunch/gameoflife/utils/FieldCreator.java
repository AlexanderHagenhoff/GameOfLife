package com.peterpunch.gameoflife.utils;

import com.peterpunch.gameoflife.model.Cell;
import com.peterpunch.gameoflife.model.Field;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FieldCreator
{
    public Field create(File file) throws IOException
    {
        Cell[][] cells = getCells(file);

        return new Field(cells);
    }

    private Cell[][] getCells(File file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Cell[]> cells = new ArrayList<Cell[]>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fileCells = line.split("\\s+");
            List<Cell> lineOfCells = new ArrayList<Cell>(fileCells.length);

            for (String cell : fileCells) {
                lineOfCells.add(new Cell(cell.equals("x")));
            }

            cells.add(lineOfCells.toArray(new Cell[lineOfCells.size()]));
        }

        return cells.toArray(new Cell[cells.size()][]);
    }
}
