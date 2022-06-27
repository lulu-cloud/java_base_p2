package com.lili.p2.util;

import java.util.Locale;
import java.util.Scanner;

public class CMUtility {
    private static String readKeyBoard(int num, boolean flag){
        String line="";
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (flag) return line;
                else continue;
            }
            if (line.length() < 1 || line.length() > num) {
                System.out.println("输入长度(不大于" + num + ")错误，请重新输入:");
                continue;
            }
            break;
        }
        return line;
    }

    private static Scanner scanner = new Scanner(System.in);
    public static char readMenuSelection(){
        char c;
        for(;;){
            String str=readKeyBoard(1,false);
            c=str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'&&c!='5'){
                System.out.println("选择错误，请重新输入：");
            }
            else break;
        }
        return c;
    }

    /*从键盘读取一个字符，并将其作为方法的返回值*/
    public static char readChar(){
        String str=readKeyBoard(1,false);
        return str.charAt(0);
    }

    public static char readChar(char defaultValue){
        String str=readKeyBoard(1,false);
        return (str.length()==0)?defaultValue:str.charAt(0);
    }

    public static int readInt(){
        int n;
        for(;;){
            String str=readKeyBoard(2,false);
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    public static int readInt(String defaultValue){
        int n;
        for(;;){
            String str=readKeyBoard(2,true);
            if(str.equals("")){
                return Integer.parseInt(defaultValue);
            }
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }

    public static String readString(int limit,String defaultValue){
        String str=readKeyBoard(limit,true);
        return str.equals("")?defaultValue:str;
    }
    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str=readKeyBoard(1,false).toUpperCase();
            c=str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            }
            else {
                System.out.println("选择错误，请重新输入:");
            }
        }
        return c;
    }
}
