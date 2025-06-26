package com.kh.practice1;

import java.util.*;

public class Application {
	
	Random r = new Random();
	
	public static void main(String[] args) {
		// 1등 당첨 기준이 로또 번호 6개
		// 둘 다 랜덤! 로또 번호는 1번!
		// 내 번호는 맞출때까지!!
		// 1~ 45
		
		Application a = new Application();
		
		ArrayList<Integer> lottoNum = a.randomLottoNum();
		int bonusnum = a.bonusNum(lottoNum);
		ArrayList<Integer> myNum = null;
		
		int[] correctRank = new int[5];
		
		long tryNum = 0;
		
		do {
			System.out.println("로또 번호 : "+ lottoNum + " , 보너스 번호 : " + bonusnum);
			myNum = a.randomLottoNum();
			System.out.println("내 번호 : "+ myNum);
			
			int correctNum = a.isSame(lottoNum, myNum, bonusnum)[0];
			int bonusCorrect = a.isSame(lottoNum, myNum, bonusnum)[1];
			
			if(correctNum == 6) correctRank[0]++;
			else if(correctNum == 5 && bonusCorrect == 1) correctRank[1]++;
			else if(correctNum == 5) correctRank[2]++;
			else if(correctNum == 4) correctRank[3]++;
			else if(correctNum == 3) correctRank[4]++;
			
			tryNum++;
			System.out.printf("1등 횟수 : %d, 2등 횟수 : %d, 3등 횟수 : %d, 4등 횟수 : %d, 5등 횟수 : %d\n",correctRank[0],correctRank[1],correctRank[2],correctRank[3],correctRank[4]);
		} while(a.isSame(lottoNum, myNum, bonusnum)[0] < 6);
		
		System.out.println("1등 당첨! 횟수 : " + tryNum);
		System.out.printf("1등 횟수 : %d, 2등 횟수 : %d, 3등 횟수 : %d, 4등 횟수 : %d, 5등 횟수 : %d\n",correctRank[0],correctRank[1],correctRank[2],correctRank[3],correctRank[4]);
		
		
	}
	
	public ArrayList<Integer> randomLottoNum() {
		
		
		
		HashSet<Integer> arr = new HashSet<Integer>();
		
		while(arr.size() < 6) {
			int len = arr.size();
			int n = r.nextInt(1,45);
			arr.add(n);
			
			
		}
		
		
		ArrayList<Integer> arrList = new ArrayList<Integer>(arr);
		
		Collections.sort(arrList);
		
		
		
		return arrList;
	}
	
	public int bonusNum(ArrayList<Integer> arrList) {
		HashSet<Integer> arr = new HashSet<Integer>(arrList);
		int n2 =0;
		while(arr.size() < 7) {
			n2 = r.nextInt(1,45);
			arr.add(n2);
		}
		return n2;
	}
	
	public int[] isSame(ArrayList<Integer> lottoNum, ArrayList<Integer> myNum, int bonusnum) {
		int correctNum = 0;
		int bonusCorrect = 0;
		for(int i = 0; i < lottoNum.size(); i++) {
			for(int j = 0; j < lottoNum.size(); j++) {
				
				if(lottoNum.get(i) == myNum.get(j)) correctNum++;
				else if(bonusnum == myNum.get(j)) bonusCorrect = 1;
			}
		}
		int[] arr = {correctNum,bonusCorrect};
		return arr;
	}

}
