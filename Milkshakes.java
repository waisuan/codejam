package codejam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Milkshakes {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\PRACTiCE\\B-small-practice (1).in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int innerLineNum = 0;
		int caseNum = 1;
		int numOfFlav = 0;
		int numOfCust = 0;
		int count = 0;
		int[] flavours = null;
		int[][] cust = null;
		boolean[] satisfiedCust = null;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				if (innerLineNum == 0) {
					numOfFlav = Integer.parseInt(line);
					flavours = new int[numOfFlav];
					Arrays.fill(flavours, -1);
					innerLineNum++;
				} else if (innerLineNum == 1) {
					numOfCust = Integer.parseInt(line);
					cust = new int[numOfCust][numOfFlav];
					for (int i = 0; i < numOfCust; i++) {
						for (int a = 0; a < numOfFlav; a++) {
							cust[i][a] = -1;
						}
					}
					satisfiedCust = new boolean[numOfCust];
					Arrays.fill(satisfiedCust, false);
					innerLineNum++;
				} else {

					String[] tokens = line.split(" ");

					int numOfCustChoices = Integer.parseInt(tokens[0]);

					// System.out.println(tokens.length);
					int j = 1;
					for (int i = 0; i < numOfCustChoices; i++) {
						cust[count][Integer.parseInt(tokens[j]) - 1] = Integer
								.parseInt(tokens[j + 1]);
						j += 2;
					}

					count++;

					if (count == numOfCust) {
						boolean isPossible = true;
						for (int i = 0; i < flavours.length; i++) {
							for (int k = 0; k < numOfCust; k++) {
								if (flavours[i] == -1 && cust[k][i] != -1) {
									flavours[i] = cust[k][i];
									satisfiedCust[k] = true;
								} else if (flavours[i] != -1
										&& cust[k][i] != -1
										&& cust[k][i] != flavours[i]) {
									// resolve conflict
									// if (i + 1 < flavours.length) {
									boolean hasAlternatives = false;
									for (int m = 0; m < flavours.length; m++) {
										if (cust[k][m] != -1 && m != i) {
											cust[k][i] = -1;
											hasAlternatives = true;
											break;
										}
									}
									// for (int m = i + 1; m <
									// flavours.length; m++) {
									// if (cust[k][m] != -1) {
									// cust[k][i] = -1;
									// hasAlternatives = true;
									// break;
									// }
									// }

									if (!hasAlternatives) {

										// look at the last customer that
										// updated the value and trace back from
										// there...

										// for (int m = 0; m < k; m++) {
										// if (flavours[i] == cust[m][i]) {
										// for (int n = i + 1; n <
										// flavours.length; n++) {
										// if (cust[m][n] != -1) {
										// flavours[i] = cust[k][i];
										// hasAlternatives = true;
										// cust[m][i] = -1;
										// break;
										// }
										// }
										// }
										//
										// if (hasAlternatives) {
										// break;
										// }
										// }
										//
										// if (!hasAlternatives) {
										// System.out.println("k " + k
										// + " i " + i + " "
										// + cust[k][i]);
										// isPossible = false;
										// break;
										// }

										// if (!satisfiedCust[k]) {
										// if (satisfiedCust[k - 1]) {
										// boolean ok = false;
										// for (int l = 0; l < numOfFlav;
										// l++) {
										// if (cust[k - 1][l] != -1
										// && l != i) {
										// ok = true;
										// break;
										// }
										// }
										//
										// if (!ok) {
										// isPossible = false;
										// break;
										// } else {
										// flavours[i] = cust[k][i];
										// satisfiedCust[k] = true;
										// satisfiedCust[k - 1] = false;
										// cust[k - 1][i] = -1;
										// }
										// } else {
										// // System.out.println("k " +
										// // k
										// // + " i " + i);
										// // isPossible = false;
										// // break;
										// }
										// }

										// hasAlternatives = false;
										// for (int m = i + 1; m <
										// flavours.length; m++) {
										// if (cust[k - 1][m] != -1) {
										// flavours[i] = cust[k][i];
										// hasAlternatives = true;
										// satisfiedCust[k - 1] = false;
										// cust[k - 1][i] = -1;
										// satisfiedCust[k] = true;
										// break;
										// }
										// }
										//
										// if (!hasAlternatives) {
										// System.out.println("k " + k
										// + " i " + i);
										// isPossible = false;
										// break;
										// }
									}
									// }
									// else {
									// if (flavours.length == 1) {
									// isPossible = false;
									// break;
									// }
									//
									// if (!satisfiedCust[k]) {
									// if (satisfiedCust[k - 1]) {
									// boolean ok = false;
									// for (int l = 0; l < numOfFlav; l++) {
									// if (cust[k - 1][l] != -1
									// && l != i) {
									// ok = true;
									// break;
									// }
									// }
									//
									// if (!ok) {
									// isPossible = false;
									// break;
									// } else {
									// flavours[i] = cust[k][i];
									// satisfiedCust[k] = true;
									// cust[k - 1][i] = -1;
									// }
									// } else {
									// isPossible = false;
									// break;
									// }
									// }
									// }
								}

								if (!isPossible) {
									break;
								}
							}
						}

						for (int i = 0; i < flavours.length; i++) {
							if (flavours[i] == -1) {
								flavours[i] = 0;
							}
						}

						innerLineNum = 0;
						count = 0;

						StringBuffer sBuffer = new StringBuffer("");

						for (int i = 0; i < flavours.length; i++) {
							sBuffer.append(flavours[i] + " ");
						}

						if (!isPossible) {
							System.out.println("Case #" + caseNum++ + ": "
									+ "IMPOSSIBLE");
						} else
							System.out.println("Case #" + caseNum++ + ": "
									+ sBuffer.toString());

					} else {
						innerLineNum++;
					}
				}
			}

			lineNum++;
		}

		br.close();
	}
}
