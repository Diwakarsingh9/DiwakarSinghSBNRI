package com.test.diwakarsinghtest.model.remote

import androidx.lifecycle.LiveData
import com.test.diwakarsinghtest.pojo.Model

interface RemoteSource {
    fun getRemoteData(page:Int): LiveData<List<Model>>
}