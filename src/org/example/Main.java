package org.example;


import java.util.Scanner;// подключаем сканнер

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        String First = sc.nextLine();
        String FinalResult = calc(First);
        out.println("FinalResult   "+FinalResult);
    }
    public static String calc(String input){//*******************************************************
        int num1=0;int num2=0;
        input=input.replaceAll("\\s+","");
        int operation=setOperation(input);
        String[] input1= input.split("[+*-/]");
        int b=input1.length;
        if(b!=2){
            out.println("Error-ошибка, проверьте правильность ввода: два операнда и один оператор!");
            exit(0);
        }
        int lang=romeOrArab(input1);
        if (lang==1){
            num1=Integer.parseInt(input1[0]);
            num2=Integer.parseInt(input1[1]);
            out.println("num1="+num1+" num2="+num2);
        }
        if(lang==2){
            num1=convertToArab(input1[0]);
            num2=convertToArab(input1[1]);
        }
        int result=calculation(num1,num2,operation);
        if((lang==2)&(result<1)){
            out.println("Error-в римской системе счисления нет чисел меньше единицы!");
            exit(0);
        }
        if(lang==1) input=Integer.toString(result);
        if(lang==2)input=convertToRome(result);


        return input;//****************************** возврат ответа *************************
    }
    static int romeOrArab(String[]mas){//****************************************************
        String arab="1,2,3,4,5,6,7,8,9,10";
        String rome="I,II,III,IV,V,VI,VII,VIII,IX,X";
        if(arab.contains(mas[0])&&arab.contains(mas[1])){
            return 1;//арабская система счисления
        } else if(rome.contains(mas[0])&&rome.contains(mas[1])) {
            return 2;//римская система счисления
        }else {
            out.println("Error-ошибка,введенные числа должны быть в диапазоне от 1 до 10 включительно и" +
                    " принадлежать к одной системе счисления.");
            exit(0);
        }
        return 0;
    }//******************************************************************************
    static int setOperation(String input){//***************************************************
        if(input.contains("+")) return 1;//сложение
        if (input.contains("-"))return 2;//вычитание
        if (input.contains("*")) return 3;//умножение
        if(input.contains("/"))return 4;//вычитание
        return 0;
    }//************************************************************************************
    static int convertToArab(String num){//*********************************************************
        switch (num){
            case "I":return 1;
            case "II":return 2;
            case "III":return 3;
            case "IV":return 4;
            case "V":return 5;
            case "VI":return 6;
            case "VII":return 7;
            case "VIII":return 8;
            case "IX":return 9;
            case "X":return 10;
        }
        return 0;

    }//************************************************************************
    static int calculation(int n1,int n2, int op ){//*******************************************
        switch (op){
            case 1:return n1+n2;
            case 2:return n1-n2;
            case 3:return n1*n2;
            case 4:return n1/n2;
        }
        return 0;
    }//*****************************************************************************
    static String convertToRome(int num){//**************************************************

        String res10="";String res1="";String res_fin;
        switch (num/10){
            case 0:res10="";break;
            case 1:res10="X";break;
            case 2:res10="XX";break;
            case 3:res10="XXX";break;
            case 4:res10="XL";break;
            case 5:res10="L";break;
            case 6:res10="LX";break;
            case 7:res10="LXX";break;
            case 8:res10="LXXX";break;
            case 9:res10="XC";break;
            case 10:res10="C";break;
        }
        switch (num%10){
            case 0:res1=""; break;
            case 1:res1="I";break;
            case 2:res1="II"; break;
            case 3:res1="III";break;
            case 4:res1="IV"; break;
            case 5:res1="V";break;
            case 6:res1="VI";  break;
            case 7:res1="VII";break;
            case 8:res1="VIII"; break;
            case 9:res1="IX";break;
        }
        res_fin=res10+res1;
        return res_fin;
    }//**********************************************************
}