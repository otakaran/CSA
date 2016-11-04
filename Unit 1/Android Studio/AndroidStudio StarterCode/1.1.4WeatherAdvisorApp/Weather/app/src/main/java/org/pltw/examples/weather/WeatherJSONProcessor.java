package org.pltw.examples.weather;

import org.json.JSONObject;

/**
 * Created by wdumas on 3/3/16.
 */
public class WeatherJSONProcessor {

    private String temperature;
    private String condition;
    private String json;
    private String location;

    public WeatherJSONProcessor(JSONObject jsonObject, String location) {
        temperature = jsonObject.optJSONObject("item").optJSONObject("condition").optString("temp");
        condition = jsonObject.optJSONObject("item").optJSONObject("condition").optString("text");
        json = jsonObject.toString();
        this.location = location;
    }

    public int getTemperature() {
        return new Integer(temperature);
    }

    public String getCondition() {
        return condition;
    }

    public String getJson() {
        return json;
    }

    public String getLocation() {
        return location;
    }
}
