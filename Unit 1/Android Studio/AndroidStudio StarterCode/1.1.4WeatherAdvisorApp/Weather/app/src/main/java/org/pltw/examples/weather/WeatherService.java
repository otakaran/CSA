package org.pltw.examples.weather;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wdumas on 3/3/16.
 */
public class WeatherService extends IntentService {
    private static final String TAG = "WeatherService";
    private static final int QUERY_INTERVAL = 1000 * 60;
    private Exception error;

    public static Intent newIntent(Context context){
        return new Intent(context, WeatherService.class);
    }

    public static void setServiceAlarm(Context context, boolean isOn) {
        Intent intent = WeatherService.newIntent(context);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager)
                context.getSystemService(Context.ALARM_SERVICE);

        if (isOn) {
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), QUERY_INTERVAL, pendingIntent);
        } else {
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
        }
    }

    public WeatherService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (!isNetworkAvailableAndConnected()) {
            return;
        }
        Log.i(TAG, "Received an intent: " + intent);

        String location = MainActivity.LOCATION;
        String unit = "f";
        String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\") and u='" + unit + "'", location);

        String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));

        try {
            URL url = new URL(endpoint);

            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            JSONObject data = new JSONObject(result.toString());
            JSONObject queryResults = data.optJSONObject("query");

            int count = queryResults.optInt("count");

            if (count == 0) {
                error = new Exception("No weather information found for " + location);
                return;
            }

            JSONObject JSONresult = queryResults.optJSONObject("results").optJSONObject("channel");

            WeatherJSONProcessor weatherJSONProcessor = new WeatherJSONProcessor(JSONresult, MainActivity.LOCATION);

            Resources resources = getResources();
            Intent mainActivityIntent = MainActivity.newIntent(this);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mainActivityIntent, 0);

            Notification notification = new NotificationCompat.Builder(this)
                    .setTicker(resources.getString(R.string.weather_title))
                    .setSmallIcon(android.R.drawable.ic_menu_report_image)
                    .setContentTitle(resources.getString(R.string.weather_title))
                    .setContentText(WeatherConditionals.getWeatherAdvice(weatherJSONProcessor.getTemperature(), weatherJSONProcessor.getCondition()))
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(0, notification);


            Log.d(TAG, "The temp is: " + weatherJSONProcessor.getTemperature());
            Log.d(TAG, "The condition is: " + weatherJSONProcessor.getCondition());
            Log.d(TAG, "The JSON is: " + weatherJSONProcessor.getJson());

        } catch (Exception e) {
            error = e;
            Log.e(TAG, error.toString());
        }
    }

    private boolean isNetworkAvailableAndConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        boolean isNetworkAvailable = connectivityManager.getActiveNetworkInfo() != null;
        boolean isNetworkConnected = isNetworkAvailable &&
                connectivityManager.getActiveNetworkInfo().isConnected();

        return isNetworkConnected;
    }


}
