package midtermProject;

import java.util.Scanner;

public class BankingSystem {

	public static void main(String[] args) {
		
		final int basicAccountNumber = 123, 
			basicPin = 111, 
			premiumAccountNumber = 456, 
			premiumPin = 222, 
			vipAccountNumber = 789, 
			vipPin = 333;
		
		double basicBalance = 10000, basicWithdrawLimit = 25000, premiumBalance = 20000,
					 premiumWithdrawLimit = 50000,  vipBalance = 50000;
		
		int counter, accountNumber, accountPin, userChoice, accountType = 0, transactionNum = 3,
				transactionRemaining = 0;
		
		double basicWithdrawnToday = 0,   premiumWithdrawnToday = 0, vipWithdrawnToday = 0,
			   basicDepositToday = 0,   premiumDepositToday = 0, vipDepositToday = 0;
	
		boolean exitProgram = false;
		
		Scanner scan = new Scanner (System.in);
		
		//for loop for counting log-in tries if counter <= 3 run the program below
		for (counter = 1; counter <= 3; counter++) {
			
			//ask user input for credentials
			System.out.print("Enter account number: ");
			accountNumber = scan.nextInt();
			
			System.out.print("Enter account pin: ");
			accountPin = scan.nextInt();
			
			//checker if counter is below 3
			if (counter <= 3) {
				
				//check if the user account number & pin matches to basic 
				if (accountNumber == basicAccountNumber && accountPin == basicPin) {
					System.out.println("-------------------------");
					System.out.println("Account Tier: Basic");
					System.out.println("Account Balance: $" + basicBalance);
					
					//do while loop for the banking system menu
					do {
						
						System.out.println("-------------------------");
						System.out.println("[1]Deposit\n[2]Withdraw\n[3]Check Balance\n[0]Exit");
						System.out.print("Enter choice: ");
						userChoice = scan.nextInt();
						System.out.println("-------------------------");
						
						if (transactionNum > 0 && transactionNum <= 3) {
							//switch for the menu program
							switch (userChoice) {
							//deposit
								case 1:
									//System.out.println("");
									System.out.println("Account Balance: $" + basicBalance);
									System.out.print("Enter ammount to deposit: $");
									basicDepositToday = scan.nextDouble();
									
									basicBalance += basicDepositToday;
									System.out.println("-------------------------");
									System.out.println("Successful deposit ");
									System.out.println("Account Balance: $" + basicBalance);
									
									//for transaction numbering
									transactionNum--;
									transactionRemaining = transactionNum;
									System.out.println("Transactions remaining: " + transactionRemaining);
									break;
									
								//withdraw
								case 2:
									//System.out.println("");
									System.out.println("Account Balance: $" + basicBalance);
									System.out.print("Enter ammount to withdraw: $");
									basicWithdrawnToday = scan.nextDouble();
									
									if (basicWithdrawnToday <= basicBalance) {
										if (basicWithdrawnToday <= basicWithdrawLimit) {
											
											basicBalance -= basicWithdrawnToday;
											System.out.println("-------------------------");
											System.out.println("Successful withdrawal ");
											System.out.println("Account Balance: $" + basicBalance);
											
											//for transaction numbering
											transactionNum--;
											transactionRemaining = transactionNum;
											System.out.println("Transactions remaining: " + transactionRemaining);
										} else {
											System.out.println("\nYou have hit the basic withdraw limit");
											System.out.println("Account Balance: $" + basicBalance);
										}
									} else {
										System.out.println("\nInsuficient Funds");
										System.out.println("Account Balance: $" + basicBalance);
									}
									break;
									
								//check balance
								case 3:
									System.out.println("Account Tier: Basic");
									System.out.println("Account Balance: $" + basicBalance);
									
									break;
								default:
									if (userChoice == 0) {
										System.out.println("Program terminated");
									} else {
										System.out.println("Invalid Input");
									}
		
									break;
								}
							
						//how do I repeat the log in process?
						} else if (transactionNum <= 0) {
							System.out.println(transactionRemaining);
							System.out.println("You have reached the maximum transaction "
									+ "\nnumber of your account");
							System.out.println("\n[1]Login again \n[2]Exit");
							System.out.print("Enter choice: ");
							int relogChoice = scan.nextInt();
							
							break;
						}
						
					//the loop will stop if the user enter 0
					} while (userChoice != 0);
					
					break;
					
				}  else if (accountNumber == premiumAccountNumber && accountPin == premiumPin) {
					System.out.println("-------------------------");
					System.out.println("Account Type: Premium");
					System.out.println("Account Balance: $" + premiumBalance);
					accountType = 2;
					
					//copy paste nalang mula sa basic, then ibahin variables
					
					break;
				} else if (accountNumber == vipAccountNumber && accountPin == vipPin) {
					System.out.println("-------------------------");
					System.out.println("Account Type: VIP");
					System.out.println("Account Balance: $" + vipBalance);
					accountType = 3;
					
					//copy paste nalang mula sa basic, then ibahin variables
					
					break;
				
				// if counter > 3, display locked account
				} else {
					System.out.println("-------------------------");
					System.out.println("Invalid credentials, " + (3 - counter) + " Tries remaining");
					System.out.println("-------------------------");
					if (counter >= 3) {
						System.out.println("");
						System.out.println("LOCKED ACCOUNT");
					}
				}
			//this else does nothing fuck, might delete idk
			} else {
				System.out.println("");
				System.out.println("Locked Account");
			}
			
		}
	}

}
