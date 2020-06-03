package com.test.diwakarsinghtest.model.remote

import com.test.diwakarsinghtest.pojo.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/orgs/octokit/repos?")
    fun getData(@Query("page") page: Int, @Query("per_page") pageSize: Int) : Call<List<Model>>
}