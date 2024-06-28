package com.github.chessvalidatorsystem.pieces;

import com.github.chessvalidatorsystem.models.Color;

public class Queen extends ChessPiece {

	public Queen(Color color, int row, int col) {
		super("Queen", color, row, col);
		
	}
	
	@Override
	public boolean isValidMove(int targetRow, int targetCol) {
		// Vertical move
		if (targetCol == this.getCol()) {
			if (isValidVertical(targetRow, targetCol)) {
				if (isValidCell(targetRow, targetCol)) {
					return true;
				}
			}
		}
		
		// Horizontal move
		if (targetRow == this.getRow()) {
			if (isValidHorizontal(targetRow, targetCol)) {
				if (isValidCell(targetRow, targetCol)) {
					return true;
				}
			}
		}
		
		// Diagonal move
		if (Math.abs(targetRow - this.getRow()) / Math.abs(targetCol - this.getCol()) == 1) {
			if (isValidDiagonal(targetRow, targetCol)) {
				if (isValidCell(targetRow, targetCol)) {
					return true;
				}
			}
		}
		
		return false;
	}
	

}
