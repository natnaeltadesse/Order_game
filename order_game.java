package com.OrderGame;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean WinCheck(int score,int order){
        return score == 4 && order == 4;
    }
    public static boolean CheckIfValid(char a,char b, char c, char d){
        return a != b && a != c && a != d && b != c && b != d && c != d;
    }
    public static int Score(char[] num, char[] guess){


        int counter1= 0;
        for(int i=0;i<4;i++){
            if(guess[i]==num[0] || guess[i]==num[1] || guess[i]==num[2] || guess[i]==num[3]){
                counter1++;

            }
        }
        return counter1;
    }
    public static int Order(char[] num,char[] gues){
        int counter2=0;
        for(int i=0;i<4;i++){
            if(num[i]==gues[i]){
                counter2++;
            }
        }
        return counter2;
    }

    public static void main(String[] args) {
	// write your code here
        //System.out.println("\033[0;97m");
        String name =JOptionPane.showInputDialog("Enter your name please");
        JOptionPane.showMessageDialog(null,"Hay "+name+" welcome to order game\n"+"\t\t             " +
                "   Game roles \n  -> Your not allowed to enter more than 4 digits.\n" +
                "  -> You are not allowed to repeat one number.\n"+
                "  -> Inorder to win you have to get order 4");
        System.out.println("\t Hay "+name+" welcome to order game");
        int score,order,counter=0;
        boolean check;
        String sguess;
        char[] guess=new char[4];
        Scanner input =new Scanner(System.in);
        char[] num0=new char[]{ '0','1','2','3','4','5','6','7','8','9'};
        char[] num1=new char[]{ '9','8','7','6','5','4','3','2','1','0'};
        char[] num2=new char[]{ '8','6','4','2','0','1','3','5','7','9'};
        char[] num3=new char[]{ '1','9','8','7','0','2','3','4','5','6'};
        boolean nn;
        int n0;
        int n1;
        int n2;
        int n3;
        Random random=new Random();
        char[] number=new char[4];
        do {
            n0 = random.nextInt(9);
            n1 = random.nextInt(9);
            n2 = random.nextInt(9);
            n3 = random.nextInt(9);
            number[0] = num0[n0];
            number[1] = num1[n1];
            number[2] = num2[n2];
            number[3] = num3[n3];
            nn = CheckIfValid(number[0], number[1], number[2], number[3]);
        /* System.out.print(number[0]);
            System.out.print(number[1]);
            System.out.print(number[2]);
            System.out.println(number[3]);
            System.out.println(nn);*/
        }while (!nn);
        //Converting string to character
    do {

        System.out.print("Please enter your guess: ");
        do {
                do{
                sguess = input.nextLine();
                if(sguess.equals("show")){
                    int o = random.nextInt(0,3);
                    switch (o){
                        case 0:
                            System.out.print(number[o]+"---");
                        break;
                        case 1:
                            System.out.print("-"+number[o]+"--");
                            break;
                        case 2:
                            System.out.print("--"+number[o]+"-");
                            break;
                        case 3:
                            System.out.print("---"+number[o]);
                            break;

                    }




                }
        if(sguess.length()!=4) {
            System.out.print("\033[0;31mYou have entered wrong input. Please reenter your guess correctly:\033[0m");
        }

        }while(sguess.length()!=4);

            for (int i = 0; i < 4; i++) guess[i] = sguess.charAt(i);


            if (!CheckIfValid(guess[0], guess[1], guess[2], guess[3])) {
                System.out.print("\033[0;31mYou have entered repeated input.\033[0m");
                check = false;

            } else {
                check = true;
                counter++;
            }
        } while (!check);
        order = Order(number, guess);
        score = Score(number, guess);
        System.out.println("\tTrial: "+counter+" result");
        System.out.println("===============================");
        System.out.println("\tNO\t\tSCORE\t\tORDER ||");
        System.out.println("\t"+guess[0]+guess[1]+guess[2]+guess[3]+"\t  "+score+"\t\t      "+order+"   ||");
        System.out.println("==============================");

    }while(!WinCheck(score, order));
    if(WinCheck(score, order)) {
        input.close();
        JOptionPane.showMessageDialog(null,"\tOverall game result\n"+"Number of trials: "+counter);
        System.out.println("\tYOU WIN!!!");
    }
    }


}
