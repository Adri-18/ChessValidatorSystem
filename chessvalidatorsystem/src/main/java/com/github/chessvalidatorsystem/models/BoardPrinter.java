package com.github.chessvalidatorsystem.models;

public class BoardPrinter {
	
	// Print the board
	public void printBoard(ChessBoard board) {
		for (int row = ChessBoard.ROWS - 1; row >= 0; row--) {
			for (int col = 0; col <= ChessBoard.COLS - 1; col++) {
				System.out.print(board.getCell(row,col) + " ");
			}
			
			
			System.out.println();
		}
	}

}
