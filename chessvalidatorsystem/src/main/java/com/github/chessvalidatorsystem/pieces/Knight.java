package com.github.chessvalidatorsystem.pieces;

import com.github.chessvalidatorsystem.models.Color;

public class Knight extends ChessPiece {

	public Knight(Color color, int row, int col) {
		super("Knight", color, row, col);
	}
	
	@Override
	public boolean isValidMove(int targetRow, int targetCol) {
		// Two vertical, one horizontal move
		if (Math.abs(targetRow - this.getRow()) == 2 && Math.abs(targetCol - this.getCol()) == 1
				// Two horizontal, one vertical move
				|| Math.abs(targetRow - this.getRow()) == 1 && Math.abs(targetCol - this.getCol()) == 2) {
			
			if (isValidCell(targetRow, targetCol)) {
				return true;
			}

		}
		
		return false;
	}

}
