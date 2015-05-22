package codejam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienLanguage {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\codejam\\A-small-practice (2).in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		// int innerLineNum = 0;
		int caseNum = 1;
		String[] dictionary = null;
		int lengthOfWord = -1;
		int testCases = -1;
		int count = 0;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {

				if (count == dictionary.length) {
					String[] tokens = line.split("\\(|\\)");

					if (tokens.length == 1) {
						int matches = 0;
						for (int i = 0; i < dictionary.length; i++) {
							if (tokens[0].equals(dictionary[i])) {
								matches++;
							}
						}
						System.out.println("Case #" + caseNum++ + ": "
								+ matches);
					} else {
						Pattern p = Pattern.compile("\\(.*?\\)");
						Matcher m = p.matcher(line);
						StringBuffer sBuffer = new StringBuffer(lengthOfWord);
						while (m.find()) {
							String a = m.group();

							tokens = a.split("");

							sBuffer.setLength(0);
							for (int i = 0; i < tokens.length; i++) {
								if (tokens[i].equals("(")
										|| tokens[i].equals(")")) {
									sBuffer.append(tokens[i]);
								} else if (i == tokens.length - 2) {
									sBuffer.append(tokens[i]);
								} else if (!tokens[i].equals("")) {
									sBuffer.append(tokens[i] + "|");
								}
							}

							// System.out.println(line);
							// System.out.println(a);
							// System.out.println(sBuffer.toString());

							line = line.replace(a, sBuffer.toString());

							// m.group().replace(a, sBuffer.toString());
							// m.appendReplacement(sBuffer,
							// Matcher.quoteReplacement(a));
							// System.out.println(sBuffer.toString());
							// System.out.println(m.group());
						}

						int matches = 0;
						for (int i = 0; i < dictionary.length; i++) {
							if (dictionary[i].matches(line)) {
								matches++;
							}
						}

						System.out.println("Case #" + caseNum++ + ": "
								+ matches);

						// System.out.println(line);
						// m.appendTail(sBuffer);

						// System.out.println(sBuffer.toString());
					}
					// StringBuffer sBuffer = new StringBuffer("");
					// for (int i = 0; i < tokens.length; i++) {
					// sBuffer.append(tokens[i] + " ");
					// }
					// System.out.println("Case #" + caseNum++ + ": "
					// + sBuffer.toString());
				} else {
					dictionary[count] = line;
					count++;
				}

				// StringBuffer sBuffer = new StringBuffer("");
				// String[] tokens = line.split(" ");
				// for (int i = tokens.length - 1; i >= 0; i--) {
				// sBuffer.append(tokens[i] + " ");
				// }
				//
				// System.out.println("Case #" + caseNum++ + ": "
				// + sBuffer.toString());
			} else {
				String[] tokens = line.split(" ");
				lengthOfWord = Integer.parseInt(tokens[0]);
				dictionary = new String[Integer.parseInt(tokens[1])];
				testCases = Integer.parseInt(tokens[2]);
			}

			lineNum++;
		}

		br.close();
	}
}
