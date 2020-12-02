package com.example.echarstest

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Time
import java.util.concurrent.TimeUnit

//https://www.cnblogs.com/padding1015/p/9360408.html
//https://www.freesion.com/article/842766794/
//https://www.cnblogs.com/gwkzb/p/12567311.html
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wb.settings?.apply {
            javaScriptEnabled = true

        }
        wb.loadUrl("file:///android_asset/echarts/echarts_pie.html")
        wb.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                val pieTon = """[
                        {value: 335, name: '聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯'},
                        {value: 310, name: '邮件营销'},
                        {value: 234, name: '联盟广告'},
                        {value: 135, name: '视频广告'},
                        {value: 80, name: '百度百度百度百度百度百度百度百度百度百度百度百度百度百度百度百度百度百度'}
                    ]"""
                val pieHold = """[
                        {value: 211, name: '聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯聚乙烯甲苯铣聚丙乙烯'},
                        {value: 210, name: '邮件营销'},
                        {value: 130, name: '联盟广告'},
                        {value: 14, name: '视频广告'},
                        {value: 5, name: '百度百度百度百度百度百度百度百度百度百度百度百度百度百度百度百度百度百度'}
                    ]"""

                val unitStr = "'吨'"
                val call = "javascript:loadPieEcharts(${pieTon}, ${unitStr})"
                wb.loadUrl(call)
            }
        }

        wez.settings?.apply {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
            setSupportZoom(false)
            displayZoomControls = false
        }
        wez.loadUrl("file:///android_asset/echarts/echarts_line.html")

        wez.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                val lineX = """['1/8', '2/8', '3/8', '4/8', '5/8', '6/8', '7/8']"""
                val stockOut = """[120, 200, 101, 134, 900, 230, 210]"""
                val stockIn = """[220, 100, 191, 234, 290, 330, 310]"""

                val call = "javascript:loadLineEcharts(${lineX},${stockOut}, ${stockIn})"
                wez.loadUrl(call)
            }
        }
    }
}