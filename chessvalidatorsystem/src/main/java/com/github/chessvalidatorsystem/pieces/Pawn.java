package com.github.chessvalidatorsystem.pieces;

import com.github.chessvalidatorsystem.models.Color;

public class Pawn extends ChessPiece {

	public Pawn(Color color, int row, int col) {
		super("Pawn", color, row, col);
		
	}
	
	@Override
	public boolean isValidMove(int targetRow, int targetCol) {
		// Initial two step move
		if (this.getRow() == 1 || this.getRow() == 6) {
			if (Math.abs(targetRow - this.getRow()) == 2) {
				if (isValidVertical(targetRow, targetCol)) {
					return true;
				}
			}
		}
		
		// Default one step move (WHITE)
		if (this.getColor().equals(Color.WHITE)) {
			if (targetRow == this.getRow() + 1 && targetCol == this.getCol()) {
				if (getHittingPiece(targetRow, targetCol) == null) {
					return true;
				}
			}
		}
		
		// Default one step move (BLACK)
		if (this.getColor().equals(Color.BLACK)) {
			if (targetRow == this.getRow() - 1 && targetCol == this.getCol()) {
				if (getHittingPiece(targetRow, targetCol) == null) {
					return true;
				}
			}
		}
		
		// Diagonal one step move
		if (isValidCell(targetRow, targetCol)) {
			if (Math.abs(targetRow - this.getRow()) == 1 && Math.abs(targetCol - this.getCol()) == 1) {
				return true;
			}
		}
		
		return false;
	}

}
