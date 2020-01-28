/**
 * 
 */
package p2;

/**
 * @author 40280702 Spotify song class extends abstract class song
 */
public class SpotifySong extends Song {

	// instance variables exclusive to SpotifySong
	private int rating;

	/**
	 * default constructor
	 */
	public SpotifySong() {

	}

	/**
	 * constructor will all args including those inherited from superclass 'song'
	 * rating retrieved from set rating where business rule applies
	 * 
	 * @param title
	 * @param artist
	 * @param genre
	 */
	public SpotifySong(String title, String artist, String genre, int rating) {
		super(title, artist, genre);
		this.setRating(rating);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		// including validation to check rating and if outside bounds, inform user and
		// set to default
		if (rating <= 5 && rating >= 1) {
			this.rating = rating;
		} else {
			System.out.println("Spotify Rating of " + this.getTitle() + " by " + this.getArtist()
					+ " cannot be outside the range of 1-5 inclusive");
			System.out.println("Defaulting to 1");
			this.rating = 1;
		}
	}
	
	// You could also set the rating using a try catch
	/*
	public void setRating(int rating) {
		try { 
			if (rating <= 5 && rating >= 1) {
				this.rating = rating;
			} else throw new IllegalArgumentException();

		} catch (IllegalArgumentException exc) {
			System.out.println("Spotify Rating of " + this.getTitle() + " by " + this.getArtist()
					+ " cannot be outside the range of 1-5 inclusive");
			System.out.println("Defaulting to 1");
			this.rating = 1;
		}
	}
*/
	// override toString method from song superclass
	@Override
	public String toString() {

		return "Song [title=" + this.getTitle() + ", artist=" + this.getArtist() + ", genre=" + this.getGenre()
				+ ", rating+" + this.getRating() + "]";
	}

	// override displayAll method from song superclass
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		super.displayAll();
		System.out.println("Spotify Rating      " + this.getRating());
	}

}
