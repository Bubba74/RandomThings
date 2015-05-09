package Objects;

public class Operation {
	
	
	public double add (double...numbers){
		double total = 0;
		
		for (double x:numbers){
			total += x;
		}
		
		return total;
	}//add method
	
	public double sub (double...numbers){
		double total = 0;
		boolean num1 = true;
		
		for (double x:numbers){
			
			if (num1){
				total = x;
				num1 = false;
			} else{total -= x;}
			
		}
		
		return total;
	}//subt method

	public double mult (double...numbers){
		double total = 1;
		
		for (double x:numbers){
			total *= x;
		}
		
		return total;
	}//add method
	
	public double div (double...numbers){
		double total = 0;
		boolean num1 = true;
		
		for (double x:numbers){
			
			if (num1){
				total = x;
				num1 = false;
			} else{total /= x;}
			
		}
		
		return total;
	}//subt method

	
	public double power (double base, int expo){
		
		double total = 1;
		
		for (int i = 0; i < expo; i++){
			total *= base;
		}
		
		return total;
	}
	
	public double root (double base, int power){
		
		double guess=0;
		double i = 0;
		
		while (i < base){
			
			guess = power(i,power);
			
			if (guess==base){
				return i;
			} else{
			i = i + 1;
			}
		}
		return guess;
	}

	
	public String binomial (int a1, int b1, int a2, int b2){
		
		String ans = "";
		int x1, x2, x3;
		x1 = a1 * a2;
		x2 = a1 * b2 + a2 * b1;
		x3 = b1 * b2;
		
		ans = String.format("%sx^2 + %sx + %s", x1,x2,x3);
		
		return ans;
	}
	
//	public String polynomial (String a, String oper, String b){
	public String polynomial (int[] a, String oper, int[] b){
		
		int[] polynomialA = a;
		int[] polynomialB = b;
		
		/*
		//vvvvvvv//CREATES ARRAYS OF 'a' AND 'b' TERMS//vvvvvvv//
		int commaNumA = 0;
		
		for (int i=0;i<a.length();i++){
			if (a.codePointAt(i) == 44){
				commaNumA++;
			}
		}
		int polynomialA[] = toPoly(a);
		String degreeA;
		if (polynomialA.length==1){
			degreeA = "1st";
		} else if(polynomialA.length==2){
			degreeA = "2nd";
		} else if(polynomialA.length==3){
			degreeA = "3rd";
		} else{
			degreeA = polynomialA.length + "th";
		}
//		System.out.printf("%s degree polynomial:\n", degreeA);
		
		int polyA = 0;
		while (polyA < commaNumA+1){
//			System.out.println(polynomialA[polyA]);
			polyA++;
		}
		////////////////////////////////////////////////////////
		int commaNumB = 0;
		
		for (int i=0;i<b.length();i++){
			if (b.codePointAt(i) == 44){
				commaNumB++;
			}
		}
		int polynomialB[] = toPoly(b);
		String degreeB;
		if (polynomialB.length==1){
			degreeB = "1st";
		} else if(polynomialB.length==2){
			degreeB = "2nd";
		} else if(polynomialB.length==3){
			degreeB = "3rd";
		} else{
			degreeB = polynomialB.length + "th";
		}
//		System.out.printf("%s degree polynomial:\n", degreeB);
		int polyB = 0;
		while (polyB < commaNumB+1){
//			System.out.println(polynomialB[polyB]);
			polyB++;
		}
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
		*/
		
		String finalAnswer = "";
		
		if (oper == "+"){
			finalAnswer = addPoly(polynomialA,polynomialB);
		} else if (oper == "-"){
			finalAnswer = subPoly(polynomialA,polynomialB);
		} else if (oper == "*"){
			finalAnswer = multPoly(polynomialA,polynomialB);
		} else if (oper == "/"){
			finalAnswer = divPoly(polynomialA,polynomialB);
		}
		
		
		
		
		return finalAnswer;
	
	}//polynomial method
	
	
	
