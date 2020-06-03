package com.test.diwakarsinghtest.model.remote

import androidx.lifecycle.LiveData
import com.test.diwakarsinghtest.pojo.Model

class Remote(i: Int) : RemoteSource {

    override fun getRemoteData(page:Int): LiveData<List<Model>> {
        val getNetworkData = GetNetworkData()
        return getNetworkData.getRemoteData(page)
    }
}