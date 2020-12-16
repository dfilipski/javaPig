package javaPig;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[]{0, 0};
        int tempScore = 0;
        int turn = 0;

        System.out.println("Welcome to pig!");
        while (!isOver(score)) {
            System.out.printf("Player 1 Score: %d\nPlayer 2 Score: %d\n", score[0], score[1]);
            System.out.print("Either [r]oll or [h]old: ");
            char c = sc.nextLine().charAt(0);
            if (c == 'h' || c == 'H') {
                score[turn%2] += tempScore;
                tempScore = 0;
                ++turn;
                System.out.printf("It is now player %d's turn.\n", turn % 2 + 1);
            } else if (c != 'r' && c != 'R')
                System.out.println("Please enter r or h");
            else {
                int roll = (int) (Math.random()*5)+1;
                tempScore += roll;
                System.out.printf("You rolled a %d.\n", roll);
                if (roll == 1) {
                    tempScore = 0;
                    System.out.printf("Your turn is now over. You do not earn any points. ");
                    ++turn;
                    System.out.printf("Player 1 Score: %d\nPlayer 2 Score: %d\n", score[0], score[1]);
                    System.out.printf("It is now player %d's turn.\n", turn % 2 + 1);
                }
            }
        }

        System.out.printf("The game is over.\nPlayer %d has won.", (turn - 1 ) % 2 + 1);
    }

    static boolean isOver(int[] score) {
        return score[0] == 100 || score[1] == 100;
    }
}
