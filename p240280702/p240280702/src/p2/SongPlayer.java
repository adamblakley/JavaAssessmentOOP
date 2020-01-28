/**
 * 
 */
package p2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author 40280702 song that demos the class spotify song, subclass of song
 */
public class SongPlayer {

	/**
	 * main method begins here
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// instance variables
		ArrayList<SpotifySong> songs = new ArrayList<SpotifySong>();

		try {
			// read in file and store as an array
			readSongFile(songs, "SpotifySongs.csv");

			// output to screen all details
			displayAllSongs(songs);

			// output to screen all details by search parameter U2
			searchByArtist(songs, "U2");

			// output to screen all details by search parameter 4 or above
			searchByRating(songs, 4);

			// output to screen songs by search parameter 60s store in new file
			searchByGenre(songs, "60s", "60sSongs.csv");

			// output to screen songs randomly generated, non repeating
			randomSongs(songs, 3);

		} catch (Exception e) {
			System.out.println("\nError Found");
		} finally {
			System.out.println("\nExiting Program");
		}
	}

	/**
	 * Method to read songs from file by filename. Filename included as parameter
	 * for easy modifcation and future use
	 * 
	 * @param songs
	 */
	public static void readSongFile(ArrayList<SpotifySong> songs, String fileName) {

		// inform user of plan
		System.out.println("Attempting file read of " + fileName + "\n");

		// instance vars
		File myFile = new File(fileName);

		// validation if file does not exist
		if (!myFile.exists()) {
			System.out.println("File " + fileName + " cannot be found...");
		} else {

			// try to read file
			try {

				// instancing
				String record;
				FileReader fileRead = new FileReader(myFile);
				BufferedReader bufferRead = new BufferedReader(fileRead);
				bufferRead.readLine();
				record = bufferRead.readLine();

				// while record (row) equals null, record
				while (record != null) {

					// array to break row down into elements separated by a comma (comma delimited
					// csv file)
					String[] recordSplit = record.split(",");

					// test of file read for employee : System.out.println(record);

					// hold each element from csv file against a spotify song object
					SpotifySong s1 = new SpotifySong();
					s1.setTitle(recordSplit[0]);
					s1.setArtist(recordSplit[1]);
					s1.setGenre(recordSplit[2]);
					s1.setRating(Integer.parseInt(recordSplit[3]));

					// add song object to array list passed into method
					songs.add(s1);

					// read next line and assign to record
					record = bufferRead.readLine();
				}

				// close out
				bufferRead.close();
				fileRead.close();

			} catch (IOException exc) {
				// error handling
				System.err.println("Error Reading File");
				exc.printStackTrace();
			} finally {
				// finally, tell user we are finished
				System.out.println("\nExiting File Read\n");
			}

		}

	}

	/**
	 * Method to display all songs passed through as an array list
	 * 
	 * @param songs
	 */
	public static void displayAllSongs(ArrayList<SpotifySong> songs) {
		// inform user
		System.out.println("\nDisplaying all Songs\n");
		// loop through array passed into method, for each song in the array call the
		// displayAll() method from class
		for (SpotifySong song : songs) {
			song.displayAll();
			System.out.println();
		}
	}

	/**
	 * method to search songs passed through as an array list and display details
	 * 
	 * @param songs
	 */
	public static void searchByArtist(ArrayList<SpotifySong> songs, String keyWord) {

		int numberOfSongs = 0;

		System.out.println("\nSearching for all songs by Artist containing " + keyWord + "\n");

		// iterate through all songs in array
		for (SpotifySong song : songs) {
			// use of if statment to make sure songs meet parameters
			// use of 'toLowerCase' to allow user to mistype
			if (song.getArtist().toLowerCase().contains(keyWord.toLowerCase())) {
				// call display all method from song class
				song.displayAll();
				System.out.println();
				numberOfSongs++;
			}
		}

		// if no songs found, tell user
		if (numberOfSongs == 0) {
			System.out.println("No Songs found\n");
		}

	}

