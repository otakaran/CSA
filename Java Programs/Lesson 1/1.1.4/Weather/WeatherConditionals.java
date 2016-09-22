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
       // Return a combined string in format: "32 degrees and heavy snow."
       return temperature + " degrees and " + description + "."; 
    }
}