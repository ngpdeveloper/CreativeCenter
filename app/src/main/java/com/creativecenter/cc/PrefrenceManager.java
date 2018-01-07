package com.creativecenter.cc;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 1/7/2018.
 */

public class PrefrenceManager {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    // share prefrence mode
    final int PRIVATE_MODE = 0;

    // sharePrefrence file name
    public static final String PREFRENCE_NAME = "creattive_center.prefs";

    // other prefrence names
    public static final String IS_LOGIN = "login";
    public static final String IS_FIRST_TIME = "isFirstTime";
    public static final String USERID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String EMAIl="email";

    public PrefrenceManager(Context context)
    {
        this.context=context;
        preferences=context.getSharedPreferences(PREFRENCE_NAME,PRIVATE_MODE);
        editor=preferences.edit();
    }

    public void setIsFirstTime(boolean firstTime)
    {
        editor.putBoolean(IS_FIRST_TIME,firstTime);
        editor.commit();
    }

    public boolean getIsFirstTime()
    {
        return preferences.getBoolean(IS_FIRST_TIME,false);
    }
    public void setIsLogin(boolean login)
    {
        editor.putBoolean(IS_LOGIN,login);
        editor.commit();
    }

    public boolean isLogin()
    {
        return preferences.getBoolean(IS_LOGIN,false);
    }
    public void setUserid(String userid)
    {
        editor.putString(USERID,userid);
        editor.commit();
    }

    public String getUserid()
    {
        return preferences.getString(USERID,"");
    }

    public void setUserName(String userName) {
        editor.putString(USER_NAME,userName);
        editor.commit();
    }
    public String getUserName()
    {
        return preferences.getString(USER_NAME,"");
    }
    public void setMobileNumber(String mobileNumber) {
        editor.putString(MOBILE_NUMBER,mobileNumber);
        editor.commit();
    }
    public String getMobileNumber()
    {
        return preferences.getString(MOBILE_NUMBER,"");
    }
}


