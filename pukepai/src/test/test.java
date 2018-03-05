package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import users.users;

public class test {

	public void fapai (users user) {
		int a=0;
		int b=0;
		while(true) {
			
		 a=(int) (Math.random()*100);
		if(0<a&&a<53) {
			break;	
		}				
		}
		while(true) {
			
			 b=(int) (Math.random()*100);
			if(0<b&&b<53) {
				break;	
			}				
			}
		List<Integer> list=new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		user.setShoupai(list);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-----game start-----");
		System.out.println("-----please input first username-----");
		Scanner sc=new Scanner(System.in);
		String username=sc.nextLine();
		System.out.println("username is "+username);
		System.out.println("-----input first userId-----");
		String userID=sc.nextLine();
		System.out.println("userID is "+userID);
		
		System.out.println("-----please input first username-----");
		Scanner sc2=new Scanner(System.in);
		String username2=sc.nextLine();
		System.out.println("username is "+username);
		System.out.println("-----input first userId-----");
		String userID2=sc.nextLine();
		System.out.println("userID is "+userID);
		users user1=new users();
		users user2=new users();
		user1.setUserID(userID);
		user1.setUsername(username);
		user2.setUserID(userID2);
		user2.setUsername(username2);
		System.out.println("-----start put new number-----");
		test a=new test();
		a.fapai(user1);
		a.fapai(user2);
		System.out.println("-----"+user1.getUsername()+" get numbers "+user1.getShoupai().get(0)+" "+user1.getShoupai().get(1));
		System.out.println("-----"+user2.getUsername()+" get numbers "+user2.getShoupai().get(0)+" "+user2.getShoupai().get(1));
		
		int user1num=Math.max(user1.getShoupai().get(0), user1.getShoupai().get(1));
		int user2num=Math.max(user2.getShoupai().get(0), user2.getShoupai().get(1));
		if(user1num>user2num) {
			System.out.println(user1.getUsername()+" is winner");
		}else if(user1num==user2num) {
			System.out.println(user2.getUsername()+" is winner");
		}else {
			System.out.println("nobody is winner");
		}
		
		System.out.println("see you next time!");
	}

}
