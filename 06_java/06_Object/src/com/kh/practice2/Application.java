package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.view.SnackView;


// POJO (Plain Old Java Object)
public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SnackView s = new SnackView();
		
		
		
		s.input();
		s.result();
		
		
	}

}
