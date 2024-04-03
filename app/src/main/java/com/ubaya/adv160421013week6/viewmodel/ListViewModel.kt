package com.ubaya.adv160421013week6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.ubaya.adv160421013week6.model.Operator

    class ListViewModel(application: Application) : AndroidViewModel(application) {
        val operatorsLD = MutableLiveData<ArrayList<Operator>>()
        val operatorLoadErrorLD = MutableLiveData<Boolean>()
        val loadingLD = MutableLiveData<Boolean>()

        val TAG = "volleyTag"
        private var queue: RequestQueue? = null
        fun refresh() {
            operatorLoadErrorLD.value = false
            loadingLD.value = true
            queue = Volley.newRequestQueue(getApplication())
            val url = "http://192.168.1.9/operators.json"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
                    val sType = object : TypeToken<List<Operator>>() { }.type
                    val result = Gson().fromJson<List<Operator>>(it, sType)
                    operatorsLD.value = result as ArrayList<Operator>?
                    loadingLD.value = false
                    Log.d("showvoley", it)
                },
                {
                    Log.d("showvoley", it.toString())
                    operatorLoadErrorLD.value = false
                    loadingLD.value = false
                })

            stringRequest.tag = TAG
            queue?.add(stringRequest)

            operatorLoadErrorLD.value = false
            loadingLD.value = true
        }

    }



