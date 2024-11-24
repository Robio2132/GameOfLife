/*
file name:      Landscape.java
Authors:        Robbie Bennett
Class:          CS231 Lab
last modified:  9/26/2022
How to run:     1. javac Landscape.java     2. java Landscape  (Should return nothing.)
*/

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Landscape {
    //Creates the Landscape comprised of Cell objects for Conway's Game Of Life.

    private Cell[][] landscape;
    private double initialChance;

    public Landscape(int rows, int columns) {
        //Constructs a grid with specified amounts rows and columns.

        this.landscape = new Cell[rows][columns];
        reset();
    }

    public Landscape(int rows, int columns, double chance) {
        //Cronstructs a grid with specified amounts rows and columns and takes in a double chance value that sets the initial chance of the cell.

        this.landscape = new Cell[rows][columns];
        this.initialChance = chance;
        reset();
    }

    public Landscape(boolean[][] grid){
        //initializes the Cells using the given grid. Namely, the Cell at a given coordinate 
        //should be initialized as alive if the corresponding entry in the given grid is set to true.
        
        int row = grid.length;
        int col = grid[0].length;

        landscape = new Cell[row][col];
        reset();
    }

    public void reset() {
        //Recreates the landscape according to the specifications given in the contructor.

        Random ran = new Random();

        for (int row= 0; row < getRows(); row++){
            for (int col = 0; col< getCols(); col++){

                this.landscape[row][col] = new Cell();

                if((double)this.initialChance > ran.nextDouble()){
                    //Alive
                    this.landscape[row][col].setAlive(true);

                } else {
                    //Dead.
                    this.landscape[row][col].setAlive(false);
                }
            }
        }
    }

    public int getRows() {
        //Accessor method that returns the amount of rows in the landscape grid.

        return landscape.length;
    }

    public int getCols() {
        //Accessor method that returns the amount of coloumns in the landscape grid.

        return landscape[0].length;
    }

    public Cell getCell(int row, int col) {
        //Returns the Cell specified at a given row and column in the landscape grid.

        return landscape[row][col];
    }

    public String toString() {
        //Returns a String representation of the Landscape.

        String tempString = "";

        for ( int i = 0; i<getRows(); i++){
            for (int j = 0; j<getCols(); j++){
                tempString += this.landscape[i][j];
            }

        tempString += "\n";
        }

    return tempString;
    }

    public ArrayList<Cell> getNeighbors(int row, int col) {
        //Creates an ArrayList of cell neighbors around a given cell at row and col.

        ArrayList <Cell> neighborCells = new ArrayList<Cell>();
        
        Cell cell = this.landscape[row][col];

        for ( int i = -1; i<2; i++){
            for (int j = -1; j<2; j++){
                if (row + i >= 0 && row + i< landscape.length && col + j >= 0 && col + j< landscape[0].length){ //Checking the neighbor logic.
                    if(landscape[row + i][col + j] != cell){
                        neighborCells.add(landscape[row+ i][col + j]);
                    }
                }
            }
        }
    return neighborCells;
    }

    public void advance() {
        //Advances the cell objects within the grid.

        Cell[][] tempGrid = new Cell[getRows()][getCols()];
        
        for (int row=0; row<this.landscape.length; row++){
            for (int col = 0; col<this.landscape[0].length; col++){
                tempGrid[row][col] = new Cell(this.getCell(row,col).getAlive());
                tempGrid[row][col].updateState(getNeighbors(row, col));
            }
        }

    landscape = tempGrid;
    }

    public void advanceExtension() {
        //Advances the cell objects within the grid based on my own rules.

        Cell[][] tempGrid = new Cell[getRows()][getCols()];
        
        for (int row=0; row<this.landscape.length; row++){
            for (int col = 0; col<this.landscape[0].length; col++){
                tempGrid[row][col] = new Cell(this.getCell(row,col).getAlive());
                tempGrid[row][col].updateStateExtension(getNeighbors(row, col));
            }
        }

    landscape = tempGrid;
    }


    public void draw(Graphics g, int scale) {
        //Visualizes the cells on the landscape grid as black (Alive objects) or gray (Dead Objects)

        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public int getAliveCount(){
        //Counts how many cells are Alive at the end of the game.

        int count = 0;
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                if (this.landscape[row][col].getAlive() == true){
                    count ++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
    }
}

