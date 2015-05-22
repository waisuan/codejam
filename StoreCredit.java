package codejam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StoreCredit {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\PRACTiCE\\A-large-practice.in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int innerLineNum = 1;
		int caseNum = 1;
		int storeCredit = 0;
		int numOfItems = 0;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				if (innerLineNum == 3) {
					String[] tokens = line.split(" ");

					innerLineNum = 0;

					boolean found = false;
					int firstIndex = 0;
					int secondIndex = 0;
					for (int i = 0; i < numOfItems; i++) {
						firstIndex = i;
						for (int j = i + 1; j < numOfItems; j++) {
							secondIndex = j;
							if (Integer.parseInt(tokens[i])
									+ Integer.parseInt(tokens[j]) == storeCredit) {
								found = true;
								break;
							}
						}
						if (found) {
							break;
						}
					}

					System.out.println("Case #" + caseNum++ + ": "
							+ (firstIndex + 1) + " " + (secondIndex + 1));
				} else {
					if (innerLineNum == 1) {
						storeCredit = Integer.parseInt(line);
					} else if (innerLineNum == 2) {
						numOfItems = Integer.parseInt(line);
					}
				}

				innerLineNum++;
			}

			lineNum++;
		}

		br.close();
	}
}
