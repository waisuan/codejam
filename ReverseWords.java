package codejam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseWords {

	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\PRACTiCE\\B-large-practice.in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int caseNum = 1;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				StringBuffer sBuffer = new StringBuffer("");
				String[] tokens = line.split(" ");
				for (int i = tokens.length - 1; i >= 0; i--) {
					sBuffer.append(tokens[i] + " ");
				}
				// StringTokenizer st = new StringTokenizer(line);
				//
				// while (st.hasMoreElements()) {
				// sBuffer.append(st.nextElement() + " ");
				// }

				System.out.println("Case #" + caseNum++ + ": "
						+ sBuffer.toString());
			}

			lineNum++;
		}

		br.close();
	}
}
