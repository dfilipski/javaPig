package javaPig;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[]{0, 0};
        int turn = 0;

        System.out.println("Welcome to pig!");
        while (true) {
            System.out.printf("Player 1 Score: %d\nPlayer 2 Score: %d\n", score[0], score[1]);
            System.out.print("Either [r]oll or [h]old: ");
            char c = sc.nextLine().charAt(0);
            if (c == 'h' || c == 'H') {
                ++turn;
                System.out.printf("It is now player %d's turn.\n", turn % 2 + 1);
                break;
            } else if (c != 'r' && c != 'R')
                System.out.println("Please enter r or h");
            else {
                score[turn % 2] += (int) (Math.random()*5)+1;
                System.out.printf("Your score is %d.\n", score[turn % 2]);
            }

        }
    }
}
