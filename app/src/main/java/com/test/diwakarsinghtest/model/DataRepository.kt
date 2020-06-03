package com.test.diwakarsinghtest.model

import androidx.lifecycle.LiveData
import com.test.diwakarsinghtest.pojo.Model
import com.test.diwakarsinghtest.model.local.LocalSource
import com.test.diwakarsinghtest.model.remote.RemoteSource

class DataRepository(private val local: LocalSource, private val remote: RemoteSource) {

    fun getLocalData() : List<Model>? = local.getLocalData()
    fun updateLastTimeLocal(time: String) = local.updateLastTime(time)
    fun getRemoteData(page:Int) : LiveData<List<Model>> = remote.getRemoteData(page)
}