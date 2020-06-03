package com.test.diwakarsinghtest.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.test.diwakarsinghtest.pojo.Model
import com.test.diwakarsinghtest.domain.usecases.GetLocalData
import com.test.diwakarsinghtest.domain.usecases.GetRemoteData
import com.test.diwakarsinghtest.model.DataRepository
import com.test.diwakarsinghtest.model.local.Local
import com.test.diwakarsinghtest.model.local.Database
import com.test.diwakarsinghtest.model.remote.Remote
import java.text.SimpleDateFormat
import java.util.*

class RetroViewModel : ViewModel() {

    val dataRepo = DataRepository(Local(),Remote(0))
    val localData = GetLocalData(dataRepo)
    val remoteData = GetRemoteData(dataRepo)

    fun fetchRemoteData(page:Int): LiveData<List<Model>> {
        return remoteData.getDataFromRemote(page)
    }

    fun calculateCurrentTime(): String {
        return SimpleDateFormat("hh:mm:ss aa").format(Date())
    }

    fun updateLastTime(time: String){
        localData.updateLastTimeLocal(time)
    }

    fun updateIsFirstFlag(){
        Database.getPreferenceInstance()?.updateFirstTime()
    }

    fun  isFirstTimeAppLaunch(): Boolean? {
        return Database.getPreferenceInstance()?.isFirstTime()
    }

    fun calculateTimeDifference(time: String): Int {
        val format = SimpleDateFormat("hh:mm:ss aa")
        val firstTime = format.parse(time)
        val secondTime = format.parse(Database.getPreferenceInstance()?.getLastTime())
        val mills: Long = firstTime.time - secondTime.time
        return (mills/(1000 * 60 * 60)).toInt()
    }

    fun saveDataInLocal(data : List<Model>){
        Database.getPreferenceInstance()?.saveDataInLocal(data)
    }

    fun getDataFromLocal(): List<Model>?{
        return localData.getDataFromLocal()
    }
}