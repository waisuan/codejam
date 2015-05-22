package codejam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MinimumScalarProduct {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\PRACTiCE\\A-large-practice (1).in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int innerLineNum = 0;
		int caseNum = 1;
		int vectorLength = -1;

		String[] vector1 = null;
		String[] vector2 = null;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				if (innerLineNum > 0) {
					// StringBuffer sBuffer = new StringBuffer("");
					// String[] tokens = line.split(" ");
					// for (int i = tokens.length - 1; i >= 0; i--) {
					// sBuffer.append(tokens[i] + " ");
					// }
					if (innerLineNum == 1) {
						vector1 = line.split(" ");
					} else if (innerLineNum == 2) {
						vector2 = line.split(" ");

						long[] longVector1 = new long[vectorLength];
						for (int i = 0; i < vectorLength; i++) {
							longVector1[i] = Long.parseLong(vector1[i]);
						}

						Arrays.sort(longVector1);

						long[] longVector2 = new long[vectorLength];
						for (int i = 0; i < vectorLength; i++) {
							longVector2[i] = Long.parseLong(vector2[i]);
						}

						Arrays.sort(longVector2);

						long min = 0;
						for (int i = 0; i < vectorLength; i++) {
							min = min
									+ (longVector1[i] * longVector2[(vectorLength - 1)
											- i]);
						}

						System.out.println("Case #" + caseNum++ + ": " + min);
					}
				} else {
					vectorLength = Integer.parseInt(line);
				}

				if (innerLineNum == 2)
					innerLineNum = 0;
				else
					innerLineNum++;
			}

			lineNum++;
		}

		br.close();
	}
}
