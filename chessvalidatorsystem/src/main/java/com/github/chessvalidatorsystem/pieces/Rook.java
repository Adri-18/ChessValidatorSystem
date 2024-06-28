package com.github.chessvalidatorsystem.pieces;

import com.github.chessvalidatorsystem.models.Color;

public class Rook extends ChessPiece {

	public Rook(Color color, int row, int col) {
		super("Rook", color, row, col);
		
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
		return false;
	}

}
