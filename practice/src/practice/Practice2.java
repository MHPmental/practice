package practice;

import java.util.*;

public class Practice2 {
	public void practice2_1() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		if(a>b) System.out.println(">");
		else if(a<b) System.out.println("<");
		else System.out.println("==");
	}
	public void practice2_2() {
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();
		if(a<=100&a>=90)System.out.println("A");
		else if(a<90&a>=80)System.out.println("B");
		else if(a<80&a>=70)System.out.println("C");
		else if(a<70&a>=60)System.out.println("D");
		else System.out.println("F");
	}
	public void practice2_3() {
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();
		if(a%400==0) System.out.println(1);
		else if(a%100==0)System.out.println(0);
		else if(a%4==0)System.out.println(1);
		else System.out.println(0);
	}
	public void practice2_4() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		if(a>0&b>0) System.out.println(1);
		else if(a<0&b>0) System.out.println(2);
		else if(a<0&b<0) System.out.println(3);
		else System.out.println(4);
	}
	public void practice2_5() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		if(b<45) {
			if(a==0) {
				a=23;
			}else {
				a--;
			}
			b+=15;
		}else {
			b=b-45;
		}
		System.out.println(a+" "+b);
	}
}
