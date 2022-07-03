# Tic-Tac-Toe
line 19 int[][] row = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
There are three arrays with two elements in it, the number of arrays = n or num. of rows in the grid (where n is the size of grid)
the first element in the array represents the number of 'X' present in that row
the second element in the array represents the number of 'O' present in that row, similarly with column array
the diagonal array will be the same as two diagonals will be present.
any row or column or diagonal has an element with 'n' value in it means that one of 'X' or 'O' was able to complete the game

For a grid of 3 X 3, the 2d array with indexes will look like this
00  01 02
10  11 12
20  21 22, the diagonal with elements 00,11,22 have i = j
the diagonal with elements 02,11,20 have i + j = n -1 (where n is the size of the grid i.e., n = 3 here i + j will be equal to 2)
no other elements in the 2d array will have i = j or i + j = n - 1 property other than the diagonal elements
hence if a 'X' or 'O' is placed on the diagonal, the count of that can be uniquely maintained.

this is same for all grid sizes, consider a grid 5 X 5, the 2d array with 0 based indexing will look like this
00 01 02 03 04
10 11 12 13 14
20 21 22 23 24
30 31 32 33 34
40 41 42 44 44 , one diagonal has elements with i = j
and the other diagonal has element i + j = 4 ( 5 - 1 ) and all the elements indexes sum (i + j) in both the diagonals are divisible by 2 for odd number grid
hence i used, line 36. if ((i + j) % 2 == 0)
here the element which is present in both diagonals is 22, whereas in 3 X 3 grid the element is 11.
line 37 if (i == 1 && j == 1) if it is 5 X 5 grid replace the 1 with 2 as it is present in both diagonals and count of 'X' or 'O' in both diagonal arrays is updated
line 41 else if ((i + j) == 2) for grid 3 X 3 the n - 1 is 2, so the sum of i + j == 2. for 5 X 5 the n - 1 is 4, need to replace i + j == 4
this take cares of elements like 40,31,13,04 only these elements add upto n-1 in the grid.
rest all elements like 00,11,22,33,44 has the property of i = j, hence the elements like 02,20,24,42 are not treated as diagonal elements even the sum is divsible by 2
line 44 else if(i == j) is responsible for the other diagonal elements mentioned above.

for a grid of even number like 4 X 4, there woudln't be any middle element present in both diagonals, the grid will look like
00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33, here not all elements indexes sum is divisble by 2. But the property i = j and i + j = n - 1 still stands
Hence here only i + j = 3 for elements like 30,21,12,03 is used
and i = j for elements like 00,11,22,33 is used for the diagonal arrays, the sum divisible by 2 and the middle element cases are not present here. 

line 51 if (row[i][flag] == 3 || col[j][flag] == 3 || temp == 3)
the win condition will be the size of the grid i.e.., n here n = 3.
 
line 26 while (count < 9)
the game end condition will be n * n (where n is the size of the grid), here 3 * 3 = 9.
