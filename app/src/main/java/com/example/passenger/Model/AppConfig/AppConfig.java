package com.example.passenger.Model.AppConfig;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {
    public static String Email;
    public static String Password;
    public static String IPAddress;
    public static String IPPort;

    public static void Save(Context ctx)
    {
        SharedPreferences sharedLoginPreferences = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedLoginPreferences.edit();
        editor.putString("Email", String.valueOf(Email));
        editor.putString("Password", String.valueOf(Password));
        editor.apply();
    }
    public static void Load(Context ctx)
    {
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        Email = sp.getString("Email", "");
        Password = sp.getString("Password", "");
        IPAddress = sp.getString("IPAddress", "");
        IPPort = sp.getString("IPPort", "");

    }
}
