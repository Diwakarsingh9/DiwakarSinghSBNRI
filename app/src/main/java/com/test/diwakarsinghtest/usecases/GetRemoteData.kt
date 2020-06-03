package com.test.diwakarsinghtest.domain.usecases

import androidx.lifecycle.LiveData
import com.test.diwakarsinghtest.pojo.Model
import com.test.diwakarsinghtest.model.DataRepository

class GetRemoteData(private val dataRepo: DataRepository) {

    fun getDataFromRemote(page:Int) : LiveData<List<Model>>{
        return dataRepo.getRemoteData(page)
    }
}