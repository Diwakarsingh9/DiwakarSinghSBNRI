package com.test.diwakarsinghtest.pojo

class Permissions {
    var pull: String? = null
    var admin: String? = null
    var push: String? = null

    override fun toString(): String {
        return "ClassPojo [pull = $pull, admin = $admin, push = $push]"
    }
}