	/**
	 * method to search by song rating upwards
	 * 
	 * @param songs
	 * @param rating
	 */
	public static void searchByRating(ArrayList<SpotifySong> songs, int rating) {

		int numberOfSongs = 0;

		System.out.println("\nSearching for all songs of Spotify Rating " + rating + " and up\n");

		// iterate through all songs in array
		for (SpotifySong song : songs) {
			// use of if statment to make sure songs meet parameters
			// use of 'toLowerCase' to allow user to mistype
			if (song.getRating() >= rating) {
				// call display all method from song class
				song.displayAll();
				System.out.println();
				numberOfSongs++;
			}
		}

		// if no songs are found, display message to user
		if (numberOfSongs == 0) {
			System.out.println("No Songs found\n");
		}

	}

	/**
	 * method search by song genre and call write to file method
	 * 
	 * @param songs
	 * @param keyWord
	 */
	public static void searchByGenre(ArrayList<SpotifySong> songs, String keyWord, String fileName) {

		ArrayList<SpotifySong> searchSongs = new ArrayList<SpotifySong>();

		int numberOfSongs = 0;

		System.out.println("\nSearching for all songs of " + keyWord + " genre\n");

		// iterate through all songs in array
		for (SpotifySong song : songs) {
			// use of if statment to make sure songs meet parameters
			// use of 'toLowerCase' to allow user to mistype
			if (song.getGenre().toLowerCase().contains(keyWord.toLowerCase())) {
				searchSongs.add(song);
				numberOfSongs++;
			}
		}

		// if no songs found, tell user
		if (numberOfSongs == 0) {
			System.out.println("No Songs found\n");
		} else {
			// else write to file
			writeToFile(searchSongs, fileName);
		}
	}

	/**
	 * method to write to file
	 * 
	 * @param songs
	 * @param fileName
	 */
	public static void writeToFile(ArrayList<SpotifySong> songs, String fileName) {

		// check if array has any songs
		if (songs.size() == 0) {
			System.out.println("No Songs found");
		} else {

			System.out.println("Writing to File " + fileName);

			File myFile = new File(fileName);
			// create new file if filename not found
			try {
				if (!myFile.exists()) {
					myFile.createNewFile();
				}

				FileWriter fileWrite = new FileWriter(myFile);
				BufferedWriter bufferWrite = new BufferedWriter(fileWrite);

				// write headers
				bufferWrite.write("Title,Artist,Genre,Rating\n");

				// iterate through array
				for (SpotifySong song : songs) {
					bufferWrite.write(song.getArtist() + ",");
					bufferWrite.write(song.getTitle() + ",");
					bufferWrite.write(song.getGenre() + ",");
					bufferWrite.write(song.getRating() + "\n");
				}

				//close out writers
				bufferWrite.close();
				fileWrite.close();

				// catch blocks
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println("Writing complete");
			}

		}

	}

	/**
	 * display random number of songs input by user
	 * 
	 * @param songs
	 * @param numberOfSongs
	 */
	public static void randomSongs(ArrayList<SpotifySong> songs, int numberOfSongs) {
		
		// instance
		Random random = new Random();
		int songRandom;
		int songPlayed=0;
		
		System.out.println("\nPlaying " +numberOfSongs +" random songs");
		
		//store played songs in a new array to be ignored via if statement in for loop
		int[] randomSongs=new int[numberOfSongs];

		// loop through arrayList of songs by count of user input
		for (int loop = 0; loop < numberOfSongs; loop++) {
			// songRandom = size of array list of songs, song chose by songRandom value
			
			//for (int randomSong : randomSongs) {
				
			//	for (int random : randomSongs)
			
				songRandom = random.nextInt(songs.size());
				System.out.println(songs.get(songRandom).getTitle());
				randomSongs[songPlayed]=songRandom;
			//}
			
		}
	}
}