	public String addPoly(int[] polyA, int[] polyB){
		
		String total = "";
		
		
		
		return total;
	}//addPoly method
	public String subPoly(int[] polyA, int[] polyB){
	
	String total = "";
	
	
	
	return total;
	}//subPoly method
	public String multPoly(int[] polyA, int[] polyB){
		
		String answer = "";
		int termA = polyA.length;
		int termB = polyB.length;
		int termC = termA+termB-1;
		
		int sum[][] = new int[termA][termB]; //sum[][] is the punnett square for polyA/B
		int total[] = new int [termC];

		//vvvvvv//As always, dad adds a great idea...//vvvvvvv//
		/*
		for (int z1 = 0; z1<termA;z1++){
			total[z1] = 0;
		}
		for (int z1 = 0; z1<termA;z1++){
			for(int z2 = 0; z2<termB;z2++){
				total[z1+z2] += polyA[z1]*polyB[z2];
			}
		}
		*/
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
		
		//vvvvvvvvvv//Creates punnet square sum[][]//vvvvvvvvv//

		for (int z1 = 0; z1<termA;z1++){
			for(int z2 = 0; z2<termB;z2++){
				
//				System.out.printf("Z's: %s:%s\n",z1,z2);
				sum[z1][z2]=polyA[z1]*polyB[z2];
//				System.out.printf("Sum: %s\n", sum[z1][z2]);
				
			}//cycles through values in polyB
		}//cycles through values in polyA
		
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
		
		for (int i=0;i<termC;i++){
			
			for(int s1=0;s1<termA;s1++){
				for(int s2=0;s2<termB;s2++){
	
					if (s1+s2==i){
						total[i]+=sum[s1][s2];
					}

				}
			}
//			System.out.printf("Total: %s\n", total[i]);
			
			if (i==0){
				if (total[i]<0){
					answer+=String.format("%sx^%s",total[i]*-1,termC-i-1);
				} else if (total[i]>0){
					answer+=String.format("%sx^%s",total[i],termC-i-1);
				}
//				answer+=String.format("%sx^%s",total[i],termC-i-1);
			} else if (i==termC-1){
				if (total[i]<0){
					answer+=String.format(" - %s",total[i]*-1);
				} else if (total[i]>0){
					answer+=String.format(" + %s",total[i]);
				}				
			} else if (i==termC-2){
				if (total[i]<0){
					answer+=String.format(" - %sx",total[i]*-1);
				} else if (total[i]>0){
					answer+=String.format(" + %sx",total[i]);
				}
			} else{
				if (total[i]<0){
					answer+=String.format(" - %sx^%s",total[i]*-1,termC-i-1);
				} else if (total[i]>0){
					answer+=String.format(" + %sx^%s",total[i],termC-i-1);
				}
			}
			
		}//cycles through polyA/B, summing values in total[]

		
		return answer;
	}//multPoly method
	public String divPoly(int[] polyA, int[] polyB){
		//probably not gonna do this
		String total = "";		
		return total;
	}//divPoly method

	
	public int[] toPoly (String poly){
		
		int aLength = poly.length();
		
		String charArray[] = new String [aLength];
		int codeArray[] = new int [aLength];
		
		//vvvvvvvvvvvvvvvv//INITIATES POLYNOMIAL ARRAYS//vvvvvvvvvvvvvvvvvvvvvvvvvv//
		
		for (int i = 0; i < aLength; i++){
			
			charArray[i] = poly.substring(i,i+1);
//			System.out.println(aArray[i]);
			codeArray[i] = poly.codePointAt(i);
//			System.out.println(bArray[i]);
			
		}
		
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//

		//vvvvvvvvvvvvv//DETERMINES NUMBER OF COMMAS IN ARRAY//vvvvvvvvvvvvvvvvvvvv//
		
		int commaNum = 0;
		
		for (int i=0;i<aLength;i++){
			if (codeArray[i] == 44){
				commaNum++;
			}
			
		}
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
		
		int polyArray[] = new int[commaNum+1];
		
		int n = 0;
		int term = 0;
		int term2 = 0;
		while( n<term2){
			
			polyArray[term]=0;
			term2++;
			n++;
		}

//		System.out.println(poly);
		
		int digit = 0;
		
		int i = 0;
		while(i<aLength){ //Sequence of 0,_..._,commaNum
//			System.out.println(i);
			
			if (codeArray[i] == 44){
				term+=1;
//				System.out.println("Term+1");
			} else{
//				term+=1;
				
				int x = 0;
				
				if(codeArray[i]==48){
					x=0;
				} else if(codeArray[i]==49){
					x=1;
				} else if(codeArray[i]==50){
					x=2;
				} else if(codeArray[i]==51){
					x=3;
				} else if(codeArray[i]==52){
					x=4;
				} else if(codeArray[i]==53){
					x=5;
				} else if(codeArray[i]==54){
					x=6;
				} else if(codeArray[i]==55){
					x=7;
				} else if(codeArray[i]==56){
					x=8;
				} else if(codeArray[i]==57){
					x=9;
				}
				
//				System.out.println(polyArray[term]);
				polyArray[term]= polyArray[term]*10 + x;
//				System.out.println(polyArray[term]);
//				polyArray[term]=codeArray[i];
			}
//			System.out.printf("Poly array in slot %s = : %s\n",term,polyArray[term]);
		
			
			/*
			if (digit < 4 && codeArray[digit]==44){
				digit+=1;
				limit+=1;
				
			} else{
				
				
//				polyArray[i]
				limit+=1;
//				digit+=1;
			}
			digit+=1;
//			System.out.println(digit); //digit = #'s of digits in codeArray
			
//			polyArray[digit]=codeArray[i];
			System.out.println(codeArray[digit-1]);*/
			
			
			
			i++;
			
		}//while loop
		
		return polyArray;
	}//toPoly method

}//Operation class

//Below are the unicode values for numbers and commas:

//	,=44
//  -=45
//	0=48
//	1=49
//	2=50
//	3=51
//	4=52
//	5=53
//	6=54
//	7=55
//	8=56
//	9=57