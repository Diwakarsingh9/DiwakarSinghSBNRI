package com.test.diwakarsinghtest.model.local

import com.test.diwakarsinghtest.pojo.Model


interface LocalSource {
    fun getLocalData(): List<Model>?
    fun updateLastTime(time: String)
}