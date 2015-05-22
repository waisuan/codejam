package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AllYourBase {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\codejam\\allyourbase_small.in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int caseNum = 1;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				String[] ntokens = line.split("");

				String[] tokens = Arrays
						.copyOfRange(ntokens, 1, ntokens.length);

				boolean[] isItThere = new boolean[Character.MAX_VALUE];
				for (int i = 0; i < line.length(); i++) {
					isItThere[line.charAt(i)] = true;
				}

				int count = 0;
				for (int i = 0; i < isItThere.length; i++) {
					if (isItThere[i] == true) {
						count++;
					}
				}

				int base = Math.max(count, 2);

				// char[] arr = new char[count];
				String[] arr = new String[count];

				if (count > 1) {
					arr[1] = String.valueOf(line.charAt(0));
					tokens[0] = String.valueOf(1);
				} else {
					arr[0] = String.valueOf(line.charAt(0));
					tokens[0] = String.valueOf(1);
				}

				// System.out.println(tokens.length);

				// System.out.println(tokens.length);

				for (int i = 1; i < line.length(); i++) {
					boolean found = false;
					int k = 0;
					for (int j = 0; j < count; j++) {
						// System.out.println(arr[j]);
						if (null != arr[j]
								&& arr[j]
										.equals(String.valueOf(line.charAt(i)))) {
							found = true;
							k = j;
							break;
						}
					}

					// System.out.println("#");

					if (!found) {
						for (int j = 0; j < count; j++) {
							if (null == arr[j]) {
								arr[j] = String.valueOf(line.charAt(i));
								tokens[i] = String.valueOf(j);
								break;
							}
						}
					} else {
						// System.out.println(i + " " + k);
						tokens[i] = String.valueOf(k);
					}
				}

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < tokens.length; i++) {
					sb.append(tokens[i]);
				}

				// System.out.println(sb.toString());

				int minNumOfSeconds = Integer.valueOf(sb.toString(), base);

				System.out.println("Case #" + caseNum++ + ": "
						+ minNumOfSeconds);
			}

			lineNum++;
		}

		br.close();
	}
}
