# GameOfLife

/*
file name:      README.txt
Authors:        Robbie Bennett
Class:          CS231 Lab
last modified:  9/26/2022
I created Conways Game Of Life with a visualization method. 
*/

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

How to run LifeSimulation.java for the expected outcome of the project.

Make sure to follow the comments in the main method of LifeSimulations, to see what should and should not be commented out.
After following the comments in the main method, type the following into the terminal:

1. javac Question1.java
2. java Question1 int arg1 int arg2 double arg int arg4

arg1 is the int amount of rows for the grid.
arg2 is the int amount of cols for the grid.
arg3 is the double initial chance that the cells are alive. This should be a value between 0 and 1.
arg4 is the int amount of times the game will advance.

The result should be a grid of rows by arg1 and columns arg2 with an probability of arg3 that the cells are alive, that advances by arg4 amount of times.



-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

How to run LifeSimulation.java with my own Rules (extension.)

Make sure to follow the comments in the main method of LifeSimulations, to see what should and should not be commented out.
After following the comments in the main method, type the following into the terminal:

1. javac Question1.java
2. java Question1 int arg1 int arg2 double arg int arg4

    arg1 is the int amount of rows for the grid.
    arg2 is the int amount of cols for the grid.
    arg3 is the double initial chance that the cells are alive. This should be a value between 0 and 1.
    arg4 is the int amount of times the game will advance.

The best result comes from the following values: 

    java LifeSimulation 100 100 .5 1000

The result should be a grid of rows by arg1 and coloumns arg2 with an proability of arg3 that the cells are alive, that advances by arg4 amount of times, based on the rules for the game that Robbie Bennett Created.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


How to run LifeSimulation.java for my experiment (lab report)

If you choose to run the code I used to gather data for my report, to collect code to 
find the sample means of multiple trials, follow the instructions of the comments within the main method.

After following the comments in the main method, type the following into the terminal.

1. javac Question1.java
2. java Question1 int arg1 int arg2 double arg int arg4

arg1 is the amount of rows for the grid.
arg2 is the amount of cols for the grid.
arg3 is the initial chance that the cells are alive. This should be a value between 0 and 1.
arg4 is the amount of times the game will advance.


If there is nothing passed for args, a usage statement will appear.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


How to run LandScapeDisplay.java for the expected outcome of the project.

To run the LandScapeDisplay file, press the run button in the top right corner, or type the following into the terminal:

1.javac LandScapeDisplay.java
2.java LandscapeDisplay


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

How to run LandScapeTests.java for the expected outcome of the project.

To run the LandScapeTests.java file, press the run button in the top right corner, or type the following into the terminal:

1.javac LandScapeTests.java
2.java LandscapeTests
