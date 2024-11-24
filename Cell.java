/*
file name:      Cell.java
Authors:        Robbie Bennett
Class:          CS231 Lab
last modified:  10/1/2024
How to run:     1. javac Cell.java     2. java Cell (Should not return anything.)
*/

import java.util.ArrayList;

public class Cell {
    //Creates the cells for Conway's game of life.
   
    private boolean cell;

    public Cell() {
    //Default constructor.

    this.cell = true;
    }

    public Cell(boolean status) {
        //Constructor that sets the initial status of the cell, initially Alive.

        this.cell = status;
    }

    public boolean getAlive() {
        ///Accessor method that returns whether the cell is currently alive.

        return this.cell;
    }

    public void setAlive(boolean status) {
        //Mutator method that sets the current status of the cell to the specified status in the parameter.

        this.cell = status;
    }

    public void updateState(ArrayList<Cell> neighbors) {
        //Updates the state of the cell depending on whether it is alive or dead according to the rules of Conway's Game Of Life.

        int aliveNeighbors = 0;

        // Count alive neighbors
        for (Cell cell : neighbors) {
            if (cell.getAlive()) {
                aliveNeighbors++;
            }
        }
    
        //Updating the state of the cell based on the rules of Conway's Game Of Life.
        if (this.cell) { // If the cell is currently alive
            if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                this.cell = false; // Cell dies
            }
        } else { // If the cell is currently dead
            if (aliveNeighbors == 3) {
                this.cell = true; // Cell becomes alive
            }
        }
    }

    public void updateStateExtension(ArrayList<Cell> neighbors) {
        //Updates the state of the cell depending on whether it is alive or dead according to my own rules of the game.

        int aliveNeighbors = 0;

        // Count alive neighbors
        for (Cell cell : neighbors) {
            if (cell.getAlive()) {
                aliveNeighbors++;
            }
        }
    
        //Updating the state of the cell based on the rules of Conway's Game Of Life.
        if (this.cell) { // If the cell is currently alive
            if (aliveNeighbors > 5 || aliveNeighbors == 2 || aliveNeighbors == 4) {
                this.cell = false; // Cell dies
            }
        } else { // If the cell is currently dead
            if (aliveNeighbors == 3 || aliveNeighbors == 1) {
                this.cell = true; // Cell becomes alive
            }
        }
    }
    
    public String toString() {
        //Returns a String Repersentation of the cell value.

        return Boolean.toString(this.cell);
    }
}