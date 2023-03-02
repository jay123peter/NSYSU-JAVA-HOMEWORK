/**
 * 
 */
/**
 * @author chen jia ming
 *
 */

package myjava.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class prime {
	/* Check whether it's prime number */
	public static boolean isPrime(int num) {
		// Write down your code.
		for(int i = 2; i < num; i++){
			 if( num % i == 0){
				 return false;
			}
		}
		return true;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int option, num, i, count = 0;
		Scanner scan = null;

		while (true) {
			try {
				/* Get standard input object. */
				scan = new Scanner(System.in);
				
				/* Print message. */
				System.out.println("1. Check whether it's prime number\n" + "2. Find prime number(2~N)\n" + "3. Leave");
				
				/* Input an integer. */
				option = scan.nextInt();
				switch (option) {
				
					case 1:
						/* Write down your code. */
						/* Check whether it's prime number */
						System.out.println("Input the number:");
						num = scan.nextInt();
						
						if(num < 2){
							System.out.println("N must equal greater than 2");
						}else{
							if(prime.isPrime(num)==true){
								System.out.printf("%d is a prime\n",num);
							}else{
								System.out.printf("%d is not a prime\n",num);
							}
						}
						
						break;
						
					case 2:
						/* Write down your code. */
						/* Find prime number(2~N) */
						System.out.println("Input the number:");
						num=scan.nextInt();
						if(num <2){
							System.out.println("N must equal greater than 2");
						}else{
							System.out.print("show the prime numbers(2 ~ 100)\n");
							for(i=2;i<=num;i++){
								if(prime.isPrime(i)==true){
									System.out.printf("%d\t",i);
									count++;
									if(count==7){
										System.out.printf("\n");
										count = 0;
									}
								}
							}
							System.out.print("\n");
						}

						
						break;
						
					case 3:
						/* Write down your code. */
						/* End the process */
						//scanner.close();
						System.out.println("Bye!!!");
						System.exit(0);
						break;
						
					default:
						System.out.println("Input error : incorrect option");
						break;
				}
				
			} catch (InputMismatchException e) {
					System.out.println("Input error : ONLY Integers.");
			}
			
		}
	}
}