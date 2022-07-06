package com.monocept.model;

import java.util.Scanner;

public class TicTacToeGrid {
	
	private char Currentplayer = 'X';
	private int flag = 0, emptyspaces = 0, temp = 0;
	private char[][] grid = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	private int[][] row = { { 0, 0 }, { 0, 0 }, { 0, 0 } }, col = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
	private int[][] diagonal = { { 0, 0 }, { 0, 0 } };

	public char getCurrentplayer() {
		return Currentplayer;
	}

	public int getFlag() {
		return flag;
	}

	public int getEmptyspaces() {
		return emptyspaces;
	}
	
	public char[][] getGrid() {
		return grid;
	}

	public int[][] getRow() {
		return row;
	}

	public int[][] getCol() {
		return col;
	}

	public int[][] getDiagonal() {
		return diagonal;
	}

	public int getTemp() {
		return temp;
	}
	
	public void setCurrentplayer(char currentplayer) {
		if (currentplayer == 'X')
			this.Currentplayer = 'O';
		else
			this.Currentplayer = 'X';
	}

	public void setFlag(int flag) {
		if (flag == 0)
			this.flag = 1;
		else
			this.flag = 0;
	}
	
	public void setEmptyspaces(int emptyspaces) {
		this.emptyspaces = emptyspaces + 1;
	}
	
	
	public void setGrid(int i, int j) {
		this.grid[i][j] = this.getCurrentplayer();
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public void increaseCount(int[][] temp, int i, int j) {
		temp[i][j] += 1;
	}
	
	public void Diagonal(int i, int j)
	{
		if(i == j)
			this.setTemp(LeftDiagonal(i, j));
		else
			this.setTemp(RightDiagonal(i, j));
	}
	
	public int LeftDiagonal(int i, int j)
	{
		if (i == 1) {
			this.increaseCount(this.getDiagonal(), 0, this.getFlag());
			this.increaseCount(this.getDiagonal(), 1, this.getFlag());
			return Math.max(this.getDiagonal()[0][this.getFlag()], this.getDiagonal()[1][this.getFlag()]);
		} 
		this.increaseCount(this.getDiagonal(), 1, this.getFlag());
		return this.getDiagonal()[1][getFlag()];
	}
	
	public int RightDiagonal(int i, int j)
	{
		if ((i + j) == 2) {
			this.increaseCount(this.getDiagonal(), 0, this.getFlag());
			return this.getDiagonal()[0][getFlag()];
		}
		return this.getTemp();
	}
	
	public void DidThePlayerWin(int i, int j, int temp)
	{	
		if (this.getRow()[i][this.getFlag()] == 3 || this.getCol()[j][this.getFlag()] == 3 || temp == 3) {
			System.out.println("\nPlayer '" + this.getCurrentplayer() + "' won!");
			this.setEmptyspaces(9); 
		}
	}
	
	public void PrintGrid(char[][] Grid) {
		System.out.println("\n " + Grid[0][0] + " " + "| " + Grid[0][1] + " |" + " " + Grid[0][2] + " ");
		System.out.println("-----------");
		System.out.println(" " + Grid[1][0] + " " + "| " + Grid[1][1] + " |" + " " + Grid[1][2] + " ");
		System.out.println("-----------");
		System.out.println(" " + Grid[2][0] + " " + "| " + Grid[2][1] + " |" + " " + Grid[2][2] + " ");
	}

	public void MarkItOnGrid(int i, int j) {
		if (this.getGrid()[i][j] == ' ')
		{
			this.setGrid(i, j);
			this.PrintGrid(this.getGrid());
			this.increaseCount(this.getRow(), i, this.getFlag());
			this.increaseCount(this.getCol(), j, this.getFlag());
			this.Diagonal(i, j);
			this.DidThePlayerWin(i, j, this.getTemp());
			this.setCurrentplayer(this.getCurrentplayer());
			this.setFlag(this.getFlag());
			this.setEmptyspaces(this.getEmptyspaces());
		} 
		else 
		{	
			System.out.println("This move at (" + (i + 1) + "," + (j + 1) + ") is not valid. Try again...");
		}
	}

}
