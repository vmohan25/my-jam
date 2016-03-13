package com.kalsakre.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Anagrams {
	
	static char[] chars;
	static int size;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String anagram="";
		try {
			anagram = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(rotate(anagram));
		chars = anagram.toCharArray();
		size=chars.length;
		findAnagrams(size);
	}
	
	private static void findAnagrams(int size){
		//List<String> anagrams = new ArrayList<String>();
		
		if(size ==1){
			return;
		}
		
		for(int i=0;i<size;i++){
			findAnagrams(size-1);
			if(size == 2){
				displayWord();
			}
			rotate(size);
		}
	}
	
	
	private static void rotate(int newsize){
		int position = size - newsize;
		char temp = chars[position];
		for(int k=position;k<size-1;k++){
			chars[k] = chars[k+1];
		}
		chars[size-1]=temp;
	}
	
	private static char[] rotate(char[] chars){
		char temp = chars[0];
		int N=chars.length;
		for(int i=0;i<N-1;i++){
			chars[i] = chars[i+1];
		}
		chars[N-1] = temp;
		return chars;
	}
	
	private static String reverse(String source){
		char[] chars = source.toCharArray();
		int N = chars.length, mid = N/2; 
		for(int i=0,j=N-1; i<mid && j>=mid;i++,j--){
			char temp = chars[j];
			chars[j] = chars[i];
			chars[i] = temp;
		}
		return new String(chars);
	}
	private static String rotate(String source){
		char[] chars = source.toCharArray();
		char temp = chars[0];
		int N=chars.length;
		for(int i=0;i<N-1;i++){
			chars[i] = chars[i+1];
		}
		chars[N-1] = temp;
		return new String(chars);
	}
	
	private static void displayWord(){
		
		for(int j=0;j<size;j++){
			System.out.print(chars[j]);
		}
		System.out.println("");
	}
}
