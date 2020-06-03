package com.test.diwakarsinghtest.pojo

class License {
    var name: String? = null
    var spdx_id: String? = null
    var key: String? = null
    var url: String? = null
    var node_id: String? = null

    override fun toString(): String {
        return "ClassPojo [name = $name, spdx_id = $spdx_id, key = $key, url = $url, node_id = $node_id]"
    }
}