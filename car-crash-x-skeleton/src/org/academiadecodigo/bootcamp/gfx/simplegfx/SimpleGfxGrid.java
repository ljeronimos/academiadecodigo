package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class SimpleGfxGrid implements Grid {

    //private int colInPix=10;
    //private int rowInPix=20;
    private int cellSize = 10;
    private int cols;
    private int rows;
    //private int x;
    //private int y;

    public static final int PADDING = 10;

    public SimpleGfxGrid(int cols, int rows){
        //this.x = columnToX(cols);
        //this.y = rowToY(rows);
        this.cols=cols;
        this.rows=rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        Rectangle background = new Rectangle(PADDING,PADDING,columnToX(cols),rowToY(rows));
        background.draw();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return columnToX(cols);
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return rowToY(rows);
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {
        return PADDING;
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return PADDING;
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {
        return cellSize;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        //int xRand = (int)(Math.random()*x);
        //int yRand = (int)(Math.random()*y);

        return new SimpleGfxGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col,row,this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
         return row*cellSize;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return column*cellSize;
    }
}
