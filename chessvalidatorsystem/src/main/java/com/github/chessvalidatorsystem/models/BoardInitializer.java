package com.github.chessvalidatorsystem.models;

import com.github.chessvalidatorsystem.pieces.*;

public class BoardInitializer {
	
	// Initialize new board with chess pieces on it
	public void newBoard(ChessBoard board) {
		
		// Pawn pieces
		for (int col = 0; col <= ChessBoard.COLS - 1; col++) {
			board.setPiece(new Pawn(Color.WHITE, 1, col));
			board.setPiece(new Pawn(Color.BLACK, 6, col));
		}
		
		// Rook pieces
		board.setPiece(new Rook(Color.WHITE, 0, 0));
		board.setPiece(new Rook(Color.WHITE, 0, 7));
		board.setPiece(new Rook(Color.BLACK, 7, 0));
		board.setPiece(new Rook(Color.BLACK, 7, 7));
		
		// Knight pieces
		board.setPiece(new Knight(Color.WHITE, 0, 1));
		board.setPiece(new Knight(Color.WHITE, 0, 6));
		board.setPiece(new Knight(Color.BLACK, 7, 1));
		board.setPiece(new Knight(Color.BLACK, 7, 6));
		
		// Bishop pieces
		board.setPiece(new Bishop(Color.WHITE, 0, 2));
		board.setPiece(new Bishop(Color.WHITE, 0, 5));
		board.setPiece(new Bishop(Color.BLACK, 7, 2));
		board.setPiece(new Bishop(Color.BLACK, 7, 5));
		
		// Queen pieces
		board.setPiece(new Queen(Color.WHITE, 0, 3));
		board.setPiece(new Queen(Color.BLACK, 7, 3));
		
		// King pieces
		board.setPiece(new King(Color.WHITE, 0, 4));
		board.setPiece(new King(Color.BLACK, 7, 4));
	}

}
