package codejam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Numbers {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\codejam\\C-small-practice (1).in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int caseNum = 1;

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				double answer = Math.pow(3 + Math.sqrt(5),
						Integer.parseInt(line));
				System.out.println(answer);
			}

			lineNum++;
		}

		br.close();
	}
}
