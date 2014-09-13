package com.peterpunch.gameoflife.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

import java.util.Map;

public class Field
{
    private int height;

    private int width;

    private Map<Pos, Cell> cells;

    private Maps.EntryTransformer<Pos, Cell, Cell> commitTransfomer;

    private Predicate<Map.Entry<Pos, Cell>> isCellAlivePredicate;

    public Field(int height, int width, Map<Pos, Cell> cells)
    {
        this.height = height;
        this.width = width;
        this.cells = cells;

        commitTransfomer = new CommitTransformer();
        isCellAlivePredicate = new IsAlivePredicate();
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public boolean isAlive(Pos pos)
    {
        Cell cell = getCell(pos);

        return cell != null && cell.isAlive();
    }

    public void revive(Pos pos)
    {
        Cell cell = getCell(pos);

        if (cell == null) {
            Pos normalized = pos.normalize(getHeight(), getWidth());
            cell = new Cell(false);
            cells.put(normalized, cell);
        }

        cell.revive();
    }

    public void kill(Pos pos)
    {
        Cell cell = getCell(pos);

        if (cell == null) {
            return;
        }

        cell.kill();
    }

    public void commit()
    {
        Map<Pos, Cell> tmp = Maps.transformEntries(cells, commitTransfomer);
        cells = Maps.newHashMap(Maps.filterEntries(tmp, isCellAlivePredicate));
    }


    private Cell getCell(Pos pos)
    {
        Pos normalized = pos.normalize(getHeight(), getWidth());

        return cells.get(normalized);
    }

    private class CommitTransformer implements Maps.EntryTransformer<Pos, Cell, Cell>
    {
        @Override
        public Cell transformEntry(Pos key, Cell cell)
        {
            cell.commit();

            return cell;
        }
    }

    private class IsAlivePredicate implements Predicate<Map.Entry<Pos, Cell>>
    {
        @Override
        public boolean apply(Map.Entry<Pos, Cell> input)
        {
            return input.getValue().isAlive();
        }
    }
}
