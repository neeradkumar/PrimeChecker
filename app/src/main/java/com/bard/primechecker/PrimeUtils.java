package com.bard.primechecker;

import java.util.ArrayList;
class PrimeUtils {

	static void printPrimeNumbersUpto(int n){
		int i;
		for(i=2;i<=n;i++){
			if(isPrimeOrNot(i)) System.out.println(i);
		}
	}
	static ArrayList<Integer> primeNumbersUpto(int n){
		int i;
		ArrayList<Integer> list = new ArrayList<>();
		for(i=2;i<=n;i++){
			if(isPrimeOrNot(i)) list.add(i);
		}
		return list;
	}
	static boolean isPrimeOrNot(int a){
		if(a==1) return false;
		if(a>2){
			int i;
			for(i=2; i<=a/2;i++){
				if(a%i == 0) return false;
			}
		}
		return true;
	}
}