/**
 * This is the main class in the Weather Project.
 * 
 * @author Otakar Andrysek
 * @version .1
 * @date 9/23/2016
 */

// Begin the actual class
public class WeatherConditionals
{
    // Create a method to give hiking advice based on temperature and other weather factors
    public static String getHikingAdvice(int temperature, int windchill, int humidity, String description)
    {
        /**Initialize logic factors (booleans)*/
        // Based on condition
        boolean isSnowing = false;
        boolean isSunny = false;
        boolean isCloudy = false;
        boolean isThunder = false;
        boolean isRaining = false;
        
        //Based on temperature
        boolean isCold = false;
        boolean isMild = false;
        boolean isHot = false;
        
        // Based on windchill
        boolean isWindy = false;
        boolean isCalm = false;
        
        // Based on humidity
        boolean isHumid = false;
        boolean isComfortable = false;
        boolean isDry = false;
        
        // Create an error variable
        int error = 0;
        
        /**Welcome the user*/
        System.out.println("\n\nHello and welcome to my hiking weather system.");
        System.out.println("I will give you a reccomendation based on the current weather ");
        System.out.printf("Currently it is %s and %s degrees\n", description, temperature);
        System.out.printf("The windchill is %s degrees and the humidity is %s\n\n", windchill, temperature);
        
        /**Proccess booleans*/
        // Based on description
        if (description.contains("snow"))
            isSnowing = true;
        else if (description.contains("sunny"))
            isSunny = true;
        else if (description.contains("cloudy"))
            isCloudy = true;
        else if (description.contains("thunder"))
            isThunder = true;
        else if (description.contains("rain"))
            isRaining = true;
        else    // Just in case
        {
            error = 1;  // Description cannot be assesed
            return "No expression found! Error:" + error;  // No point in continuing
        }
        
        
        // Based on temperature
        if (temperature < 40 && temperature > -100)   // Less than 40 degrees? Brrr!
            isCold = true;
        else if (temperature > 80 && temperature < 130)  // 2 Hot 4 Me
            isHot = true;
        else if (temperature >= 40 || temperature <= 80)    // 40 to 80? Sounds good!
            isMild = true;
        else
        {
            error = 2; // The temperature is greater than 129 or less than -99
            return "Temperature out of bounds! Error:" + error;  // No point in continuing
        }
        
        // Based on windchill
        if ((temperature - windchill) >= 10 && (temperature - windchill) < 50)
            isWindy = true;
        else if ((temperature - windchill) < 10 && (temperature - windchill) > -5)
            isCalm = true;
        else
        {
            error = 3; // The windchill is 50 degrees lower than the temperature or windchill is 5 degrees higher
            return "Windchill? Error:" + error;  // No point in continuing
        }
        
        // Based on humidity
        if (humidity > 80)
            isHumid = true;
        else if (humidity < 30)
            isDry = true;
        else if (humidity >= 30 && humidity <= 80)
            isComfortable = true;
        else
        {
            error = 4; // This should never happen
            return "Humidity? Error:" + error;  // No point in continuing
        }
            
        /**Return to user based on booleans*/
        // Here goes nothing
        // I heard you like if statements, so I put if statements inside your... well you get the idea.
        
        if (isSnowing)  // No one is hiking in this...
        {
            System.out.println("It's snowing, are you crazy?");
        }
        
        if (isSunny)    // Let's break it down more
        {
            if (isHot)
            {
                if (isWindy)
                {
                    if (isHumid)    // Sunny, hot, windy, humid
                    {
                        System.out.println("Its way too hot, go for a swim.");
                    }
                    else if (isDry) // Sunny, hot, windy, dry
                    {
                        System.out.println("Its hot and dry, yuck, go for a swim.");
                    }
                    else if (isComfortable) // Sunny, hot, windy, comfortable
                    {
                        System.out.println("It's hot and windy, how about a water balllon fight.");
                    }
                    else    // Not like this...
                    {
                        error = 17;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Sunny, hot, calm, humid
                    {
                        System.out.println("You'll sweat like crazy! Stay home and read.");
                    }
                    else if (isDry) // Sunny, hot, calm, dry
                    {
                        System.out.println("It's crazy hot, turn on the AC!");
                    }
                    else if (isComfortable) // Sunny, hot, calm, comfortable
                    {
                        System.out.println("Maybe it's time to more from Cali to Oregon, oh wait...");
                    }
                    else    // Not like this...
                    {
                        error = 18;
                    }
                }
                else
                {
                    error = 8;
                }
            }
            else if (isCold)
            {
                if (isWindy)
                {
                    if (isHumid)    // Sunny, cold, windy, humid
                    {
                        System.out.println("It's too cold for a hike, if only it was snowing...");
                    }
                    else if (isDry) // Sunny, cold, windy, dry
                    {
                        System.out.println("Yikes, don't hike, go skiing instead.");
                    }
                    else if (isComfortable) // Sunny, cold, windy, comfortable
                    {
                        System.out.println("Only with a winter jacket.");
                    }
                    else    // Not like this...
                    {
                        error = 19;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Sunny, cold, calm, humid
                    {
                        System.out.println("Where do you live!?!? It's a bit too cold to hike. ");
                    }
                    else if (isDry) // Sunny, cold, calm, dry
                    {
                        System.out.println("How about ice skating?");
                    }
                    else if (isComfortable) // Sunny, cold, calm, comfortable
                    {
                        System.out.println("Looks like a nice day to cuddle up to the fire");
                    }
                    else    // Not like this...
                    {
                        error = 20;
                    }
                }
                else
                {
                    error = 9;
                }
            }
            else if (isMild)
            {
                if (isWindy)
                {
                    if (isHumid)    // Sunny, mild, windy, humid
                    {
                        System.out.println("It's windy and humid, but it could be a good hike, have fun!");
                    }
                    else if (isDry) // Sunny, mild, windy, dry
                    {
                        System.out.println("The air is dry but you might be able to survive (yes).");
                    }
                    else if (isComfortable) // Sunny, mild, windy, comfortable
                    {
                        System.out.println("A little windy, but great otherwise!");
                    }
                    else    // Not like this...
                    {
                        error = 21;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Sunny, mild, calm, humid
                    {
                        System.out.println("A little humid, but still a perfect hiking day.");
                    }
                    else if (isDry) // Sunny, mild, calm, dry
                    {
                        System.out.println("This looks like a fantastic day for a hike!");
                    }
                    else if (isComfortable) // Sunny, mild, calm, comfortable
                    {
                        System.out.println("THE PERFECT DAY FOR A HIKE!");
                    }
                    else    // Not like this...
                    {
                        error = 22;
                    }
                }
                else
                {
                    error = 10;
                }
            }
            else
            {
                error = 5;
            }
        }
        
        if (isCloudy)   // Let's break it down more
        {
            if (isHot)
            {
                if (isWindy)
                {
                    if (isHumid)    // Cloudy, hot, windy, humid
                    {
                        System.out.println("It's nasty out there, stay at home.");
                    }
                    else if (isDry) // Cloudy, hot, windy, dry
                    {
                        System.out.println("Do you live in the tropics?? Stay home today.");
                    }
                    else if (isComfortable) // Cloudy, hot, windy, comfortable
                    {
                        System.out.println("It could be a good day for a hike.");
                    }
                    else    // Not like this...
                    {
                        error = 23;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Cloudy, hot, calm, humid
                    {
                        System.out.println("Save it for another day.");
                    }
                    else if (isDry) // Cloudy, hot, calm, dry
                    {
                        System.out.println("How about just a walk.");
                    }
                    else if (isComfortable) // Cloudy, hot, calm, comfortable
                    {
                        System.out.println("It's toasty, but maybe you will enjoy your hike.");
                    }
                    else    // Not like this...
                    {
                        error = 24;
                    }
                }
                else
                {
                    error = 11;
                }
            }
            else if (isCold)
            {
                if (isWindy)
                {
                    if (isHumid)    // Cloudy, cold, windy, humid
                    {
                        System.out.println("It's chilly, read that book you were trying to finish.");
                    }
                    else if (isDry) // Cloudy, cold, windy, dry
                    {
                        System.out.println("Maybe a short walk will be better, bring chapstick.");
                    }
                    else if (isComfortable) // Cloudy, cold, windy, comfortable
                    {
                        System.out.println("This looks more like a snowshoeing day.");
                    }
                    else    // Not like this...
                    {
                        error = 25;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Cloudy, cold, calm, humid
                    {
                        System.out.println("Chilly, but worth a shot.");
                    }
                    else if (isDry) // Cloudy, cold, calm, dry
                    {
                        System.out.println("Bring a jacket, but go for it");
                    }
                    else if (isComfortable) // Cloudy, cold, calm, comfortable
                    {
                        System.out.println("Bring a jacket and it might be good.");
                    }
                    else    // Not like this...
                    {
                        error = 26;
                    }
                }
                else
                {
                    error = 12;
                }
            }
            else if (isMild)
            {
                if (isWindy)
                {
                    if (isHumid)    // Cloudy, mild, windy, humid
                    {
                        System.out.println("Go for it!");
                    }
                    else if (isDry) // Cloudy, mild, windy, dry
                    {
                        System.out.println("A comfortable hike awaits you");
                    }
                    else if (isComfortable) // Cloudy, mild, windy, comfortable
                    {
                        System.out.println("Watch the wind, otherwise fantastic");
                    }
                    else    // Not like this...
                    {
                        error = 27;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Cloudy, mild, calm, humid
                    {
                        System.out.println("It might rain, but no risk - no reward");
                    }
                    else if (isDry) // Cloudy, mild, calm, dry
                    {
                        System.out.println("Its wonderful outside, go while it's nice.");
                    }
                    else if (isComfortable) // Cloudy, mild, calm, comfortable
                    {
                        System.out.println("PERFECT! GO, GO NOW");
                    }
                    else    // Not like this...
                    {
                        error = 28;
                    }
                }
                else
                {
                    error = 13;
                }
            }
            else
            {
                error = 6;
            }
        }
        
        if (isThunder)  // Not safe
        {
            System.out.println("It's thundering out there, stay at home");
        }
        
        if (isRaining)  // Let's break it down more
        {
            if (isHot)
            {
                if (isWindy)
                {
                    if (isHumid)    // Rain, hot, windy, humid
                    {
                        System.out.println("Is this a hurricane?!");
                    }
                    else if (isDry) // Rain, hot, windy, dry
                    {
                        System.out.println("Stay home and move ASAP.");
                    }
                    else if (isComfortable) // Rain, hot, windy, comfortable
                    {
                        System.out.println("Avoid a hike in these conditions.");
                    }
                    else    // Not like this...
                    {
                        error = 29;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Rain, hot, calm, humid
                    {
                        System.out.println("Bring a raincoat and don't expect it to be nice out there.");
                    }
                    else if (isDry) // Rain, hot, calm, dry
                    {
                        System.out.println("This is some strange weather, ain't it? No hike.");
                    }
                    else if (isComfortable) // Rain, hot, calm, comfortable
                    {
                        System.out.println("It could be good if you like walking in the hot and rain.... (no)");
                    }
                    else    // Not like this...
                    {
                        error = 30;
                    }
                }
                else
                {
                    error = 14;
                }
            }
            else if (isCold)
            {
                if (isWindy)
                {
                    if (isHumid)    // Rain, cold, windy, humid
                    {
                        System.out.println("Never! Go read.");
                    }
                    else if (isDry) // Rain, cold, windy, dry
                    {
                        System.out.println("Stay inside, watch a movie.");
                    }
                    else if (isComfortable) // Rain, cold, windy, comfortable
                    {
                        System.out.println("Only go outside if you want a cold.");
                    }
                    else    // Not like this...
                    {
                        error = 31;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Rain, cold, calm, humid
                    {
                        System.out.println("Don't hike, and watch out for freezing rain tomorrow.");
                    }
                    else if (isDry) // Rain, cold, calm, dry
                    {
                        System.out.println("Not ideal at all, but if you want an adventure, go.");
                    }
                    else if (isComfortable) // Rain, cold, calm, comfortable
                    {
                        System.out.println("A nasty hike, I don't think it's a good idea.");
                    }
                    else    // Not like this...
                    {
                        error = 32;
                    }
                }
                else
                {
                    error = 15;
                }
            }
            else if (isMild)
            {
                if (isWindy)
                {
                    if (isHumid)    // Rain, mild, windy, humid
                    {
                        System.out.println("Only if you like windy, rainy hikes.");
                    }
                    else if (isDry) // Rain, mild, windy, dry
                    {
                        System.out.println("I think Yahoo! is broken.");
                    }
                    else if (isComfortable) // Rain, mild, windy, comfortable
                    {
                        System.out.println("No way, go finish that TV series.");
                    }
                    else    // Not like this...
                    {
                        error = 33;
                    }
                }
                else if (isCalm)
                {
                    if (isHumid)    // Rain, mild, calm, humid
                    {
                        System.out.println("It might rain hard, but I would still do it.");
                    }
                    else if (isDry) // Rain, mild, calm, dry
                    {
                        System.out.println("Do it!");
                    }
                    else if (isComfortable) // Rain, mild, calm, comfortable
                    {
                        System.out.println("It's a GREAT walk... in the rain");
                    }
                    else    // Not like this...
                    {
                        error = 34;
                    }
                }
                else
                {
                    error = 16;
                }
            }
            else
            {
                error = 7;
            }
        }
        
        // One final if statement!
        if (error != 0)
        {
            System.out.printf("\nError: %s\n", error);
        }
        return "Done! ";
    }
}