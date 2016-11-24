/**
 * Write a description of class LoopingMediaLib here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoopingMediaLib
{
    public static void main()
    {
        String songInfo = "meme";
        String output = "Top songs!" + System.lineSeparator() + "===========" 
                        + System.lineSeparator();
        while (songInfo != null)
        {
            songInfo = (MediaFile.readString());
            if (songInfo != null)   // Needed to preven printing first 'null'
            {    
                //System.out.println(songInfo);
                int midPosition = (songInfo.indexOf("|"));
                String title = songInfo.substring(0, (midPosition));
                int rating = Integer.valueOf(songInfo.substring(midPosition + 1));
                if (rating >= 8)
                {
                    output += "Title: " + title + "    Rating: " + rating 
                              + System.lineSeparator();
                }
            }
        }
        MediaFile.saveAndClose();
        System.out.println(output);
    }
}