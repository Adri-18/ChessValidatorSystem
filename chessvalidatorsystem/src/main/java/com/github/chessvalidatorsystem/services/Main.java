package com.github.chessvalidatorsystem.services;

import com.github.chessvalidatorsystem.models.*;
import com.github.chessvalidatorsystem.pieces.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		BoardInitializer initializer = new BoardInitializer();
		BoardPrinter print = new BoardPrinter();
		
		initializer.newBoard(chessBoard);
		print.printBoard(chessBoard);
		
		Scanner in = new Scanner(System.in);
		
		boolean close = false;
		
		while (!close) {
			// User inputs either positions or exit
			String input = in.nextLine();

			// Exit case
			if (input.equalsIgnoreCase("exit")) {
				close = true;
				break;
			}
			
			// Split input of positions into current and target position
			String[] positions = input.split(" ");
			
			String currentPos = positions[0];
			String targetPos = positions[1];
			
			// Turn inputs into coordinates
			int[] currentPositions = chessBoard.convertPosition(currentPos);
			int[] targetPositions = chessBoard.convertPosition(targetPos);
			
			int currentRow = currentPositions[0];
			int currentCol = currentPositions[1];
			int targetRow = targetPositions[0];
			int targetCol = targetPositions[1];
			
			// Moving pieces
			Cell cell = chessBoard.getCell(currentRow, currentCol);
			ChessPiece piece = cell.getPiece();
				
			if (piece != null) {
				// Update board to ChessPieces 
				chessBoard.cells[currentRow][currentCol].getPiece().updateBoard(chessBoard);
					
				// Check for valid step
				if (piece.isValidMove(targetRow, targetCol)) {
					chessBoard.movePieces(currentRow, currentCol, targetRow, targetCol);
					
					// Print the updated board after every move
					print.printBoard(chessBoard);
					
				} else {
					System.out.println("Invalid move");
				}
				
			} else {
				System.out.println("Invalid move");
			}
					
		}
		
		in.close();
		
	}

}
