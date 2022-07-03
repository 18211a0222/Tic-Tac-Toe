package com.monocept.model;

import java.util.Scanner;

public class TicTacToe {
	public static void PrintGrid(char[][] Grid) {
		String[] arr = { " " + Grid[0][0] + " " + "| " + Grid[0][1] + " |" + " " + Grid[0][2] + " ", "-----------",
				" " + Grid[1][0] + " " + "| " + Grid[1][1] + " |" + " " + Grid[1][2] + " ", "-----------",
				" " + Grid[2][0] + " " + "| " + Grid[2][1] + " |" + " " + Grid[2][2] + " " };
		for (int j = 0; j < 5; j++) {
			System.out.println(arr[j]);
		}
	}

	public static void main(String[] args) {
		int i, j, flag = 0, temp = 0, count = 0;
		char Currentplayer = 'X';
		char[][] Grid = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		int[][] row = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
		int[][] col = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
		int[][] diagonal = { { 0, 0 }, { 0, 0 } };
		Scanner sc = new Scanner(System.in);
		while (count < 9) {
			System.out.print("Player '" + Currentplayer + "', enter your move (row[1-3] column[1-3]): ");
			i = sc.nextInt() - 1;
			j = sc.nextInt() - 1;
			if (Grid[i][j] == ' ') {
				Grid[i][j] = Currentplayer;
				PrintGrid(Grid);
				row[i][flag] += 1;
				col[j][flag] += 1;
				if ((i + j) % 2 == 0) {
					if (i == 1) {
						diagonal[0][flag] += 1;
						diagonal[1][flag] += 1;
						temp = Math.max(diagonal[0][flag], diagonal[1][flag]);
					} else if ((i + j) == 2) {
						diagonal[0][flag] += 1;
						temp = diagonal[0][flag];
					} else {
						diagonal[1][flag] += 1;
						temp = diagonal[1][flag];
					}
				}

				if (row[i][flag] == 3 || col[j][flag] == 3 || temp == 3) {
					System.out.println("Player '" + Currentplayer + "' won!");
					break;
				}
				if (flag == 0) {
					flag = 1;
					Currentplayer = 'O';
				} else {
					Currentplayer = 'X';
					flag = 0;
				}
				count += 1;
			} else {
				System.out.println("This move at (" + (i + 1) + "," + (j + 1) + ") is not valid. Try again...");
			}
		}
		if (count == 9)
			System.out.println("\nMatch Draw");
	}

}
