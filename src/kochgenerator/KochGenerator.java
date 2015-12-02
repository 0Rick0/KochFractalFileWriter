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

    private static Boolean WAIT_EDGE = true;
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
        while(running){
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
