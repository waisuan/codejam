package codejam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class T9Spelling {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\PRACTiCE\\C-large-practice.in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		Map<Integer, String[]> keypad = new HashMap<Integer, String[]>();
		keypad.put(2, new String[] { "a", "b", "c" });
		keypad.put(3, new String[] { "d", "e", "f" });
		keypad.put(4, new String[] { "g", "h", "i" });
		keypad.put(5, new String[] { "j", "k", "l" });
		keypad.put(6, new String[] { "m", "n", "o" });
		keypad.put(7, new String[] { "p", "q", "r", "s" });
		keypad.put(8, new String[] { "t", "u", "v" });
		keypad.put(9, new String[] { "w", "x", "y", "z" });
		keypad.put(0, new String[] { " " });

		Map<String, String> inverseKeypad = new HashMap<String, String>();
		inverseKeypad.put("a", "2");
		inverseKeypad.put("b", "2");
		inverseKeypad.put("c", "2");
		inverseKeypad.put("d", "3");
		inverseKeypad.put("e", "3");
		inverseKeypad.put("f", "3");
		inverseKeypad.put("g", "4");
		inverseKeypad.put("h", "4");
		inverseKeypad.put("i", "4");
		inverseKeypad.put("j", "5");
		inverseKeypad.put("k", "5");
		inverseKeypad.put("l", "5");
		inverseKeypad.put("m", "6");
		inverseKeypad.put("n", "6");
		inverseKeypad.put("o", "6");
		inverseKeypad.put("p", "7");
		inverseKeypad.put("q", "7");
		inverseKeypad.put("r", "7");
		inverseKeypad.put("s", "7");
		inverseKeypad.put("t", "8");
		inverseKeypad.put("u", "8");
		inverseKeypad.put("v", "8");
		inverseKeypad.put("w", "9");
		inverseKeypad.put("x", "9");
		inverseKeypad.put("y", "9");
		inverseKeypad.put("z", "9");
		inverseKeypad.put(" ", "0");

		String line;
		int lineNum = 0;
		int caseNum = 1;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				StringBuffer sBuffer = new StringBuffer("");
				String[] tokens = line.split("");
				String prevKey = null;
				for (int i = 0; i < tokens.length; i++) {

					// if (tokens[i].equals(" ")) {
					// System.out.println(tokens[i]);
					// }

					if (!tokens[i].equals("")) {
						String key = inverseKeypad.get(tokens[i]);
						String[] values = keypad.get(Integer.parseInt(key));

						if (key.equals(prevKey)) {
							sBuffer.append(" ");
						}

						for (int j = 0; j < values.length; j++) {
							sBuffer.append(key);
							if (values[j].equals(tokens[i])) {
								break;
							}
						}

						prevKey = key;
					}
				}

				System.out.println("Case #" + caseNum++ + ": "
						+ sBuffer.toString());
			}

			lineNum++;
		}

		br.close();
	}
}
