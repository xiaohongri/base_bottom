package com.example.base_bottom.mysql_act

import java.io.*
import java.sql.*


class sql_act {
    var conn: Connection? = null
    var stat: Statement? = null
    var preparedStatement: PreparedStatement? = null
    var fileInputStream: FileInputStream? = null
    var url = "jdbc:mysql://47.106.201.10:3306/BDS_utf8?useUnicode=true&characterEncoding=UTF-8&useSSL=false"

    fun select(sql_name: String): ResultSet? {
        var get_image: Blob
        val sql = sql_name
        try {
//
            preparedStatement = conn!!.prepareStatement(sql)
            val resultSet = preparedStatement!!.executeQuery()
            return resultSet
        } catch (e: SQLException) {
            e.printStackTrace()
            return null
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            return null
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
    }

    fun updata(sql_name: String): Int {
        val sql = sql_name
        try {
//
            preparedStatement = conn!!.prepareStatement(sql)
            val resultSet = preparedStatement!!.executeUpdate()
            return resultSet
        } catch (e: SQLException) {
            e.printStackTrace()
            return -1
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            return -2
        } catch (e: IOException) {
            e.printStackTrace()
            return -3
        }
    }

    init {
        try {
            Class.forName("com.mysql.jdbc.Driver")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        try {
            conn = DriverManager.getConnection(url, "root", "p123456")
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}