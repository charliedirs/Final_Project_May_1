import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Forestry {

    public static void main(String[] args) {
        Forest myForest;
        int argIndex;
        boolean doNext;
//----Welcome message
        System.out.println("Welcome to the Forestry Simulation");
        System.out.println("----------------------------------");
        doNext = true;

        for (argIndex = 0; doNext && argIndex < args.length; argIndex++) {
            doNext = false;
            System.out.println("Initializing from " + args[argIndex]);
            if ((myForest = Forest.readForestFromCSV(args[argIndex])) != null) {
                doNext = menu(myForest);
            }
        }
//----Farewell message
        System.out.println();
        System.out.println("Exiting the Forestry Simulation");

    } // end of main method

    public static boolean menu(Forest myForest) {

        Scanner keyboard = new Scanner(System.in);
        char option;
        while (true) {

            System.out.println("(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : ");
            option = keyboard.next().charAt(0);

            switch (Character.toUpperCase(option)) {

                case 'P': myForest.printTrees(); break;

                case 'A': myForest.addTrees(); break;

                case 'C': myForest.cutTrees(); break;

                case 'G': myForest.growTrees(); break; //almost done, just need to figure out how to get it to forest

                case 'R': myForest.reapTrees(); break;

                case 'S': myForest.saveTrees(); break; //fix so that it can save both acadian and Montane

                //case 'L': myForest.loadTrees(); break;

                case 'N': return true;

                case 'X':
                    System.out.println("Exiting program. Have a great performance!");
                    return true;
                default:
                    System.out.println("ERROR: Invalid option, try again");

            }

        }

    }

}