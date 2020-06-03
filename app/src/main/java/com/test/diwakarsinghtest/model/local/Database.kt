package com.test.diwakarsinghtest.model.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.diwakarsinghtest.pojo.Model
import com.test.diwakarsinghtest.utils.CustomApplication
import com.test.diwakarsinghtest.utils.Util
import java.lang.reflect.Type

class Database {

    companion object {
        @Volatile
        private var mPreference: Database? = null
        private var mSharedPreferences: SharedPreferences? = null

        fun getPreferenceInstance(): Database? {
            synchronized(Database::class.java) {
                if (mPreference == null) {
                    mPreference = Database()
                }
            }
            return mPreference
        }

        @Synchronized
        fun getSharedPreference(): SharedPreferences? {
            if (mSharedPreferences == null) {
                mSharedPreferences = CustomApplication.getAppContext()
                    .getSharedPreferences(
                        Util.CACH_FILE,
                        Context.MODE_PRIVATE
                    )
            }
            return mSharedPreferences
        }
    }

    fun saveDataInLocal(list: List<Model>?){
        getSharedPreference()?.edit()?.putString( Util.CACH_KEY, Gson().toJson(list))?.apply()
    }

    fun getDataFromLocal(): List<Model>?{
        val type: Type = object : TypeToken<List<Model>?>() {}.getType()
        return Gson().fromJson(getSharedPreference()?.getString( Util.CACH_KEY,""), type)
    }

    fun isFirstTime(): Boolean? {
        return getSharedPreference()?.getBoolean(Util.IS_FIRST_TIME,true)
    }

    fun updateFirstTime() {
        getSharedPreference()?.edit()?.putBoolean(Util.IS_FIRST_TIME,false)?.apply()
    }

    fun saveLastTime(time: String){
        getSharedPreference()?.edit()?.putString(Util.LAST_TIME,time)?.apply()
    }

    fun getLastTime(): String? {
        return getSharedPreference()?.getString(Util.LAST_TIME,"")
    }

}