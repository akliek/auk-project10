package source.part2;

public class MusicAlbumCollection {
	private int count;
	private MusicAlbum[] albums;

	// Constructor to initialize the collection
	public MusicAlbumCollection(int capacity) {
		count = 0;
		albums = new MusicAlbum[capacity];
	}

	// Method to add a new MusicAlbum object to the collection
	public void add(MusicAlbum newAlbum) {
		if (count < albums.length) {
			albums[count] = newAlbum;
			count++;
		} else {
			System.out.println("The collection is full. Cannot add more albums.");
		}
	}

	// Method to print detailed information about an item at the specified index
	public void printOne(int index) {
		if (index >= 0 && index < count) {
			System.out.println(albums[index].getAlbumDescription());
		} else {
			System.out.println("Invalid index.");
		}
	}

	// Method to print the entire list of albums in the collection
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println("Album " + (i + 1) + ":");
			System.out.println(albums[i].getAlbumDescription());
			System.out.println();
		}
	}

	// Method to search and print albums by title
	public void find(String title) {
		boolean found = false;

		for (int i = 0; i < count; i++) {
			if (albums[i].getTitle().equalsIgnoreCase(title)) {
				System.out.println("Matching album found:");
				System.out.println(albums[i].getAlbumDescription());
				found = true;
			}
		}
		if (!found) {
			System.out.println("Album with title '" + title + "' not found.");
		}
	}

	// Method to sort albums by release year using bubble sort
	public void sort() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - 1 - i; j++) {
				if (albums[j].getReleaseYear() > albums[j + 1].getReleaseYear()) {
					// Swap albums[j] and albums[j+1]
					MusicAlbum temp = albums[j];
					albums[j] = albums[j + 1];
					albums[j + 1] = temp;
				}
			}
		}
	}

	// Method to search and print albums by additional properties (e.g., release year)
	public void searchByProperty(int year) {
		boolean found = false;

		for (int i = 0; i < count; i++) {
			if (albums[i].getReleaseYear() == year) {
				System.out.println("Matching album found:");
				System.out.println(albums[i].getAlbumDescription());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No albums released in the year " + year + " found.");
		}
	}
}
