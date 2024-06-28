package com.github.chessvalidatorsystem.models;

import com.github.chessvalidatorsystem.pieces.ChessPiece;

public class Cell {
	// Private instance variables
	private int row;
	private int col;
	private ChessPiece piece;
	private boolean isOccupied;
	
	// Constructor
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		this.piece = null;
		this.isOccupied = false;
	}
	
	// Public getters
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public ChessPiece getPiece() {
		return piece;
	}
	
	public void setPiece(ChessPiece piece) {
		this.piece = piece;
	}
	
	public boolean isOccupied() {
		return isOccupied;
	}
	
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	// toString() method
	public String toString() {
		return piece == null ? "--" : piece.toString(); 
	}

}
