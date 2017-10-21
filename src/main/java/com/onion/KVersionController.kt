package com.onion

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.onion.bean.HttpWrapper
import com.onion.bean.Version
import com.onion.config.VersionConfig
import com.onion.util.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.lang.reflect.Type
import java.util.*


/**
 * Created by OnionMac on 2017/10/18.
 */
@EnableConfigurationProperties
@Controller()
@RequestMapping("version")
class KVersionController {

    @Autowired
    lateinit var versionConfig: VersionConfig

    /**
     * 得到Json路径
     */
    @GetMapping("/getLocation")
    @ResponseBody
    fun getLocation(): String{
        var http: HttpWrapper<VersionConfig> = HttpWrapper()
        http.code = 200
        http.info = "查询成功"
        http.data = versionConfig
        return Gson().toJson(http)
    }

    /**
     * 查询出json文件数据
     */
    @GetMapping("/getJsonContent")
    @ResponseBody
    fun getJsonContent(): String{
        val json: String = FileUtils.getFileJson(versionConfig.location)

        val jsonType: Type = object : TypeToken<ArrayList<Version>>() {
        }.type
        val fromJson = Gson().fromJson<ArrayList<Version>>(json, jsonType)

        /**
         * 封装返回参数
         */
        val http: HttpWrapper<ArrayList<Version>> = HttpWrapper()
        http.code = 200
        http.info = "查询成功"
        http.data = fromJson
        return Gson().toJson(http)
    }

    @PostMapping("/updateVersionList")
    @ResponseBody
    fun updateVersionList(versionList: String): String{
        val result: Int = FileUtils.saveFile(versionConfig.location,versionList)
        val http: HttpWrapper<ArrayList<Version>> = HttpWrapper()
        when(result){
            0 -> {
                http.code = 201
                http.info = "插入失败"
            }
            1 -> {
                http.code = 200
                http.info = "插入成功"
            }
        }

        return Gson().toJson(http)
    }
    
    @GetMapping("/{location}")
    fun versionList(@PathVariable location: String): String{
        return location
    }
}