package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.car.CarType;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getWidth() ), (int) (Math.random() * grid.getHeight() ), grid);

        simpleGfxGrid=grid;
        rectangle = new Rectangle(getCol(),getRow(),10,10);
        //rectangle.setColor(SimpleGfxColorMapper.getColor(this.getColor()));

        System.out.println("X: "+this.getCol()+" Y: "+this.getRow());
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);

        rectangle = new Rectangle(getCol(),getRow(),10,10);
        //rectangle.setColor(SimpleGfxColorMapper.getColor(this.getColor()));
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {

        rectangle.fill();
        //rectangle.draw();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        super.moveInDirection(direction,distance);
        switch (direction){
            case UP:
                rectangle.translate(0, -distance*simpleGfxGrid.getCellSize());
                break;
            case DOWN:
                rectangle.translate(0,distance*simpleGfxGrid.getCellSize());
                break;
            case LEFT:
                rectangle.translate(-distance*simpleGfxGrid.getCellSize(),0);
                break;
            case RIGHT:
                rectangle.translate(distance*simpleGfxGrid.getCellSize(),0);
                break;
        }


    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(this.getColor()));
    }
}
