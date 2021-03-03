/**
 * Title: Client Change
 * @author Ricardo Laner Jacobsen Teixeira
 * Date: 01/09/2020
 * File name: Assignment
 * Purpose: This program was created with the intuition of helping the user on giving change based on a specific amount.
 * For testing purposes, it was added an initial statement when the program is running that gives instructions to auto input 12 customers on the array, so if the statement is followed, the program will run based on 
  12 clients.
 * 
 */
package assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
        
        public static Scanner keyboard = new Scanner (System.in);
        
        //to control the position of the object on the array in the client and Change class as well.
        static int c=0; 
     
    public static void main(String[] args) {
        String name="";
        //To receive the client amount
        int amount=0;
        //To control if the program continues
        boolean keep=true;
        char autoInput=' ';
        //To check the range.
        boolean inRange=false;
        //To define the quantity of data stored into the array
        int howMany =0;
        //Controll the menu case
        int menu = 0;
                    
        
       StudentInfo();
        
        //Displays the instructions  
       displayInitialStatements();
       howMany= keyboard.nextInt();
       keyboard.nextLine();
       
        // Creates an object of the class Change using parameterized constructo and passing number of persons as parameter
        Change person = new Change(howMany);
      

        //looping while the user wishes to continue.
        while(keep==true ){
        //-1 means hardcode so, we do not need to enter manually
        if(howMany==-1){
            //parametrizing the counter as the amountber of hardcoded of 12 people
        c=12;
        break;}//end of if 
        
        System.out.println("Please enter the PERSON NAME: ");       
        name=keyboard.nextLine();
         String provisoryName=" ";    
        for (int i = 0; i < name.length(); i++) {             
               if(name.charAt(i)==' '){                   
                   name = provisoryName;
                   break;}else{  
                   provisoryName+=name.charAt(i);}
            }
        
        // Looping till get the amount in range.
        while(inRange==false){
         while (true) { // loops forever until break
    try { // checks code for exceptions
       System.out.println("Please enter the COIN VALUE for the person (RANGE 5 TO 95, MULTIPLE of 5): ");
        amount=keyboard.nextInt();
        break; // if no exceptions breaks out of loop
    } 
    catch (InputMismatchException e) { // if an exception appears prints message below
        System.err.println("Please enter a number! ");
        keyboard.next();
        continue; // continues to loop if exception is found
    }
}
            
        //Checking if the amount entered is in range.
        if(amount>=5 && amount<=95 && amount%5==0){
        inRange=true;
        }else{
        inRange=false;
        } // end of if 
        }//end of range while 
       
        int ret = person.findPerson(name);
        if(c==0){person.addChange( name, amount);}
        else if(ret!=-1){
        person.peep[ret].addCoinValue(amount);
         c--; 
        }
        else if(ret==-1){
         person.addChange( name, amount);
        }
       //incrementing the position
       
       c++;
        //postion of the arra must be the same as the number of person entered
        //otherwise error will occur
        if(c==howMany){break;}
        
        //Checking if the user wants to continue. 
        
        
        while (true) { // loops forever until break
    try { // checks code for exceptions
        System.out.println("Do you wish to KEEP ENTERING? [y/n]: ");
        keep = person.keepEntering(keyboard.next().toUpperCase().charAt(0));
              keyboard.nextLine();
        break; // if no exceptions breaks out of loop
    } 
    catch (InputMismatchException e) { // if an exception appears prints message below
        System.err.println("Please enter a A CHAR! ");
        keyboard.next();
        continue; // continues to loop if exception is found
    }
}
        
        //THIS IS THE PREVIOUS CODE WITHOUT THE VALIDATION
      //  System.out.println("Do you wish to KEEP ENTERING? [y/n]: ");
       // keep = person.keepEntering(keyboard.next().toUpperCase().charAt(0));
       // keyboard.nextLine();
        
        //Reseting variable for while loop
        inRange = false;
        }//end of keep while 
       
        
        do {                 
       //Dispalay the menu  
       displayMenu();
       
       try {
          // Accepts and returns user choice
        menu =  keyboard.nextInt();
            } catch (InputMismatchException e) {
                menu = 0;
                keyboard.next();
            }
     
         
        
        while(menu>5 || menu<1){
        System.out.println("\nThe option you entered is INVALID TRY AGAIN.");
        displayMenu();
        menu =  keyboard.nextInt();
        } 
        
       while( menu>=1 ){
       //menu as the number 
        switch(menu){
            
            case 1:
                    // Enter the name of the person
                   System.out.print("\n Please enter the name of the person: ");
             
                   name = keyboard.next();
                   
                    
                   int personFound=person.findPerson(name);
                  
                   if(personFound==-1){
                       System.out.println("Name: "+name+"\n" +
                                                           "Not found");
                   }
                   else{
                       person.peep[personFound].calculateChange(person.peep[personFound].getCoinValue());
                       System.out.println("Customer:  \n" +  person.peep[personFound].getPersonName() + " "+ person.peep[personFound].getCoinValue() + " cents");
                       System.out.println("Change: ");
                       if(person.peep[personFound].fiftyCent != 0)
                        System.out.println("50 cents: " +person.peep[personFound]. fiftyCent);
      
                        // Checks if number of tens is not zero then display the data
                        if(person.peep[personFound].tenCent != 0)
                         System.out.println("10 cents: " + person.peep[personFound].tenCent);
      
                        // Checks if number of five is not zero then display the data
                        if(person.peep[personFound].fiveCent != 0)
                        System.out.println("5 cents: " + person.peep[personFound].fiveCent);
                        
                       
                       
                    
             
                   }//end of if statement  
                   break;
                   
            case 2:
                       personFound= person.smallestAmount();
                       person.peep[personFound].calculateChange(person.peep[personFound].getCoinValue());
                       
                       System.out.println("\n The name with the SMALLEST amount is.:  " +  person.peep[personFound].getPersonName() + " with:  "+ person.peep[personFound].getCoinValue() + " cents");
                       System.out.println("Change: ");
                       
                       if(person.peep[personFound].fiftyCent != 0)
                       System.out.println("50 cents: " +person.peep[personFound]. fiftyCent);
      
                        // Checks if number of tens is not zero then display the data
                        if(person.peep[personFound].tenCent != 0)
                        System.out.println("10 cents: " + person.peep[personFound].tenCent);
      
                        // Checks if number of five is not zero then display the data
                        if(person.peep[personFound].fiveCent != 0)
                        System.out.println("5 cents: " + person.peep[personFound].fiveCent);
                        
              
                       
                       break;
                       
            case 3:
                       personFound= person.largestAmount();
                       person.peep[personFound].calculateChange(person.peep[personFound].getCoinValue());
                       
                       System.out.println("\n The name with the LARGEST amount is.:  " +  person.peep[personFound].getPersonName() + " with:  "+ person.peep[personFound].getCoinValue() + " cents");
                       System.out.println("Change: ");
                       
                       if(person.peep[personFound].fiftyCent != 0)
                        System.out.println("50 cents: " +person.peep[personFound]. fiftyCent);
      
                        // Checks if number of tens is not zero then display the data
                        if(person.peep[personFound].tenCent != 0)
                         System.out.println("10 cents: " + person.peep[personFound].tenCent);
      
                        // Checks if number of five is not zero then display the data
                        if(person.peep[personFound].fiveCent != 0)
                        System.out.println("5 cents: " + person.peep[personFound].fiveCent);
                        
                        break;
                        
            case 4:
                                                            
                        person.showTotal();
                        System.out.println("\n The TOTAL OF FIFTY CENTS IS: " + person.totalFifty);
                        System.out.println("\n The TOTAL OF TEN CENTS IS: " +person.totalTen);
                        System.out.println("\n The TOTAL OF FIVE CENTS IS: " +person.totalFive);
                        
                        System.out.println("\nThe sum of all clients is: " + (person.totalFifty+person.totalTen+person.totalFive));
                                   
                         //Restarting the variables to not double values if case 4 is called again.
                        person.totalFifty=0;
                        person.totalTen=0;
                        person.totalFive=0;
                        
                    
                        break;     
                        
            case 5:
                        System.out.println("\nYou QUIT, thank you for using this program.\nBye!");
                        System.exit(0);
        }//End of Switch
        
        displayMenu();
        menu =  keyboard.nextInt();
        
        while(menu>5 || menu<1){
            System.out.println("\nThe option you entered is INVALID TRY AGAIN.");
            displayMenu();
        menu =  keyboard.nextInt();
        }
        
   }//end while menu
    } while (menu>5 || menu<1);
}//end of main method

   
  
