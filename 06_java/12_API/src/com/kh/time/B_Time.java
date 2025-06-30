package com.kh.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class B_Time {
	
	/*
	 * java.time 패키지
	 * - Date와 Calender의 단점을 개선한 새로운 클래스들을 제공 (JDK 1.8)
	 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스 포함
	 * - 날짜와 시간에 대한 다양한 메서드 제공
	 * 
	 * */
	
	/*
	 * LocalDateTime
	 * - 날짜와 시간 정보 모두 저장
	 * */
	public void method1() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("today : " + now);
		
		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2025, 6, 30, 12, 8, 10);
		System.out.println("when : " + when);
		
		// ZonedDateTime : LocalDateTime + 시간대
		System.out.println("ZonedDateTime : " + ZonedDateTime.now());
		
		// 년, 월, 일, 요일, 시, 분, 초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonthValue() + "월");
		System.out.println(now.getDayOfMonth() + "일");
		System.out.println(now.getDayOfWeek());
		System.out.println(now.getHour() + "시");
		System.out.println(now.getMinute() + "분");
		System.out.println(now.getSecond() + "초");
		
		// 날짜 조작
		LocalDateTime plusDay = now.plusDays(1).plusMonths(2).plusYears(1);
		System.out.println("plus : " + plusDay);
		
		LocalDateTime minusDay = now.minusYears(1).minusMonths(1).minusDays(5);
		System.out.println("minus : " + minusDay);
		
		LocalDateTime withDay = now.withYear(2026).withMonth(8).withDayOfMonth(15);
		System.out.println("with : " + withDay);
		
		System.out.println("isAfter : " + now.isAfter(withDay)); // 오늘이 해당 날짜보다 이후인가?
		System.out.println("isBefore : " + now.isBefore(withDay)); // 오늘이 해당 날짜보다 이전인가?
		
		// LocalDate : 날짜 정보 저장
		LocalDate localdate = LocalDate.now();
		System.out.println("LocalDate : " + localdate);
		localdate = LocalDate.of(2025, 12, 16);
		System.out.println("LocalDate 2 : " + localdate);
		
		// LocalTime : 시간 정보 저장
		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime : " + localTime);
		localTime = LocalTime.of(17, 49, 59);
		System.out.println("LocalTime 2 : " + localTime);
		
		
	}
	
	/*
	 * Period와 Duration
	 * - 날짜와 시간 간격을 표현하기 위한 클래스
	 * - Period : 두 날짜 간의 차이
	 * - Duration : 시간의 차이
	 * 
	 * */
	public void method2() {
		LocalDate date1 = LocalDate.of(2025, 1, 1);
		LocalDate date2 = LocalDate.of(2026, 12, 31);
		
		Period pe = Period.between(date1, date2);
		System.out.println("pe : " + pe);
		
		System.out.println("year : " + pe.getYears());
		System.out.println("month : " + pe.getMonths());
		System.out.println("day : " + pe.getDays());
		
		System.out.println("year : " + pe.get(ChronoUnit.YEARS));
		System.out.println("month : " + pe.get(ChronoUnit.MONTHS));
		System.out.println("day : " + pe.get(ChronoUnit.DAYS));
		
		LocalTime time1 = LocalTime.of(1, 2, 3);
		LocalTime time2 = LocalTime.of(11, 59, 59);
		Duration du = Duration.between(time1, time2);
		
		System.out.println(du);
		
		System.out.println("hour : " + du.toHours());
		System.out.println("minute : " + du.toMinutes());
		System.out.println("second : " + du.toSeconds());
		
		// 문자열을 LocalDate 객체로 파싱
		LocalDate date = LocalDate.parse("2025-12-16");
		System.out.println(date);
		
		// DateTimeFormmatter
		// 날짜와 시간을 포맷팅(formatting)된 문자열로 변환하는 메서드를 제고하는 클래스
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime today = LocalDateTime.now();
		String format = today.format(dtf);
		System.out.println(format);
		
		
		
		
	}
	
	/*
	 * D-Day 계산기 : 년월일(각각 입력 )을 입력하여 디데이 계산
	 * ChronoUnit.Days.between(날짜, 날짜)
	 * 또는 날짜.unit(날짜, chronoUnit.Days)
	 * */
	
	public void method3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("년 : ");
		int year = Integer.parseInt(sc.nextLine());
		System.out.print("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.print("일 : ");
		int day = Integer.parseInt(sc.nextLine());
		
		LocalDate date = LocalDate.of(year, month, day);
		LocalDate now = LocalDate.now();
//		System.out.println(date.until(now,ChronoUnit.DAYS));
//		System.out.println(ChronoUnit.DAYS.between(date, now));
		int dDay  =(int) date.until(now,ChronoUnit.DAYS);
		System.out.println(Math.abs(dDay));
		if(dDay == 0) System.out.println("D-Day");
		else if(dDay < 0) System.out.println("D" + dDay);
		else System.out.println("D+" + dDay);
			
	}
	
	
	
	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();
//		b.method2();
		b.method3();
	}

}
