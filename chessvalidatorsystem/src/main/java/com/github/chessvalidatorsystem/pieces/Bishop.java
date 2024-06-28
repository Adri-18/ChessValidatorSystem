package com.github.chessvalidatorsystem.pieces;

import com.github.chessvalidatorsystem.models.Color;

public class Bishop extends ChessPiece {

	public Bishop(Color color, int row, int col) {
		super("Bishop", color, row, col);
		
	}

	@Override
	public boolean isValidMove(int targetRow, int targetCol) {
		// Diagonal move
		if (Math.abs(targetRow - this.getRow()) == Math.abs(targetCol - this.getCol())) {
			if (isValidDiagonal(targetRow, targetCol)) {
				if (isValidCell(targetRow, targetCol)) {
					return true;
				}
			}
		}
		
		return false;
	}

}
