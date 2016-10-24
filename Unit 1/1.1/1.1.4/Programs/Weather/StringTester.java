/**
 * This is the main class in the Weather Project.
 * 
 * @author Otakar Andrysek
 * @version .2
 * @date 9/20/2016
 */

// The main class for the entire program
public class StringTester
{
    // The main function (method) for the entire program
    public static void main()
    {
        // Declare a weather condition vairable
        String weatherCondition = "scattered thunderstorms";
        
        // Print some information about the "weatherCondition" variable
        System.out.println(weatherCondition);   // Variable itself
        System.out.println(weatherCondition.length());  // Variable Length
        System.out.println(weatherCondition.substring(0,5));    // The first word
        System.out.println(weatherCondition.indexOf("thunder")); // Find thunder in string
        
        // Pass some weather info into the weather coditional method
        System.out.println(WeatherConditionals.getWeatherAdvice(32, "heavy snow"));
    }
}