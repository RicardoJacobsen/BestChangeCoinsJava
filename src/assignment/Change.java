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


public class Change {
 
 private String personName;
 private int  coinAmount;
       int fiftyCent;
       int tenCent;
       int fiveCent;
       int   totalFifty ;
       int  totalTen ;
       int totalFive ;
 //Declaring an array of object
 Change peep[];
 

 
 
 //default constructor
  Change(){
 
         personName="Unknown";
         coinAmount=0;
 } 

   //  Constructor setting the values to variables
   Change(String name, int amount)
   {
       this.personName = name;
       this.coinAmount = amount;
   }// End of parameterized constructor

//  Constructor for the array
   Change(int size)
   {  
        //returning -1 mean to hardcode
        if (size==-1){size=12;
        peep =new Change[size];
        this.hardCode();}else{
         peep =new Change[size];
        }
   }// End of constructor
   
   //Check if the name is already into the array
   // pre-condition  receive the client name as a parameter 
  //post-condition returns the client position.
   public int findPerson(String name){
     int position=-1;
       for (int i = 0; i < (Client.c); i++) {
           if(peep[i].personName.equalsIgnoreCase(name)){
            position= i;   
            }
       }
       
       return position;
   }
   
  //Check if the name is already into the array
   // pre-condition  receive the client name as a parameter 
  //post-condition 
    void addChange(String name, int amount)
   {
     
       peep[Client.c] = new Change(name, amount);
   }
   
     // pre-condition: receive the client name as a parameter to be set
  //post-condition: sets the client object name. 
 public void setPersonName(String name){
          this.personName=name;
 }
 
  // pre-condition: receive the amount as a parameter 
  //post-condition: Calculates the denominations amount 
  void calculateChange(int amount)
   {       
       // Calculates number of fifties available in amount
       this. fiftyCent = amount / 50;
       // Calculates remaining amount
       amount = amount % 50;
      
       // Calculates number of tens available in amount
       this.tenCent = amount / 10;
       // Calculates remaining amount
       amount = amount % 10;
      
       // Calculates number of fives available in amount
       this. fiveCent = amount / 5;
       // Calculates remaining amount
       amount = amount % 5;
      
    
      
   }// End of method
 
  // pre-condition does not receive any parameter 
  //post-condition returns the client position with the smallest amount.
   public int  smallestAmount()
   {
       // Stores the first client amount as smallest amount
       int smallest = peep[0].coinAmount;
       // Stores the first client position as smallest position
       int position = 0;
      
       // Loops from 1 to end of the array of clients
       for(int c = 1; c < Client.c; c++)
       {
           // Checks if current client amount is less than the earlier smallest amount
           if(peep[c].coinAmount < smallest)
           {
               // Assigns the current client amount as the smallest amount
               smallest = peep[c].coinAmount;
               // Stores the current position as the smallest position
               position = c;
             
           }// End of if condition
       }// End of for loop
return position;
   }// End of method
   
   // Method to find the client having largest amount and display
   // client information with change
   
   // pre-condition does not receive any parameter 
  //post-condition returns the client position with the largest amount.
   public int largestAmount()
   {
       // Stores the first client amount as largest amount
       int largest = peep[0].coinAmount;
       // Stores the first client position as largest position
       int position = 0;
          
       // Loops from 1 to end of the array of clients
       for(int c = 1; c < Client.c; c++)
       {
           // Checks if current client amount is greater than the earlier largest amount
           if(peep[c].coinAmount > largest)
           {
               // Assigns the current client amount as the largest amount
               largest = peep[c].coinAmount;
               // Stores the current position as the largest position
               position = c;
               
           }// End of if condition
       }// End of for loop
          
       return position;
       
   }// End of method
  
   // pre-condition does not receive any parameter 
  //post-condition:  Stores the total number of each denomination
   public void showTotal(){
     for(int i=0; i<Client.c; i++){
                             
                                  peep[i].calculateChange(peep[i].getCoinValue());   
                                  totalFifty+=peep[i].fiftyCent ;
                                  totalTen+=peep[i].tenCent ;
                                  totalFive+=peep[i].fiveCent ;
                                   
                               }
   
   }
        // pre-condition: receive the client amount as a parameter to be set
  //post-condition: sets the client object coin amount. 
 public void setCoinValue(int coin){
         
        this.coinAmount=coin;
 }
 
 // In case of duplicates in the array.
 // pre-condition: receive the client amount as a parameter to be added 
  //post-condition: Adds the client object amount. 
 public void addCoinValue(int coin){
         
        this.coinAmount+=coin;
 }
 
 //Returns the client name 
  public String getPersonName(){
          return this.personName; 
 }
 
 // return the client amount 
 public int getCoinValue(){
          return this.coinAmount;
 }

 // to check if the user want to continue
  public static boolean keepEntering (char resp){
       boolean result=false;
       
       if (resp=='Y'){
       result = true;
       }
       else if (resp=='N'){
       result = false;
       }
       return result;
       }

  
public void hardCode(){

peep[0] = new Change("Jane",20);
peep[1] = new Change("John",15);
peep[2] = new Change("Fred", 95);
peep[3] = new Change("Wilma", 85);
peep[4] = new Change("Paul", 65);
peep[5] = new Change("Marry",50);
peep[6] = new Change("Adam",75);
peep[7] = new Change("Xavier",70);
peep[8] = new Change("Ricardo", 30);
peep[9] = new Change("Camila", 65);
peep[10] = new Change("Martin",55);
peep[11] = new Change("Tom", 80);
}
  
 
 }//class end
    

