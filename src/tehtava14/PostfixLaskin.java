package tehtava14;

import java.util.Stack;

public class PostfixLaskin {

	public String laske(String lause) {
		Stack<Double> pino = new Stack<>();
		try {
		for (int i = 0; i < lause.length(); i++) {
			char c = lause.charAt(i);
			if (c == ' ') {
				continue;
			} else if (Character.isDigit(c)) {
				double luku = 0;
				while (Character.isDigit(c)) {
					luku = luku * 10 + (int) (c - '0');
					i++;
					c = lause.charAt(i);
				}
				i--;
				pino.push(luku);
			} else {
				double luku1 = pino.pop();
				double luku2 = pino.pop();
				switch (c) {
				case '+':
					pino.push(luku2 + luku1);
					break;

				case '-':
					pino.push(luku2 - luku1);
					break;

				case '/':
					pino.push(luku2 / luku1);
					break;

				case '*':
					pino.push(luku2 * luku1);
					break;
				}

			}
		}
		return "" + pino.pop();
		} catch(Exception e ) {
		}
		return "Virheellinen syöte";
	}

}
