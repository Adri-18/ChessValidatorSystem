package com.github.chessvalidatorsystem.pieces;

import com.github.chessvalidatorsystem.models.Color;

public class King extends ChessPiece {

	public King(Color color, int row, int col) {
		super("King", color, row, col);
	}
	
	@Override
	public boolean isValidMove(int targetRow, int targetCol) {
		// Horizontal
		if (Math.abs(targetCol - this.getCol()) == 1 && targetRow == this.getRow()) {
			if (isValidHorizontal(targetRow, targetCol)) {
				if (isValidCell(targetRow, targetCol)) {
					return true;
				}
			}
		}
		
		// Vertical
		if (Math.abs(targetRow - this.getRow()) == 1 && targetCol == this.getCol()) {
			if (isValidVertical(targetRow, targetCol)) {
				if (isValidCell(targetRow, targetCol)) {
					return true;
				}
			}
		}
		
		// Diagonal
		if (Math.abs(targetRow - this.getRow()) * (Math.abs(targetCol - this.getCol())) == 1) {
			if (isValidDiagonal(targetRow, targetCol)) {
				if (isValidCell(targetRow, targetCol)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	

}
