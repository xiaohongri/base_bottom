package com.example.base_bottom.get_msg_from_msq

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.*

class login_get {
    private val TAG: String? = null


    fun Login(getname: String, pwd: String): String {

        val path = "http://47.106.201.10:8080/BDS/login"

        val params = HashMap<String, String>()//将数据放在map里，便于取出传递
        params["zhanghao"] = getname
        params["passwd"] = pwd
        return sendGETRequest(path, params, "UTF-8")
    }


    private fun sendGETRequest(
        path: String,
        params: Map<String, String>?, encoding: String
    ): String {

        val sb = StringBuilder(path)
        if (params != null && !params.isEmpty()) {
            sb.append("?")
            for ((key, value) in params) {
                //将map数据取出并附在url后面
                sb.append(key).append("=")
                sb.append(URLEncoder.encode(value, encoding))
                sb.append("&")
            }
            sb.deleteCharAt(sb.length - 1)
        }

        val connection = URL(
            sb.toString()
        ).openConnection() as HttpURLConnection
        connection.setRequestProperty("Charset", "UTF-8")
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        println(sb.toString())
        //Log.d(TAG, "sendGETRequest: "+sb.toString());
        //在日志里看一下我们创建完的链接是什么样的
        connection.connectTimeout = 5000
        connection.requestMethod = "GET"
        if (connection.responseCode == 200) {
            val inputStream = connection.inputStream
            var len = 0
            val outStream2 = ByteArrayOutputStream()
            val data = ByteArray(1024)

            do{
                len = inputStream.read(data)
                if (len != -1){
                    outStream2.write(data, 0, len)
                }else{
                    break
                }
            }while (true)



            outStream2.close()
            inputStream.close()
            val responseStr = String(outStream2.toByteArray())
            println(responseStr)
            //Log.v(TAG, "data = " + responseStr);

            return responseStr
        }

        return connection.responseCode.toString()
    }

}
