package com.github.chessvalidatorsystem.models;

import com.github.chessvalidatorsystem.pieces.ChessPiece;

public class ChessBoard {
	// Final constants
	public static final int ROWS = 8;
	public static final int COLS = 8;
	
	// Private instance variable
	public Cell[][] cells;
	
	// Constructor (creating a new chess board)
	public ChessBoard() {
		cells = new Cell[ROWS][COLS];
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				cells[row][col] = new Cell(row + 1, col + 1);
			}
		}
	}
	
	// Public getters and setters
	public Cell getCell(int row, int col) {
		return cells[row][col];
	}
	
	public Cell[][] getBoardCells() {
		return cells;
	}

	public void setPiece(ChessPiece piece) {
		cells[piece.getRow()][piece.getCol()].setPiece(piece);		
	}
	
	// Convert letters to numbers
	private int letterToNumber(char letter) {
		return letter - 'a';
	}
	
	// Converting chess notation (example: e6) to array indices
	public int[] convertPosition(String position) {
		int col = letterToNumber(position.charAt(0));
		int row = Character.getNumericValue(position.charAt(1) - 1);
		
		return new int[] {row,col};
	}
	
	// Method for moving piece
	public void movePieces(int currentRow, int currentCol, int targetRow, int targetCol) {
		ChessPiece piece = cells[currentRow][currentCol].getPiece();
		
		if (piece != null) {
			cells[targetRow][targetCol].setPiece(piece);
			cells[currentRow][currentCol].setPiece(null);
			
			piece.setRow(targetRow);
			piece.setCol(targetCol);
		}
	}

}
