import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String grade = br.readLine();
		float score = 0f;
		switch (grade.charAt(0)) {
		case 'A': {
			score = 4.0f;
			break;
		}
		case 'B': {
			score = 3.0f;
			break;
		}
		case 'C': {
			score = 2.0f;
			break;
		}
		case 'D': {
			score = 1.0f;
			break;
		}
		case 'F': {
			score = 0.0f;
			System.out.println(score);
			return;
		}
		}
		switch (grade.charAt(1)) {
		case '+': {
			score += 0.3f;
			System.out.println(score);
			return;
		}
		case '0': {
			System.out.println(score);
			return;
		}
		case '-': {
			score -= 0.3f;
			System.out.println(score);
			return;
		}
		}
	}

}
