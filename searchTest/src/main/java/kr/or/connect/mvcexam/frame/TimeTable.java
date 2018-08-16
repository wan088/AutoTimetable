package kr.or.connect.mvcexam.frame;

import java.util.List;
import java.util.StringTokenizer;

import kr.or.connect.mvcexam.dto.gang;

public class TimeTable {
	static int[] conditionArr;
	private int[][] table;
	public TimeTable() {
		//열은 요일, 각각 월 화 수 목 금 = 0 1 2 3 4
		//행은 x교시 , *2
		this.table=new int[40][5];
		conditionArr= new int[10];
	}	
	//이미 겹치면 false 반환
	public boolean addGang(String gangTime) {
		StringTokenizer st = new StringTokenizer(gangTime, "/");
		while(st.hasMoreTokens()) {
			if(!addGangHelper(st.nextToken())) {
				return false;
			}
		}
		return true;
	}
	public boolean addGangHelper(String token) {
		int yoil=getYoil(token.charAt(0));
		if(conditionArr[yoil]==0||yoil==(-1))
			return false;
		token = token.substring(1);
		StringTokenizer st = new StringTokenizer(token, "-");
		int start= (int)(Double.parseDouble(st.nextToken())*2);
		int end= (int)(Double.parseDouble(st.nextToken())*2);
		for(int i=start ; i<end ; i++) {
			if(table[i][yoil]!=0)
				return false;
			table[i][yoil]=1;
		}
		return true;
	}
	public int getYoil(char c) {
		if(c=='월')
			return 0;
		else if(c=='화')
			return 1;
		else if(c=='수')
			return 2;
		else if(c=='목')
			return 3;
		else if(c=='금')
			return 4;
		else
			return -1;	
	}
	public boolean isFittedTable(List<gang> tmpList, int condi) {
		conditionArr[4]=condi%10; condi/=10;
		conditionArr[3]=condi%10; condi/=10;
		conditionArr[2]=condi%10; condi/=10;
		conditionArr[1]=condi%10; condi/=10;
		conditionArr[0]=condi%10;
		
		for(gang gang : tmpList) {
			if(!addGang(gang.getTimes()))
				return false;
		}
		return true;
	}
	public static void main(String args[]) {
		TimeTable tt = new TimeTable();
		gang tmpgang = new gang();
		tmpgang.setTimes("월4.0-5.5/수3.0-4.0");
		boolean sulma =tt.addGang(tmpgang.getTimes());
		System.out.println(sulma);
		int[][] table = tt.table;
		for(int i=0 ; i<40 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}

}
