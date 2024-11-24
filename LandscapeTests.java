/*
file name:      LandscapeTests.java
Authors:        Max Bender, Naser Al Madi, and Robbie bennett
last modified:  9/18/2022
How to run:     1. javac LandscapeTests.java     2. java LandscapeTests  (Should return the results and outcome of the tests.)
*/

public class LandscapeTests {
    //Tests each method of the landscape class.

    public static void landscapeTests() {
        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";


        }

        // case 2: testing reset()

        {
            // set up

            Landscape l1 = new Landscape(5, 5, 0.5); // Example: 5x5 grid, 50% chance of alive cells.
            Landscape l2 = new Landscape(5, 5, 0); // Example: 5x5 grid, 50% chance of alive cells.
            Landscape l3 = new Landscape(5, 5, 1); // Example: 5x5 grid, 50% chance of alive cells.

            // verify

            /// The .05 Chance.
            System.out.println("Landscape l1 before reset:" + l1 + "   Success!");
            System.out.println();
            l1.reset();
            System.out.println("Landscape l1 after the reset:" + l1 + "   Success!");
            System.out.println("\n");

            //The 0 chance.
            System.out.println("Landscape l2 before reset:" + l2 + "   Success!");
            System.out.println();
            l2.reset();
            System.out.println("Landscape l2 after the reset:" + l2 + "   Success!");
            System.out.println("\n");

            //The 1 chance.
            System.out.println("Landscape l3 before reset:" + l3 + "   Success!");
            System.out.println();
            l3.reset();
            System.out.println("Landscape l3 after the reset:" + l3 + "   Success!");
            System.out.println("\n");

            //test
            assert l1 != null : "Error in Landscape reset l1::Landscape.reset()";
            assert l2 != null : "Error in Landscape reset l2::Landscape.reset()";
            assert l3 != null : "Error in Landscape reset l3::Landscape.reset()";
        }

        // case 3: testing getRows()

        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify
            System.out.println("Amount of Rows for l1 grid:  " +  l1.getRows()   + "   and the expected is  2");
            System.out.println("Amount of Rows for l2 grid:  " + l2.getRows()  + "   Expected is  10");
            System.out.println("\n");

            // test
            assert l1.getRows() != 2 : "Error in Landscape getRows l1::Landscape.getRows()";
            assert l1.getRows() != 10 : "Error in Landscape getRows l2::Landscape.getRows()";
        }

        // case 4: testing getCols()

        {
            // set up
            Landscape l1 = new Landscape(5, 5);
            Landscape l2 = new Landscape(3, 18);

            // verify
            System.out.println("Amount of Cols for l1 grid:  " + l1.getCols() + "   Expected is  5");
            System.out.println("Amount of Cols for l2 grid:  " + l2.getCols()  + "   Expected is  18");
            System.out.println("\n");

            // test
            assert l1.getCols() != 5 : "Error in Landscape getRows l1::Landscape.getRows()";
            assert l2.getCols() != 18 : "Error in Landscape getRows l2::Landscape.getRows()";
        }

        // case 5: testing getCell(int, int)

        {
            // set up
            Landscape l9 = new Landscape(10, 10, .25);

            // verify
            l9.reset();
            System.out.println("Landscape l9 after the reset for test getCell is   :" + l9);
            System.out.println("\n");

            //test
            assert l9.getCell(5, 5) != null  : "Error in Landscape getCell l1::Landscape.getCell()";
        }

        // case 6: testing getNeighbors()

        {
            // set up
            Landscape l10 = new Landscape(10, 10, .5);

            // verify
            l10.reset();
            System.out.println("Landscape l10 with rows 10 and Coloumns 10 after the reset for test getNeighbors is:  " + l10);
            System.out.println("\n");
            System.out.print("Neighbors of Landscape l10 with rows 10 and Coloumns 10 at cell (5,5 ) are:  " + l10.getNeighbors(5,5));

            System.out.println("The neighbors at row 0 and column 0 (The top Left Corner) is:     " +  l10.getNeighbors(0, 0));
            System.out.println("Success!");
            System.out.println("\n");

            System.out.println("The neghbors at row 10 and column 0 (The top Right Corner) is:     " +  l10.getNeighbors(l10.getRows()-1, 0));
            System.out.println("Success!");
            System.out.println("\n");

            System.out.println("The neighbors at row 0 and column 10 (The bottom left Corner) is:     " +  l10.getNeighbors(0, l10.getCols()-1));
            System.out.println("Success!");
            System.out.println("\n");

            System.out.println("The neighbors at row 10 and column 10 (The bottom Right Corner) is:     " +  l10.getNeighbors(l10.getRows()-1, l10.getCols()-1));
            System.out.println("Success!");
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\n");


            // test
            assert l10.getNeighbors(5, 5) != null : "Error in getCell: getCells(int, int)";

        }

        // case 7: testing advance()

        {
            //set up
            Landscape l1 = new Landscape(5, 5, .5);

            //verify
            System.out.println();
            System.out.println("Landscape l1 after the reset and before the advancemethod is:  " + l1);
            System.out.println("\n");
            Landscape temLandscape = l1;

            for(int i=0; i< 2; i++){ //Advances the game twice to verify that the cells updated.
                l1.advance();
            }

            System.out.println("Landscape l1 afer the reset and advance method is:  " + l1);
            System.out.println("Success!");
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\n");

            //test
            assert l1 != temLandscape : "Error in getCell: getCells(int, int)";
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Testing was successful!!!!");
        }
    }
    public static void main(String[] args) {
    
        landscapeTests();
        //Scroll up in the terminal after you run the file to check your results.
    }
}


