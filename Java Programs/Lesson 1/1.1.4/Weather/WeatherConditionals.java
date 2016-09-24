/**
 * This is the main class in the Weather Project.
 * 
 * @author Otakar Andrysek
 * @version .1
 * @date 9/20/2016
 */

// Begin the actual class
public class WeatherConditionals
{
    // Create a method to give weather advice based on temperature and weather
    public static String getWeatherAdvice(int temperature, String description){
       boolean windy = false;
       boolean sunny = false;
       boolean snow = false;
       boolean cold = false;
       
       // Logic to determine action based on weather conditions
       if (temperature == 34 & description.contains("sunny"))
       {
           // Set booleans
           sunny = true;
           // Print the weather status
           System.out.println("It's safe to go outside, 34 degrees and sunny.");
       }
       else if (temperature == 32 & description.contains("windy"))
       {
           windy = true;
           // Print the weather status
           System.out.println("Too windy or cold! Enjoy watching the weather through the window.");
       }
       else if (temperature == 33 & description.contains("snow"))
       {
           snow = true;
           // Print the weather status
           System.out.println("It's safe to go outside, 33 degrees and snow.");
       }
       else if (temperature == 30 & description.contains("snow"))
       {
           cold = true;
           snow = true;
           // Print the weather status
           System.out.println("Too windy or cold! Enjoy watching the weather through the window.");
       }
       else if (temperature == 30 & description.contains("windy"))
       {
           cold = true;
           windy = true;
           // Print the weather status
           System.out.println("Too windy or cold! Enjoy watching the weather through the window.");
       }
       // A very unlikely situation
       else if (temperature > 100 & description.contains("snow"))
       {
           
       }
       else // Oh no, something went wrong!
       {
           // Print the (error) status
           System.out.println("NO CONDITION FOUND [ERR 1]");
       }
       // Return a combined string in format: "32 degrees and heavy snow."
       windy = description.contains("windy");
       return temperature + " degrees and " + description + ". " + windy; 
    }
}