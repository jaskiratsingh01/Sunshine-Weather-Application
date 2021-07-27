package com.example.sunshineweatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {


    private String mTemperature,mIcon,mCity,mWeatherType;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonobject)
    {
        try{
            weatherData weatherD = new weatherData();
            weatherD.mCity=jsonobject.getString("name");
            weatherD.mCondition=jsonobject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonobject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.mIcon = updateWeatherIcon(weatherD.mCondition);
            double tempResult = jsonobject.getJSONObject("main").getDouble("temp")-273.15;

            int roundedValue = (int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);

            return weatherD;

        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int condition)
    {
        if(condition >= 0 && condition <= 300)
            return "thunderstorm1";

        else if(condition >= 300 && condition <= 600)
            return "lightrain";

        else if(condition >= 600 && condition <= 700)
            return "snow";

        else if(condition >= 701 && condition <= 771)
            return "fog";

        else if(condition >= 772 && condition <= 800)
            return "overcast";

        else if(condition == 800 || condition == 904)
            return "sunny";

        else if(condition >= 801 && condition <= 804)
            return "cloudy";

        else if(condition >= 900 && condition <= 902)
            return "thunderstorm1";

        else if(condition == 903)
            return "snow";

        else if(condition >= 905 && condition <= 1000)
            return "thunderstorm1";

        return "dunno";

    }


    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public String getmIcon() {
        return mIcon;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}