public static void displayInitialStatements(){//Method  to output the intial statements   
        System.out.println("FOR TESTING the program AND automatically complete the 12 clients for you? : ");
        System.out.println("WHERE IT ASKS THE NUMBER OF PERSON ENTER THE NUMBER -1");
        //Displaying the recomendation 
        System.out.println("RECOMENDED: Please enter at least 12 records to test  the program.");
        System.out.println("_________________________________________________________________");
        System.out.println("");
        // Enter the number of persons
       System.out.print("\n Please enter number of people: ");
}

 
public static void displayMenu(){ // Displays menu
       System.out.print("\n\n ********************** Change Menu **********************");
       System.out.print("\n 1. Enter a name and display change to be given for each denomination.");
       System.out.print("\n 2. Find the name with the smallest amount and display change to be given for each denomination.");
       System.out.print("\n 3. Find the name with the largest amount and display change to be given for each denomination.");
       System.out.print("\n 4. Calculate and display the total number of coins for each denomination, and the sum of these totals.");
       System.out.print("\n 5. Exit.");
       System.out.print("\n\t What is your choice: ");
}
 
 public static void StudentInfo(){
     System.out.println("Name: Ricardo Laner Jacobsen Teixeira");
     System.out.println("Student Number: 34031229");
     System.out.println("Mode of enrolment: Internal ");
     System.out.println("Tutor: Upeke");
     System.out.println("\n\nTutorial: Thursday 3:30 pm");
 }

}//end of class
    