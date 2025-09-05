package com.kruma.core.service.entity.converter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by John on 22/07/2016.
 */
public class DotNetDateConverter implements JsonDeserializer<Date>
{

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        String str_Date = json.getAsJsonPrimitive().getAsString();
        long lng_Date = Long.parseLong(str_Date.substring(str_Date.indexOf("(")+1, (str_Date.indexOf("-")==-1?str_Date.indexOf("+"):str_Date.indexOf("-"))));
        Date dt_Date = new Date(lng_Date);
        return dt_Date;
    }
}