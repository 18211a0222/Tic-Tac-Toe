package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.TicTacToeGrid;

public class TicTacToeTest {

	public static void main(String[] args) {

		int i, j;
		Scanner sc = new Scanner(System.in);
		TicTacToeGrid player = new TicTacToeGrid();
		System.out.println("Game Rules\r\n" + "\r\n"
				+ "Traditionally the first player plays with \"X\". So you can decide who wants to go \"X\" and who wants go with \"O\". \r\n"
				+ "Only one player can play at a time.\r\n"
				+ "If any of the players have filled a square then the other player and the same player cannot override that square.\r\n"
				+ "There are only two conditions that may be match will be draw or may be win.\r\n"
				+ "The player that succeeds in placing three respective mark (X or O) in a horizontal, vertical or diagonal row wins the game.");

		while (player.getEmptyspaces() < 9) {
			System.out.print("\nPlayer '" + player.getCurrentplayer() + "', enter your move (row[1-3] column[1-3]): ");
			i = sc.nextInt() - 1;
			j = sc.nextInt() - 1;
			player.MarkItOnGrid(i, j);
		}
		if (player.getEmptyspaces() == 9)
			System.out.println("\nMatch Draw");
	}

}
