package com.onion.util

import java.io.File

/**
 * Created by OnionMac on 2017/10/18.
 */
object FileUtils {
    /**
     * 读取文档内容
     */
    fun getFileJson(location: String): String {
        return  File(location).readText()
    }

    fun saveFile(location: String,toJson: String): Int {
        try {
            File(location).writeText(toJson)
        }catch (e: Exception){
            e.printStackTrace()
            return 0
        }
        return 1
    }
}