package org.lessons.java.security;

import java.util.Scanner;

public class PasswordGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = null, surname = null, favoriteColor = null, password = null;
		int day = 0, month = 0, year = 0;
		
		name = InputInterface.getString(scanner, "Inserisci il tuo nome");
		surname = InputInterface.getString(scanner, "Ora inserisci il tuo cognome");
		favoriteColor = InputInterface.getString(scanner, "Qual è il tuo colore preferito?");
		year = InputInterface.getInt(scanner, 1900, 2023, "Che anno sei nato?");
		month = InputInterface.getInt(scanner, 1, 12, "In che mese del " + year + " sei nato?");
		day = InputInterface.getCorrectDay(scanner, month, "In che giorno sei nato?");
		
		password = name + "-" + surname + "-" + favoriteColor + "-" + (day + month + year);
		System.out.println("Password generata con successo! La password generata per te è: " + password + System.lineSeparator() + "Arrivederci!");
		
		scanner.close();
	}

}
