package com.test.diwakarsinghtest.model.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.diwakarsinghtest.pojo.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetNetworkData {

    var remoteDataMutableList: MutableLiveData<List<Model>> = MutableLiveData()

    fun getRemoteData(page:Int) : LiveData<List<Model>>{
        ApiClient.getApiClient()?.create(ApiInterface::class.java)?.getData(page,10)
            ?.enqueue(object :Callback<List<Model>>{
                override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                    remoteDataMutableList.postValue(null)
                }

                override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                    var ModelList = response.body()
                    remoteDataMutableList.postValue(ModelList)
                }
            })
        return remoteDataMutableList
    }
}