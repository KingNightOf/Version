package com.onion.bean

import java.io.Serializable

/**
 * Created by OnionMac on 2017/10/18.
 */
data class Version(var id: Int,var isForceUpdate: Int,
                   var isHasNewVersion: Int,var name: String,
                   var version: String) : Serializable{

    constructor() : this(0,0,0,IOS,VERSION)

    companion object{
        val IOS: String = "ios"
        val ANDROID: String = "android"
        val VERSION: String = "1.0.0"
    }
}