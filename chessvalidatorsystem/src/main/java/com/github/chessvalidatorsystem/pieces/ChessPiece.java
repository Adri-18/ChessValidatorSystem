package com.github.chessvalidatorsystem.pieces;

import com.github.chessvalidatorsystem.models.*;

public abstract class ChessPiece {
	// Private instance variables
	private String type;
	private Color color;
	private int row;
	private int col;
	private ChessBoard board;
	
	// Constructor (with type)
	public ChessPiece (String type, Color color, int row, int col) {
		this.type = type;
		this.color = color;
		this.row = row;
		this.col = col;
	}
	
	// Constructor (without type)
	public ChessPiece(Color color, int row, int col) {
		this.color = color;
		this.row = row;
		this.col = col;
	}
	
	// Public getters and setters	
	public Color getColor() {
		return color;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setRow(int targetRow) {
		this.row = targetRow;
	}
	
	public void setCol(int targetCol) {
		this.col = targetCol;
	}
	
	public void updateBoard(ChessBoard chessBoard) {
		this.board = chessBoard;
	}
	
	// Methods for validating moves 
	// Main movement validation
	public abstract boolean isValidMove(int newRow, int newCol); 
	
	
	// Part of checking if piece is valid move
	public ChessPiece getHittingPiece(int targetRow, int targetCol) {
	
		Cell targetCell = board.cells[targetRow][targetCol];			
			
		if (targetCell.getPiece() != null) {
			return targetCell.getPiece();
		}
		
		return null;
	}
		
	// Blocking by team, or eating the opponent
	public boolean isValidCell(int targetRow, int targetCol) {
			
		ChessPiece hittingPiece = getHittingPiece(targetRow, targetCol);
			
		if (hittingPiece == null) { // This cell is VACANT
			return true;
		}
		else { // This cell is OCCUPIED
			if (!hittingPiece.getColor().equals(this.getColor())) { // If color is opposing, allow to be captured
				return true;
			}
			else {
				hittingPiece = null;
			}
		}
	
		return false; 
			
	}
	
	// Check for horizontal (blocking), between current position and target position
	// Used by: Rook, Queen, King 
	public boolean isValidHorizontal(int targetRow, int targetCol) {
		
		// Right
		if (targetCol > this.getCol()) {
			for (int col = this.getCol() + 1; col < targetCol; col++) {
				ChessPiece piece = board.getCell(targetRow, col).getPiece();
				
				if (piece != null) {
					return false;
				}
			}
		}
		
		// Left
		if (targetCol < this.getCol()) {
			for (int col = this.getCol() - 1; col > targetCol; col--) {
				ChessPiece piece = board.getCell(targetRow, col).getPiece();
				
				if (piece != null) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// Check for vertical (blocking), between current position and target position
	// Used by: Rook, Queen, King
	// Not necessary for Pawn, as Pawn already has its own vertical validation
	public boolean isValidVertical(int targetRow, int targetCol) {
		
		// Upwards
		if (targetRow > this.getRow()) {
			for (int row = this.getRow() + 1; row < targetRow; row++) {
				ChessPiece piece = board.getCell(row, targetCol).getPiece();
				
				if (piece != null) {
					return false;
				}
			}
		}
		
		// Downwards
		if (targetRow < this.getRow()) {
			for (int row = this.getRow() - 1; row > targetRow; row--) {
				ChessPiece piece = board.getCell(row, targetCol).getPiece();
				
				if (piece != null) {
					return false;
				}
			}
		}
		return true;
	}
	
	// Check the path of piece (Blocking), between current position and target position (Diagonal)
	// Applicable to King, Bishop, Queen
	public boolean isValidDiagonal(int targetRow, int targetCol) {
		int row = this.getRow();
		int col = this.getCol();
		
		// X-axis increase, Y-axis increase (moving up-right)
	    if (targetRow > row && targetCol > col) {
	        while (row < targetRow - 1 && col < targetCol - 1) {
	            row++;
	            col++;
	            ChessPiece piece = board.getCell(row, col).getPiece();
	            if (piece != null) {
	                return false;
	            }
	        }
	    }
	    
	 // X-axis decrease, Y-axis decrease (moving down-left)
	    if (targetRow < row && targetCol < col) {
	        while (row > targetRow + 1 && col > targetCol + 1) {
	            row--;
	            col--;
	            ChessPiece piece = board.getCell(row, col).getPiece();
	            if (piece != null) {
	                return false;
	            }
	        }
	    }
	    
	    // X-axis decrease, Y-axis increase (moving up-left)
	    if (targetRow > row && targetCol < col) {
	        while (row < targetRow - 1 && col > targetCol + 1) {
	            row++;
	            col--;
	            ChessPiece piece = board.getCell(row, col).getPiece();
	            if (piece != null) {
	                return false;
	            }
	        }
	    }
	    
	    // X-axis increase, Y-axis decrease (moving down-right)
	    if (targetRow < row && targetCol > col) {
	        while (row > targetRow + 1 && col < targetCol - 1) {
	            row--;
	            col++;
	            ChessPiece piece = board.getCell(row, col).getPiece();
	            if (piece != null) {
	                return false;
	            }
	        }
	    }
	    
	    return true;
	    
	}
	
	// toString method (includes special case of Knight as N)
	public String toString() {
		String pieceType = type.equals("Knight") ? "N" : String.valueOf(type.charAt(0));
		return (color.equals(Color.WHITE) ? "W" : "B") + pieceType;
	}

}
