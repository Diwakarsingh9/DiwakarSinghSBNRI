package com.test.diwakarsinghtest.model.local

import com.test.diwakarsinghtest.pojo.Model

class Local : LocalSource {

    override fun getLocalData(): List<Model>? {
        return Database.getPreferenceInstance()?.getDataFromLocal()
    }

    override fun updateLastTime(time: String) {
        Database.getPreferenceInstance()?.saveLastTime(time)
    }
}