package com.hand.controller;

import com.hand.bean.Film;

import com.hand.service.FilmService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class Main {
	 static Scanner in=new Scanner(System.in);
	    static ConfigurableApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});

	    public static void main(String[] args){
	        while(true){
	            int next=welcome();
	            switch (next){
	                case 0:System.exit(0); break;

	                case 1:insertFilms();break;

	                default:
	                    System.out.println("输入错误：请重试");
	            }
	        }
	    }

	    public static int welcome(){
	        System.out.println("1.增加film");
			System.out.println("0.退出");
	        int i = in.nextInt();
	        return i;
	    }



	    public static void insertFilms(){
	        List<Film> list=new LinkedList<Film>();
	        boolean flag=true;
	        while(flag){
	           Film film=new Film();
				ac.start();
	            System.out.println("请输入电影名称:");
				film.setTitle(in.next());
	            System.out.println("请输入电影描述：");
				film.setDescription(in.next());
				System.out.println("请输入电影语言：");
				film.setLanguage_id(in.nextInt());
	            list.add(film);
	            while(true){
	                System.out.println("是否继续?:Y/N");
	                String next=in.next();
	                if("Y".equals(next)||"y".equals(next)){
	                    break;
	                }
	                else if("N".equals(next)||"n".equals(next)){
	                    flag=false;
	                    break;
	                }
	            }
	        }

	        for(Film f:list){
	            FilmService filmService=(FilmService)ac.getBean("filmService");
	            int i = filmService.addFilm(f);
	            if(i==0||i==-1){
	                list.remove(f);
	            }
	        }

	        System.out.println("本次插入的film:");
			ac.stop();
	        for (Film f:list){
	            System.out.println(f);
	        }
	    }

}
