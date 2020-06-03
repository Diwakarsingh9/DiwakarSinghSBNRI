package com.test.diwakarsinghtest.domain.usecases

import com.test.diwakarsinghtest.pojo.Model
import com.test.diwakarsinghtest.model.DataRepository

class GetLocalData(private val dataRepo: DataRepository) {

    fun getDataFromLocal() : List<Model>?{
        return dataRepo.getLocalData()
    }

    fun updateLastTimeLocal(time: String){
        dataRepo.updateLastTimeLocal(time)
    }

}