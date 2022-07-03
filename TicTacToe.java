package com.monocept.model;

import java.util.Scanner;

public class TicTacToe {
	public static void PrintGrid(char[][] Grid) { // this method will print the grid in the format we needed
		String[] arr = { " " + Grid[0][0] + " " + "| " + Grid[0][1] + " |" + " " + Grid[0][2] + " ", "-----------",
				" " + Grid[1][0] + " " + "| " + Grid[1][1] + " |" + " " + Grid[1][2] + " ", "-----------",
				" " + Grid[2][0] + " " + "| " + Grid[2][1] + " |" + " " + Grid[2][2] + " " };
		for (int j = 0; j < 5; j++) {
			System.out.println(arr[j]);
		}
	}

	public static void main(String[] args) {
		int i, j, flag = 0, temp = 0, count = 0;
		char Currentplayer = 'X'; //starting with player 'X'
		char[][] Grid = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		int[][] row = { { 0, 0 }, { 0, 0 }, { 0, 0 } }; 
		// 3 arrays for 3 rows in the grid, the first elem in each row array is for count of 'X' in that row, the second elem is for count of 'O'
		int[][] col = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
		//similarly for columns in the grid
		int[][] diagonal = { { 0, 0 }, { 0, 0 } };
		// also for the two diagonals in the grid
		Scanner sc = new Scanner(System.in);
		while (count < 9) {
			System.out.print("Player '" + Currentplayer + "', enter your move (row[1-3] column[1-3]): ");
			i = sc.nextInt() - 1;
			j = sc.nextInt() - 1;
			if (Grid[i][j] == ' ') { // if the space is empty we can place the 'X' or 'O'
				Grid[i][j] = Currentplayer;
				PrintGrid(Grid);
				row[i][flag] += 1; // as we have placed a 'X' or 'O' we are updating the presence of that value in that specific row.
				//flag is used to increase the first or second elem based on the 'X' or 'O'
				col[j][flag] += 1; // also in the column, the flag is used to update the first or second element in the array depending on 'X' or 'O'
				if ((i + j) % 2 == 0) { // using 0 based index, the sum of diagonal coordinates are divisible by 2
					if (i == 1) { // if the position is 1 1, it is in both diagonals so we update it's value in both diagonals
						diagonal[0][flag] += 1;
						diagonal[1][flag] += 1;
						temp = Math.max(diagonal[0][flag], diagonal[1][flag]);
					} else if ((i + j) == 2) { // coordinates like 1 1, 0 2, 2 0 are on diagonal and add upto 2. consider this as first diagonal
						diagonal[0][flag] += 1;
						temp = diagonal[0][flag];
					} else { // coordinates like 0 0, 1 1, 2 2 are on the other diagonal, consider this as second diagonal
						diagonal[1][flag] += 1;
						temp = diagonal[1][flag]; // whatever value is updated is stored in temp
					}
				}

				if (row[i][flag] == 3 || col[j][flag] == 3 || temp == 3) { 
					// if any of the row or col or diagonal has reached three, then it means it has three same elements of 'X' or 'O in it.
					System.out.println("Player '" + Currentplayer + "' won!"); // then the game ends
					break;
				}
				if (flag == 0) { // for changing the current player we are using flag and also for the updating of values in the row,col and diagonal arrays
					flag = 1;
					Currentplayer = 'O';
				} else {
					Currentplayer = 'X';
					flag = 0;
				}
				count += 1; //each time we place an element the count gets increased.
			} else {
				System.out.println("This move at (" + (i + 1) + "," + (j + 1) + ") is not valid. Try again...");
			}
		}
		if (count == 9) // if the count reaches 9, then all the spaces are filled and the match is tied.
			System.out.println("\nMatch Draw");
	}

}
