/**
 * 
 */
package p2;

/**
 * @author 40280702
 * Abstract song class to represent a song
 */
public abstract class Song {

	//instance variables
	private String title;
	private String artist;
	private String genre;
	
	
	/**
	 * Default Constructor
	 */
	public Song() {
		
	}

	/**
	 * Contructor with all arguements. Calls business rule getters and setters. 
	 * @param title
	 * @param artist
	 * @param genre
	 */
	public Song(String title, String artist, String genre) {
		this.setTitle(title);
		this.setArtist(artist);
		this.setGenre(genre);
	}


	//Getters and Setters following business rules below

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		//If statement used for verification of title field. If null, inform user, default to TBC
		if (title!=null) {
			this.title = title;
		} else {
			System.out.println("Title cannot be empty. Title of 'New Song' by "+this.artist +" defaulting to TBC");
			this.title="TBC";
		}
	}


	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}


	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		//If statement used for verification of artist field. If null, inform user, default to TBC
		if (title!=null) {
			this.artist = artist;
		} else {
			System.out.println("Artist cannot be empty. Artist of" +this.title +" defaulting to TBC");
			this.title="TBC";
		}
	}


	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}


	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		//If statement used for verification of genre. If null, inform user, default to TBC
		if (genre!=null) {
			this.genre = genre;
		} else {
			System.out.println("Genre cannot be empty. " +this.title + " by " +this.artist +" defaulting to TBC Genre");
			this.genre="TBC";
		}
	}

	//toString method to display all
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", genre=" + genre + "]";
	}
	
	//method to display all information
	public void displayAll() {
		System.out.println("Title               "+this.getTitle());
		System.out.println("Artist              "+this.getArtist());
		System.out.println("Genre               "+this.genre);
	}
	

}
