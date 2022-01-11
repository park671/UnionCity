package com.extendsoft.nfcpayapp.util;

import com.extendsoft.nfcpayapp.util.ByteHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JSONUtils {

   private static GsonBuilder builder = (new GsonBuilder()).setDateFormat(1).registerTypeAdapter(Date.class, new JSONUtils.UtilDateSerializer((JSONUtils.UtilDateSerializer)null)).registerTypeAdapter(Calendar.class, new JSONUtils.UtilCalendarSerializer((JSONUtils.UtilCalendarSerializer)null)).registerTypeAdapter(GregorianCalendar.class, new JSONUtils.UtilCalendarSerializer((JSONUtils.UtilCalendarSerializer)null)).setDateFormat(1).setPrettyPrinting();


   public static String appendElement(String var0, String var1) {
      return var0.substring(0, var0.length() - 1) + "," + var1 + "}";
   }

   public static Object fromJson(String var0, TypeToken var1) {
      return fromJson(var0, var1.getType());
   }

   public static Object fromJson(String var0, Class var1) {
      return getGosn().fromJson(var0, var1);
   }

   public static Object fromJson(String var0, Type var1) {
      return getGosn().fromJson(var0, var1);
   }

   public static Object fromJson(byte[] var0, TypeToken var1) {
      return fromJson(ByteHelper.BytesToString(var0), var1);
   }

   public static Object fromJson(byte[] var0, Type var1) {
      return fromJson(ByteHelper.BytesToString(var0), var1);
   }

   private static Gson getGosn() {
      return builder.create();
   }

   public static String insertElement(String var0, String var1) {
      return "{" + var1 + "," + var0.replaceFirst("\\{", "");
   }

   public static String toJson(Object var0) {
      return getGosn().toJson(var0);
   }

   public static String toJson(Object var0, Type var1) {
      return getGosn().toJson(var0, var1);
   }

   public static byte[] toJsonBytes(Object var0) {
      return toJsonBytes(var0, var0.getClass());
   }

   public static byte[] toJsonBytes(Object var0, Type var1) {
      return ByteHelper.StringToBytes(toJson(var0, var1));
   }

   public static String toJsonWithoutBlank(Object var0) {
      return toJson(var0).replaceAll("\\s|\n", "");
   }

   private static class UtilCalendarSerializer implements JsonSerializer, JsonDeserializer {

      private UtilCalendarSerializer() {}

      // $FF: synthetic method
      UtilCalendarSerializer(JSONUtils.UtilCalendarSerializer var1) {
         this();
      }

      public Calendar deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         Calendar var4 = Calendar.getInstance();
         var4.setTimeInMillis(var1.getAsJsonPrimitive().getAsLong());
         return var4;
      }

      public JsonElement serialize(Calendar var1, Type var2, JsonSerializationContext var3) {
         return new JsonPrimitive(Long.valueOf(var1.getTimeInMillis()));
      }

      @Override
      public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
         return null;
      }
   }

   private static class UtilDateSerializer implements JsonSerializer, JsonDeserializer {

      private UtilDateSerializer() {}

      // $FF: synthetic method
      UtilDateSerializer(JSONUtils.UtilDateSerializer var1) {
         this();
      }

      public Date deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return new Date(var1.getAsJsonPrimitive().getAsLong());
      }

      public JsonElement serialize(Date var1, Type var2, JsonSerializationContext var3) {
         return new JsonPrimitive(Long.valueOf(var1.getTime()));
      }

      @Override
      public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
         return null;
      }
   }
}
