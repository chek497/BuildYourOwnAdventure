package com.example.buildyourownadventure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;


public class GridView extends View {
    private enum Direction{
        UP, DOWN, LEFT, RIGHT
    }
    private Cell[][] cells;
    private Cell[] players;

    private static final int COLS = 7, ROWS = 10, PLAYER_COUNT = 5;
    private static final float WALL_THICKNESS = 4;
    private float cellSize;
    private float hMargin;
    private float vMargin;
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
                cells[x][y] = new Cell(x, y);
            }
        }


            players = new Cell[PLAYER_COUNT];
            for(int i=0;i<players.length;i++){
                players[i] = cells[i][0];
            }

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
                canvas.drawLine(
                        x*cellSize,
                        y*cellSize,
                        (x+1)*cellSize,
                        y*cellSize,
                        borderPaint);
                canvas.drawLine(
                        x*cellSize,
                        y*cellSize,
                        x*cellSize,
                        (y+1)*cellSize,
                        borderPaint);
            
                canvas.drawLine(
                        x*cellSize,
                        (y+1)*cellSize,
                        (x+1)*cellSize,
                        (y+1)*cellSize,
                        borderPaint);
            
                canvas.drawLine(
                        (x+1)*cellSize,
                        y*cellSize,
                        (x+1)*cellSize,
                        (y+1)*cellSize,
                        borderPaint);
                
            }
        }
        float margin = cellSize/10;
        for(Cell player:players){
            canvas.drawRect(
                    player.col * cellSize + margin,
                    player.row * cellSize + margin,
                    (player.col + 1) * cellSize - margin,
                    (player.row + 1) * cellSize - margin,
                    playerPaint
            );
        }

    }
    private void movePlayer(Direction direction, int i){
        switch (direction){
            case UP:
                if (players[i].row != 0) {
                    players[i] = cells[players[i].col][players[i].row - 1];
                }
                break;
            case DOWN:
                if (players[i].row != ROWS - 1) {
                    players[i] = cells[players[i].col][players[i].row + 1];

                }
                break;
            case LEFT:
                if(players[i].col != 0) {
                    players[i] = cells[players[i].col - 1][players[i].row];
                }
                break;
            case RIGHT:
                players[i] = cells[players[i].col+1][players[i].row];
                break;

        }
        invalidate();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x, y, dx, dy, absDx,absDy,playerCenterX,playerCenterY;
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:

                for (Cell player : players) {
                    x = event.getX();
                    y = event.getY();


                    playerCenterX = hMargin + (player.col + 0.5f) * cellSize;
                    playerCenterY = vMargin + (player.row + 0.5f) * cellSize;

                    dx = x - playerCenterX;
                    dy = y - playerCenterY;
                    absDx = Math.abs(dx);
                    absDy = Math.abs(dy);
                    if (player.isTouched(absDx, absDy)) {
                        player.setActionDown(true);
                    }

                }
                break;
            case MotionEvent.ACTION_MOVE:
                for(int i = 0; i<players.length; i++) {
                    if (players[i].getActionDown()) {
                        x = event.getX();
                        y = event.getY();

                        playerCenterX = hMargin + (players[i].col + 0.5f) * cellSize;
                        playerCenterY = vMargin + (players[i].row + 0.5f) * cellSize;

                        dx = x - playerCenterX;
                        dy = y - playerCenterY;

                        absDx = Math.abs(dx);
                        absDy = Math.abs(dy);

                        if (absDx > cellSize || absDy > cellSize) {
                            if (absDx > absDy) {
                                //move in x direction
                                if (dx > 0) {
                                    movePlayer(Direction.RIGHT, i);

                                } else {
                                    movePlayer(Direction.LEFT, i);

                                }
                            } else {
                                //move in y direction
                                if (dy > 0) {
                                    movePlayer(Direction.DOWN, i);

                                } else {
                                    movePlayer(Direction.UP, i);

                                }
                            }

                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                for(Cell player:players) {
                    player.setActionDown(false);
                }
                break;
        }
        return true;

    }

    private static class Cell{
        boolean actionDown = false;
        int col, row;

        public Cell(int col, int row) {
            this.col = col;
            this.row = row;
        }
        public boolean getActionDown(){
            return actionDown;
        }
        public void setActionDown(boolean actionDown){
            this.actionDown = actionDown;
        }

        public boolean isTouched(float x, float y) {
            return x <= 50 && y <= 50;
        }
    }
}
