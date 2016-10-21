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
        while (songInfo != null)
        {
            songInfo = (MediaFile.readString());
            if (songInfo != null)   // Needed to preven printing first 'null'
            {    
                //System.out.println(songInfo);
                int position = (songInfo.indexOf( '|' ));
                String title = songInfo.substring(0, (position));
                String rating = songInfo.substring(position + 1);
                
                String output = System.lineSeparator() + "Title: " + title + System.lineSeparator() 
                                + "Rating: " + rating;
                System.out.println(output);
            }
        }
        MediaFile.saveAndClose();
    }
}