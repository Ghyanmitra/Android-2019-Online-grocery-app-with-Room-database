package org.meicode.meimall.DatabaseFiles;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.meicode.meimall.Models.Review;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataConverter {

    @TypeConverter
    public ArrayList<Review> jsonToList (String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Review>>(){}.getType();
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public String listToJson(ArrayList<Review> reviews) {
        Gson gson = new Gson();
        return gson.toJson(reviews);
    }
}
