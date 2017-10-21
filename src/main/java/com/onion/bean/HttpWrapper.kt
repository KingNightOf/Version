package com.onion.bean

import java.io.Serializable
import java.util.*

/**
 * Created by OnionMac on 2017/10/18.
 */
data class HttpWrapper<T>(var code: Int,var info: String,var data: T?,var date: String) : Serializable{
    constructor() : this(201,"系统错误",null,Date().toLocaleString())
}