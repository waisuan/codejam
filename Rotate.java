package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Rotate {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\codejam\\A-small-practice (5).in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int innerLineNum = 0;
		int caseNum = 1;
		int length = -1;
		int neededPieces = -1;
		String[][] gameboard = null;
		String winner = null;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				if (innerLineNum == 0) {
					String[] tokens = line.split(" ");

					length = Integer.parseInt(tokens[0]);
					neededPieces = Integer.parseInt(tokens[1]);

					gameboard = new String[length][length];

					winner = null;

					innerLineNum++;
				} else {
					for (int i = 0; i < length; i++) {
						for (int j = 0; j < length; j++) {
							gameboard[i][j] = String.valueOf(line.charAt(j));
						}

						if (i + 1 != length)
							line = br.readLine();
					}

					// for (int i = 0; i < length; i++) {
					// for (int j = 0; j < length; j++) {
					// System.out.print(gameboard[i][j]);
					// }
					// System.out.println("");
					// }

					// shift to the right
					int rightMost = -1;
					for (int i = 0; i < length; i++) {
						rightMost = length - 1;
						for (int j = length - 1; j >= 0; j--) {
							if (!gameboard[i][j].equals(".")) {
								String temp = gameboard[i][j];
								gameboard[i][j] = ".";
								gameboard[i][rightMost] = temp;
								rightMost--;
							}
						}
					}

					// for (int i = 0; i < length; i++) {
					// for (int j = 0; j < length; j++) {
					// System.out.print(gameboard[i][j]);
					// }
					// System.out.println("");
					// }

					// Check for win
					for (int i = 0; i < length; i++) {
						for (int j = 0; j < length; j++) {
							if (!gameboard[i][j].equals(".")
									&& !gameboard[i][j].equals(winner)) {
								int count = 1;
								String piece = gameboard[i][j];
								boolean foundWinner = false;

								// right
								if (j + 1 != length
										&& gameboard[i][j + 1].equals(piece)) {
									for (int k = j + 1; k < length; k++) {
										if (gameboard[i][k].equals(piece))
											count++;
										else {
											break;
										}
									}

									if (count >= neededPieces) {
										if (null != winner
												&& !winner.equals(piece)) {
											winner = "Both";
											break;
										} else {
											winner = piece;
										}

										foundWinner = true;
									}
								}

								count = 1;

								// left
								if (!foundWinner) {
									if (j - 1 > 0
											&& gameboard[i][j - 1]
													.equals(piece)) {
										for (int k = j - 1; k >= 0; k--) {
											if (gameboard[i][k].equals(piece))
												count++;
											else {
												break;
											}
										}

										if (count >= neededPieces) {
											if (null != winner
													&& !winner.equals(piece)) {
												winner = "Both";
												break;
											} else {
												winner = piece;
											}

											foundWinner = true;
										}
									}
								}

								count = 1;

								// up
								if (!foundWinner) {
									if (i - 1 > 0
											&& gameboard[i - 1][j]
													.equals(piece)) {
										for (int k = i - 1; k >= 0; k--) {
											if (gameboard[k][j].equals(piece))
												count++;
											else {
												break;
											}
										}

										if (count >= neededPieces) {
											if (null != winner
													&& !winner.equals(piece)) {
												winner = "Both";
												break;
											} else {
												winner = piece;
											}

											foundWinner = true;
										}
									}
								}

								count = 1;

								// down
								if (!foundWinner) {
									if (i + 1 != length
											&& gameboard[i + 1][j]
													.equals(piece)) {
										for (int k = i + 1; k < length; k++) {
											if (gameboard[k][j].equals(piece))
												count++;
											else {
												break;
											}
										}

										if (count >= neededPieces) {
											if (null != winner
													&& !winner.equals(piece)) {
												winner = "Both";
												break;
											} else {
												winner = piece;
											}

											foundWinner = true;
										}
									}
								}

								count = 1;

								// diagonal up left
								if (!foundWinner) {
									if (i - 1 > 0
											&& j - 1 > 0
											&& gameboard[i - 1][j - 1]
													.equals(piece)) {
										for (int k = i - 1, l = j - 1; k >= 0
												&& l >= 0; k--, l--) {
											if (gameboard[k][l].equals(piece))
												count++;
											else {
												break;
											}
										}

										if (count >= neededPieces) {
											if (null != winner
													&& !winner.equals(piece)) {
												winner = "Both";
												break;
											} else {
												winner = piece;
											}

											foundWinner = true;
										}
									}
								}

								count = 1;

								// diagonal up right
								if (!foundWinner) {
									if (i - 1 > 0
											&& j + 1 != length
											&& gameboard[i - 1][j + 1]
													.equals(piece)) {
										for (int k = i - 1, l = j + 1; k >= 0
												&& l < length; k--, l++) {
											if (gameboard[k][l].equals(piece))
												count++;
											else {
												break;
											}
										}

										if (count >= neededPieces) {
											if (null != winner
													&& !winner.equals(piece)) {
												winner = "Both";
												break;
											} else {
												winner = piece;
											}

											foundWinner = true;
										}
									}
								}

								count = 1;

								// diagonal down left
								if (!foundWinner) {
									if (i + 1 != length
											&& j - 1 > 0
											&& gameboard[i + 1][j - 1]
													.equals(piece)) {
										for (int k = i + 1, l = j - 1; k < length
												&& l >= 0; k++, l--) {
											if (gameboard[k][l].equals(piece))
												count++;
											else {
												break;
											}
										}

										if (count >= neededPieces) {
											if (null != winner
													&& !winner.equals(piece)) {
												winner = "Both";
												break;
											} else {
												winner = piece;
											}

											foundWinner = true;
										}
									}
								}

								count = 1;

								// diagonal down right
								if (!foundWinner) {
									if (i + 1 != length
											&& j + 1 != length
											&& gameboard[i + 1][j + 1]
													.equals(piece)) {
										for (int k = i + 1, l = j + 1; k < length
												&& l < length; k++, l++) {
											if (gameboard[k][l].equals(piece))
												count++;
											else {
												break;
											}
										}

										if (count >= neededPieces) {
											if (null != winner
													&& !winner.equals(piece)) {
												winner = "Both";
												break;
											} else {
												winner = piece;
											}

											foundWinner = true;
										}
									}
								}
							}
						}

						if (null != winner && winner.equals("Both")) {
							break;
						}
					}

					if (null != winner)
						if (winner.equals("R")) {
							System.out.println("Case #" + caseNum++ + ": "
									+ "Red");
						} else if (winner.equals("B")) {
							System.out.println("Case #" + caseNum++ + ": "
									+ "Blue");
						} else
							System.out.println("Case #" + caseNum++ + ": "
									+ winner);
					else
						System.out.println("Case #" + caseNum++ + ": "
								+ "Neither");

					innerLineNum = 0;
				}
			}

			lineNum++;
		}

		br.close();
	}
}
