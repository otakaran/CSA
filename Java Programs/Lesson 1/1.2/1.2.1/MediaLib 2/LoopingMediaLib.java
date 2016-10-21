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
            if (songInfo != null)
            {    
                System.out.println(songInfo);
            }
        }
        MediaFile.saveAndClose();
    }
}