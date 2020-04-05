// Author Name: David Munoz
// Date: 1/9/2020
// Program Name: Munoz_Drone
// Purpose: Simulation using button, drone movement in x, y,z location

package munoz_drone;

import java.util.Scanner;

public class Munoz_Drone {

    static int x = 0;
    static int y = 0;
    static int z = 0;
    static int orientation = 0; // north is 0, east is 1, south is 2 and west is 3
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int a = 0;
        do{
            System.out.println("Which direction would you like to move the drone?");
            System.out.println("1 - Move Up");
            System.out.println("2 - Move Down");
            System.out.println("3 - Move Forward");
            System.out.println("4 - Move Backward");
            System.out.println("5 - Turn Left");
            System.out.println("6 - Turn Right");
            System.out.println("7 - Display Position");
            System.out.println("8 - Exit Navigation");

           a = scanner.nextInt();

           switch(a){
               case 1:
                   moveUp();
                   break;
               case 2:
                   moveDown();
                   break;
               case 3:
                   moveForward();
                   break;
               case 4:
                   moveBackward();
                   break;
               case 5:
                   turnLeft();
                   break;
               case 6:
                   turnRight();
                   break;
               case 7:
                   displayPosition();
                   break;
               case 8:
                   exitNav();
                   break;
           }
       } while(a != 8);
    }
    
    private static void moveUp(){
        z++;
        System.out.println("You have moved up.");
    }
    
    private static void moveDown(){
        z--;
        System.out.println("You have moved down.");
    }
    
    private static void moveForward(){
        switch (orientation) {
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                x--;
                break;
            default:
                y++;
                break;
        }
        System.out.println("You have moved forward.");
    }
    
    private static void moveBackward(){
        switch (orientation) {
            case 1:
                x--;
                break;
            case 2:
                y++;
                break;
            case 3:
                x++;
                break;
            default:
                y--;
                break;
        }
        System.out.println("You have moved backward.");
    }
    
    private static void turnLeft(){
        if(orientation == 0)
            orientation = 3;
        else
            orientation--;
        System.out.println("You have turned left.");
    }
    
    private static void turnRight(){
        if(orientation == 3)
            orientation = 0;
        else
            orientation++;
        System.out.println("You have turned right.");
    }
    
    private static void displayPosition(){
        
        String orientate = "";
        
        switch(orientation){
            case 0:
                orientate = "North";
                break;
            case 1:
                orientate = "East";
                break;
            case 2:
                orientate = "South";
                break;
            case 3:
                orientate = "West";
                break;
        }
        System.out.println("Munoz_Drone [x_pos="+x+", y_pos="+y+", z_poz="+z+", orientation="+orientate+"]");
    }
    
    private static void exitNav(){
        System.exit(0);
    }
}
    

