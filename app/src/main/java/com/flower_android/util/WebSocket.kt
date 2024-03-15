package com.flower_android.util

import com.flower_android.WebSocketListener
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

object WebSocket {
    private lateinit var client: OkHttpClient
    private lateinit var ws: WebSocket

    fun createWs() {
        client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("ws://flower.onleave.co.kr:9000/flower/ws/order")
            .build()
        val listener: WebSocketListener = WebSocketListener()
        ws = client.newWebSocket(request, listener)
    }

    fun deleteWs(){
        ws.cancel()
        client.dispatcher.executorService.shutdown()
    }
    
    fun send() {
        val info = """{ "type": "UPDATE_ORDERS" }"""
        val toast = """{ "type": "UPDATE_ORDERS_TOAST" }"""
        ws.send(info)
        ws.send(toast)
    }
}