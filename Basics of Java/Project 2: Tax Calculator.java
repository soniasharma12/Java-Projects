
/* 	Sonia Sharma
	ICS3U
	Multi-way Selection Assignment
	Feb. 23nd, 2021
	Description: This program is designed to calculate the user's federal & provincial tax; Sonia's Federal and Provincial Tax Calculator!
*/

import java.util.Scanner; // import Scanner class
public class TaxCalc 
{
  public static void main(String[] args) 
  {
   Scanner keyb = new Scanner(System.in); //create link to input stream
    
// Introduction
   System.out.println(" Welcome to Sonia's Tax Calculator!!");
   System.out.print(" Before we get started, please enter your first name: ");
   String name = keyb.next(); // get user's name 
   System.out.print(" Awesome! Additionally, please enter your annual salary: "); 
   double salary = keyb.nextDouble(); // get user's salary 
    
// Federal Tax 
    double rate=0, totFedTaxP=0, surtaxRate=0, provSurtaxP=0; // initialize variables beforehand
    
    if(salary<= 11038)
    {// if the user's salary is less than or equal to $11,038
      rate = 0;// initialize marginal tax rate
      double fedTaxP1 = salary*0; // calculate user's fed tax ; user's salary multiplied by the marginal tax rate
      totFedTaxP = fedTaxP1; // let user's total fed tax payable equal to the user's federal taxes
      System.out.println("\n "+name+", your marginal tax rate is "+(rate*100)+"%"); // output user's marginal tax rate
      System.out.println(" Your total fed tax payable is $"+totFedTaxP); // output user's total federal tax payable
    }// if
    
    else if(salary<=54599)
    {// else, if the user's salary is less than or equal to $54,599
      rate = 0.15; // initialize marginal tax rate
      double fedTaxP2 = (salary-11038)*0.15; // calculate user's fed tax payable; user's salary subtracted by $11,038, then multiplied by the 2nd marginal tax rate(15%)
      totFedTaxP = fedTaxP2; // let user's total fed tax payable equal to the sum of the user's federal taxes(since fedTaxP1=0, therefore the variable doesn't needed to be included in further calcuations)
      System.out.println("\n "+name+", your marginal tax rate is "+(rate*100)+"%"); // output user's marginal tax rate
      System.out.println(" Your total fed tax payable is $"+totFedTaxP); // output user's total federal tax payable
    }// else if statement 1
    
    else if(salary<=98161)
    {// else, if the user's salary is less than or equal to $98,161
      rate = 0.22; // initialize marginal tax rate
      double fedTaxP2 = (54599-11038)*0.15; // calculate user's fed tax payable; $54599 subtracted by $11,038, then multiplied by the 2nd marginal tax rate(15%)
      double fedTaxP3 = (salary-54599)*0.22; // calculate user's fed tax payable; user's salary subtracted by $54599, then multiplied by the 3rd marginal tax rate(22%)
      totFedTaxP = fedTaxP2+fedTaxP3; // let user's total fed tax payable equal to the sum of the user's federal taxes
      System.out.println("\n "+name+", your marginal tax rate is "+(rate*100)+"%"); // output user's marginal tax rate
      System.out.println(" Your total fed tax payable is $"+totFedTaxP); // output user's total federal tax payable
    }// else if statement 2
    
    else if(salary<=146092)
    {// else, if the user's salary is less than or equal to $146,092
      rate = 0.26; // initialize marginal tax rate
      double fedTaxP2 = (54599-11038)*0.15; // calculate user's fed tax payable; $54599 subtracted by $11,038, then multiplied by the 2nd marginal tax rate(15%)
      double fedTaxP3 = (98161-54599)*0.22; // calculate user's fed tax payable; $98161 subtracted by $54599, then multiplied by the 3rd marginal tax rate(22%)
      double fedTaxP4 = (salary-98161)*0.26; // calculate user's fed tax payable; user's salary subtracted by $98161, then multiplied by the 4th marginal tax rate(26%)
      totFedTaxP = fedTaxP2+fedTaxP3+fedTaxP4; // let user's total fed tax payable equal to the sum of the user's federal taxes
      System.out.println("\n "+name+", your marginal tax rate is "+(rate*100)+"%"); // output user's marginal tax rate
      System.out.println(" Your total fed tax payable is $"+totFedTaxP); // output user's total federal tax payable
    }// else if statement 3
    
    else if(salary>146093)
    {// else, if the user's salary is greater than $146,093
      rate = 0.29; // initialize marginal tax rate
      double fedTaxP2 = (54599-11038)*0.15; // calculate user's fed tax payable; $54599 subtracted by $11,038, then multiplied by the 2nd marginal tax rate(15%)
      double fedTaxP3 = (98161-54599)*0.22; // calculate user's fed tax payable; $98161 subtracted by $54599, then multiplied by the 3rd marginal tax rate(22%)
      double fedTaxP4 = (146092-98161)*0.26; // calculate user's fed tax payable; $146092 subtracted by $98161, then multiplied by the 4th marginal tax rate(26%)
      double fedTaxP5 = (salary-146092)*0.29; // calculate user's fed tax payable; user's salary subtracted by $146092, then multiplied by the 5th marginal tax rate(29%) 
      totFedTaxP = (fedTaxP2+fedTaxP3+fedTaxP4+fedTaxP5); // let user's total fed tax payable equal to the sum of the user's federal taxes
      System.out.println("\n "+name+", your marginal tax rate is "+(rate*100)+"%"); // output user's marginal tax rate
      System.out.println(" Your total fed tax payable is $"+totFedTaxP); // output user's total federal tax payable
    }// else if statement 4
    
// Provincial Tax
    System.out.println("\n Moving onto calculating your provincial income tax!");
    
    System.out.println("\n PROVINCES AND TERRITORIES:");// menu option which corresponds to Canada's provinces & territories
  	System.out.println("\n 1. Alberta "); 
    System.out.println(" 2. British Columbia ");
    System.out.println(" 3. Manitoba ");
    System.out.println(" 4. New Brunswick ");
    System.out.println(" 5. Newfoundland & Labrador ");
    System.out.println(" 6. Northwest Territories ");
    System.out.println(" 7. Nova Scotia");
    System.out.println(" 8. Nunavut");  
  	System.out.println(" 9. Ontario ");
    System.out.println(" 10. Prince Edward Island ");
    System.out.println(" 11. Quebec ");
    System.out.println(" 12. Saskatchewan ");      
    System.out.println(" 13. Yukon ");
    System.out.print("\n Please enter the number corresponding to your province or territory: ");
    int province = keyb.nextInt();// get user's province as an integer 
    
    switch(province)
    {
      case 1:
      case 4:
      case 10:
      // case statement: if user enters Alberta, New Brunswick, or Prince Edward Island as their province 
        surtaxRate = 0.10;// initialize surtax rate for the selected province
        System.out.println("\n Your surtax rate is "+(surtaxRate*100)+"%"); // output user's surtax rate
        provSurtaxP = totFedTaxP*surtaxRate;// calculate user's total provincial surtax payable; the product of the total federal tax & surtax rate
        System.out.println(" Your provincial surtax payable is $"+provSurtaxP);// output user's provincial surtax payable
      	break;// stop execution
     
      case 2:
      case 6:
      case 9:
       // case statement: if user enters British Columbia, Northwest Territories, or Ontario as their province/territory
        surtaxRate = 0.06;// initialize surtax rate for the selected province/territory
        System.out.println("\n Your surtax rate is "+(surtaxRate*100)+"%");// output user's surtax rate
        provSurtaxP = totFedTaxP*surtaxRate;// calculate user's total provincial surtax payable; the product of the total federal tax & surtax rate
        System.out.println(" Your provincial surtax payable is $"+provSurtaxP);// output user's provincial surtax payable
        break;// stop execution
      
      case 3:
      case 5:
      case 12:
      // case statement: if user enters Manitoba, Newfoundland & Labrador, or Saskatchewan as their province
        surtaxRate = 0.11;// initialize surtax rate for the selected province
        System.out.println("\n Your surtax rate is "+(surtaxRate*100)+"%");// output user's surtax rate
        provSurtaxP = totFedTaxP*surtaxRate;// calculate user's total provincial surtax payable; the product of the total federal tax & surtax rate
        System.out.println(" Your provincial surtax payable is $"+provSurtaxP);// output user's provincial surtax payable
        break;// stop execution
      
      case 7:
      case 11:
      // case statement: if user enters Nova Scotia or Quebec as their province
        surtaxRate = 0.09;// initialize surtax rate for the selected province
        System.out.println("\n Your surtax rate is "+(surtaxRate*100)+"%");// output user's surtax rate
        provSurtaxP = totFedTaxP*surtaxRate;// calculate user's total provincial surtax payable; the product of the total federal tax & surtax rate
        System.out.println(" Your provincial surtax payable is $"+provSurtaxP);// output user's provincial surtax payable
        break;// stop execution
      
      case 8:
      // case statement: if user enters Nunavut as their province
        surtaxRate = 0.04;// initialize surtax rate for the selected province
        System.out.println("\n Your surtax rate is "+(surtaxRate*100)+"%");// output user's surtax rate
        provSurtaxP = totFedTaxP*surtaxRate;// calculate user's total provincial surtax payable; the product of the total federal tax & surtax rate
        System.out.println(" Your provincial surtax payable is $"+provSurtaxP);// output user's provincial surtax payable
        break;// stop execution
      
      default:
      // case statement: else, if user enters Yukon as their province
        surtaxRate = 0.07;// initialize surtax rate for the selected province
        System.out.println("\n Your surtax rate is "+(surtaxRate*100)+"%");// output user's surtax rate
        provSurtaxP = totFedTaxP*surtaxRate;// calculate user's total provincial surtax payable; the product of the total federal tax & surtax rate
        System.out.println(" Your provincial surtax payable is $"+provSurtaxP);// output user's provincial surtax payable
        break;// stop execution
        
    }// switch

// Total Tax Payable 
      double totTaxP = totFedTaxP + provSurtaxP; // let the total combined tax payable equal to the sum of the total federal tax payable and the total provincial surtax payable
      System.out.println("\n Your combined total tax payable is $"+totTaxP);// output user's overall tax payable
    
// Overall Tax Statement
    System.out.println("\n "+name+", your marginal tax rate is "+rate+ "%, your total federal tax payable is $"+totFedTaxP+ ", your surtax rate is "+surtaxRate+"%, your total provincial tax payable is $"+provSurtaxP+",\n and lastly, your total tax payable is $"+totTaxP+"!");
    System.out.println("\n Thank you for using Sonia's Tax Calculator!");
    
  } //main method
} //TaxCalc 

