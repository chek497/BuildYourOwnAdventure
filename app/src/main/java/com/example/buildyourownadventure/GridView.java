package com.example.buildyourownadventure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;


public class GridView extends View {
    private enum Direction{
        UP, DOWN, LEFT, RIGHT
    }
    private Cell[][] cells;
    private Cell player;

    private static final int COLS = 7, ROWS = 10;
    private static final float WALL_THICKNESS = 4;
    private float cellSize, hMargin, vMargin;
    private Paint borderPaint, playerPaint;

    public GridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        borderPaint = new Paint();
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStrokeWidth(WALL_THICKNESS);

        playerPaint = new Paint();
        playerPaint.setColor(Color.RED);

        createGrid();
    }
    private void createGrid(){
        cells = new Cell[COLS][ROWS];

        for(int x = 0; x<COLS; x++){
            for(int y = 0; y<ROWS; y++){
                cells[x][y] = new Cell(x,y);
            }
        }

            player = cells[0][0];


    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        int width = getWidth();
        int height = getHeight();

        if(width/height < COLS/ROWS){
            cellSize = width/(COLS + 1);
        }else{
            cellSize = height/(ROWS + 1);
        }
        hMargin = (width-COLS*cellSize)/2;
        vMargin = (height-ROWS*cellSize);

        canvas.translate(hMargin, vMargin);

        for(int x = 0; x<COLS; x++){
            for(int y = 0; y<ROWS; y++){
                if(cells[x][y].topWall){
                    canvas.drawLine(
                            x*cellSize,
                            y*cellSize,
                            (x+1)*cellSize,
                            y*cellSize,
                            borderPaint);
                }
                if(cells[x][y].leftWall){
                    canvas.drawLine(
                            x*cellSize,
                            y*cellSize,
                            x*cellSize,
                            (y+1)*cellSize,
                            borderPaint);
                }
                if(cells[x][y].bottomWall){
                    canvas.drawLine(
                            x*cellSize,
                            (y+1)*cellSize,
                            (x+1)*cellSize,
                            (y+1)*cellSize,
                            borderPaint);
                }
                if(cells[x][y].rightWall){
                    canvas.drawLine(
                            (x+1)*cellSize,
                            y*cellSize,
                            (x+1)*cellSize,
                            (y+1)*cellSize,
                            borderPaint);
                }
            }
        }
        float margin = cellSize/10;

        canvas.drawRect(
                player.col * cellSize + margin,
                player.row * cellSize + margin,
                (player.col + 1) * cellSize - margin,
                (player.row + 1) * cellSize - margin,
                playerPaint
        );

    }
    private void movePlayer(Direction direction){
        switch (direction){
            case UP:
                if (player.row != 0) {
                    player = cells[player.col][player.row - 1];
                }

                break;
            case DOWN:
                if (player.row != ROWS - 1) {
                    player = cells[player.col][player.row + 1];
                }

                break;
            case LEFT:
                if(player.col != 0) {
                    player = cells[player.col - 1][player.row];
                }
                break;
            case RIGHT:
                player = cells[player.col+1][player.row];
                break;

        }
        invalidate();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            return true;
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            float x = event.getX();
            float y = event.getY();


            float playerCenterX = hMargin + (player.col + 0.5f) * cellSize;
            float playerCenterY = vMargin + (player.row + 0.5f) * cellSize;


            float dx = x - playerCenterX;
            float dy = y - playerCenterY;

            float absDx = Math.abs(dx);
            float absDy = Math.abs(dy);


            if (absDx > cellSize || absDy > cellSize) {
                if (absDx > absDy) {
                    //move in x direction

                    if (dx > 0) {
                        movePlayer(Direction.RIGHT);
                    } else {
                        movePlayer(Direction.LEFT);
                    }
                } else {
                    //move in y direction
                    if (dy > 0) {
                        movePlayer(Direction.DOWN);
                    } else {
                        movePlayer(Direction.UP);
                    }
                }

            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    private class Cell{
        boolean
            topWall = true,
            leftWall = true,
            bottomWall = true,
            rightWall = true;
        int col, row;

        public Cell(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
}
