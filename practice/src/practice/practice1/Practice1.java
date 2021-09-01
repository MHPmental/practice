package practice.practice1;

import java.util.*;

public class Practice1 {
	public void practice1_1() {
		System.out.print("Hello World!");
	}
	public void practice1_2() {
		System.out.println("강한친구 대한육군");
		System.out.print("강한친구 대한육군");
	}
	public void practice1_3() {
		System.out.println("\\    /\\");
		System.out.println(" )  ( ')");
		System.out.println("(  /  )");
		System.out.println(" \\(__)|");
	}
	public void practice1_4() {
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
	}
	public void practice1_5() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a + b);
	}
	public void practice1_6() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a - b);
	}
	public void practice1_7() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a * b);
	}
	public void practice1_8() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println((double)a / b);
	}
	public void practice1_9() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
	}
	public void practice1_10() {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		System.out.println((a+b)%c);
		System.out.println(((a%c)+(b%c))%c);
		System.out.println((a*b)%c);
		System.out.println(((a%c)*(b%c))%c);
	}
	public void practice1_11() {
		Scanner sc = new Scanner(System.in);
		int a, b,c,d,e;
		a = sc.nextInt();
		b = sc.nextInt();
		e = b/100;
		d = (b - e*100)/10;
		c = b - e*100 -d*10;
		System.out.println(a*c);
		System.out.println(a*d);
		System.out.println(a*e);
		System.out.println(a * b);
	}
}
