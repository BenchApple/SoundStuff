import java.io.*;
import sun.audio.*;
import java.nio.file.*;
import java.io.InputStream.*;
import javax.sound.sampled.*;
import java.util.*;

public class Playlist
{
	public static void main(String[] args) throws Exception
	{
		Scanner keyboard = new Scanner(System.in);
		
		String ubuntuBase = "/media/hershey/BEN/XC2SS/";
		String usbBase = "G:\\XC2SS\\";
		String base;
		
		System.out.println("Are you on an ubuntu or Windows computer? (u/w)");
		char comp = keyboard.next().charAt(0);
		if (comp == 'u')
			base = ubuntuBase;
		else
			base = usbBase;
		
		//System.out.println(new File(base).listFiles());
		
		File[] songs = new File[new File(base).listFiles().length];
		songs = new File(base).listFiles();
		
		int songNumber = 1;
		
		for (File song : songs)
		{
			System.out.println("Number " + songNumber + " is " + song);
			songNumber ++;
		}
		
		byte[] buffer = new byte[4096];
		
		boolean keepGoing = true;
		int songIndex = 1;
		
		while (true)
		{
			System.out.println("Which song would you like to play next (number please, input 0 to stop) ==> ");
			int prevIndex = 0;
			songIndex = keyboard.nextInt();
			if (songIndex == 0)
				break;
			else
			{	
				System.out.println("Now playing: " + songs[songIndex - 1] + ".");
			}
			
			try
			{
				AudioInputStream is = AudioSystem.getAudioInputStream(songs[songIndex - 1]);
				AudioFormat format = is.getFormat();
				SourceDataLine line = AudioSystem.getSourceDataLine(format);
				line.open(format);
				line.start();
				
				double isAvailble;
				
				while (is.available() > 0)
				{
					int len = is.read(buffer);
					line.write(buffer, 0, len);
				}
				
				line.drain();
				line.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("That file is not a song");
			}
		}
	}
	
	public static String findFileType(final String fileName)
	{
		String fileType = "Undetermined";
		final File file = new File(fileName);
		
		try
		{
			fileType = Files.probeContentType(file.toPath());
		}
		catch (IOException ioexception)
		{
			System.out.println("Unable to determine file typle for this file");
		}
			
		return fileType;
	}
	
	
}
