package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RopeIntranet {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\codejam\\A-small-practice (3).in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int innerLineNum = 0;
		int caseNum = 1;
		int numOfWires = -1;
		int count = 0;
		int[] a = null;
		int[] b = null;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				if (innerLineNum > 0) {

					String[] tokens = line.split(" ");

					a[count] = Integer.parseInt(tokens[0]);
					b[count] = Integer.parseInt(tokens[1]);

					count++;

					if (count == numOfWires) {

						int matches = 0;
						for (int i = 0; i < numOfWires; i++) {
							for (int j = 0; j < i; j++) {
								// XOR
								if ((a[i] > a[j]) ^ (b[i] > b[j])) {
									matches++;
								}
							}
						}

						System.out.println("Case #" + caseNum++ + ": "
								+ matches);

						innerLineNum = 0;
						count = 0;
					}

				} else if (innerLineNum == 0) {
					numOfWires = Integer.parseInt(line);
					a = new int[numOfWires];
					b = new int[numOfWires];
					innerLineNum++;
				}

			}

			lineNum++;
		}

		br.close();
	}
}
