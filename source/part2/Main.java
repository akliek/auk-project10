package source.part2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static int getUserInt(Scanner scanner) {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("\u001B[31mIt is not a number. Try again: \u001B[0m");
			}
		}
	}

	public static double getUserDouble(Scanner scanner) {
		while (true) {
			try {
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("\u001B[31mIt is not a number. Try again: \u001B[0m");
			}
		}
	}

	public static void search(Scanner scanner, MusicAlbumCollection albumCollection) {
		System.out.print("Enter album title to search for: ");
		String title = scanner.nextLine();
		albumCollection.find(title);
	}

	public static void inputItems(Scanner scanner, MusicAlbumCollection albumCollection) {
		System.out.println("Adding new albums to the collection. Enter 'stop' to finish.");
		while (true) {
			System.out.print("Enter album title: ");
			String title = scanner.nextLine();
			if (title.equalsIgnoreCase("stop")) {
				break;
			}

			System.out.print("Enter artist name: ");
			String artist = scanner.nextLine();

			System.out.print("Enter release year: ");
			int releaseYear = getUserInt(scanner);
			scanner.nextLine(); // Consume newline character

			System.out.print("Enter album price: ");
			double price = getUserDouble(scanner);
			scanner.nextLine(); // Consume newline character

			MusicAlbum newAlbum = new MusicAlbum(title, artist, releaseYear, price);
			albumCollection.add(newAlbum);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MusicAlbumCollection albumCollection = new MusicAlbumCollection(50);

		System.out.println("Welcome to the music album database!");
		int choice;

		do {
			System.out.println("Choose an option to proceed:");
			System.out.println("1 - Add albums to collection");
			System.out.println("2 - Print all albums");
			System.out.println("3 - Sort albums by release year");
			System.out.println("4 - Search albums by title");
			System.out.println("5 - Search albums by release year");
			System.out.println("0 - Exit the program");

			choice = getUserInt(scanner);
			scanner.nextLine(); // Consume newline character

			switch (choice) {
				case 1:
					inputItems(scanner, albumCollection);
					break;
				case 2:
					albumCollection.print();
					break;
				case 3:
					albumCollection.sort();
					System.out.println("Albums sorted by release year.");
					break;
				case 4:
					search(scanner, albumCollection);
					break;
				case 5:
					System.out.print("Enter release year to search for albums: ");
					int year = getUserInt(scanner);
					scanner.nextLine(); // Consume newline character
					albumCollection.searchByProperty(year);
					break;
				case 0:
					System.out.println("Exiting the program.");
					break;
				default:
					System.out.println("Invalid choice. Please choose a valid option.");
					break;
			}
		} while (choice != 0);

		scanner.close();
	}
}
