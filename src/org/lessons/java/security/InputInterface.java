package org.lessons.java.security;

import java.util.Scanner;

public class InputInterface {

	public static String getString(Scanner scanner, String requestMessage) {
		String s = null, resultString = "";
		boolean inputSuccess = false;

		System.out.println(requestMessage);

		while (!inputSuccess) {

			s = scanner.nextLine();

			s = s.trim();
			// Remove white spaces inside the string and replace them with a '-', accepting
			// only letters
			for (int i = 0; i < s.length(); i++)
				if ((s.charAt(i) >= (char) 65 && s.charAt(i) <= (char) 90)
						|| (s.charAt(i) >= (char) 97 && s.charAt(i) <= (char) 122))
					resultString += s.charAt(i);
				else if (s.charAt(i) == ' ') {
					if (i + 1 < s.length())
						if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ')
							resultString += '-';
				} else {
					resultString = "";
					break;
				}

			if (resultString.isBlank())
				System.out.println("Errore! Non sono ammessi numeri o caratteri speciali. Riprova");
			else
				inputSuccess = true;

		}

		return resultString;
	}

	public static int getInt(Scanner scanner, int min, int max, String requestMessage) {

		String inputValue;
		int x = 0;
		boolean inputSuccess = false;

		System.out.println(requestMessage);

		while (!inputSuccess) {
			inputValue = scanner.nextLine();
			try {
				x = Integer.parseInt(inputValue);

				if (x < min)
					System.out.println("Errore! Devi inserire un numero maggiore di " + (min - 1) + ". Riprova");
				else if (x > max)
					System.out.println("Errore! Devi inserire un numero minore di  " + (max + 1) + ". Riprova");
				else
					inputSuccess = true;
			} catch (NumberFormatException e) {
				System.out.println("Errore! Devi inserire un numero intero valido. Riprova");
			}
		}

		return x;
	}

	public static int getCorrectDay(Scanner scanner, int month, String requestMessage) {
		int max = 0;
		int x = 0;

		switch (month) {

		case 2:
			max = 28;
			break;

		case 4:
		case 6:
		case 9:
		case 11:
			max = 30;
			break;

		default:
			max = 31;
		}

		x = getInt(scanner, 1, max, requestMessage);
		return x;
	}
}
