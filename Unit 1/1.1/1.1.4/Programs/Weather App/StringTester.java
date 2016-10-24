/**
 * This is the main class in the Weather Project.
 * 
 * @author Otakar Andrysek
 * @version .1
 * @date 9/23/2016
 */

// The main class for the entire program
public class StringTester
{
    // The main function (method) for the entire program
    public static void main()
    {
        // Set the weather conditions
        WeatherConditionals.getHikingAdvice(49,43,65,"partly cloudy");
        WeatherConditionals.getHikingAdvice(89,43,65,"thunderstorm");
        WeatherConditionals.getHikingAdvice(89,43,85,"partly cloudy");
        WeatherConditionals.getHikingAdvice(41,23,55,"sunny");
        WeatherConditionals.getHikingAdvice(57,54,92,"sunny");
        WeatherConditionals.getHikingAdvice(49,43,65,"rain");
    }
}