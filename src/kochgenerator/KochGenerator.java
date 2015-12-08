/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kochgenerator;

import calculate.KochManager;
import java.util.Scanner;

/**
 *
 * @author Rick Rongen, www.R-Ware.tk
 */
public class KochGenerator {

    private static Boolean WAIT_EDGE = false;
    private static int LEVEL = 1;
    
    public static final Boolean getWaitEdge(){
        return WAIT_EDGE;
    }
    
    public static final int getLevel(){
        return LEVEL;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean running = true;
        Scanner s = new Scanner(System.in);
        KochManager km = new KochManager();
        km.setFile("C:\\Users\\rick-\\outFile.edg");
        System.out.println("Command:\n"
                + "quit\t\t - quit program\n"
                + "wait edge \t - toggle wait after edge, default false\n"
                + "level [n]\t - set the generator level to [n]\n"
                + "calculate \t - calculate the edges to the ram file");
        while(running){
            System.out.print(">");
            String input = s.nextLine();
            if(input.equals("quit")){
                running=false;
            }
            if(input.equalsIgnoreCase("wait edge")){
                WAIT_EDGE =! WAIT_EDGE;
                System.out.println("Now " + (WAIT_EDGE?"waiting":"not waiting"));
            }
            if(input.startsWith("level")){
                LEVEL = Integer.valueOf(input.substring(6));
                System.out.println("Level = " + LEVEL);
            }
            if(input.equalsIgnoreCase("calculate")){
                km.changeLevel(LEVEL);
                km.calculateAndSave();
                System.out.println("Took: " + km.getTime());
            }
        }
    }
    
}
