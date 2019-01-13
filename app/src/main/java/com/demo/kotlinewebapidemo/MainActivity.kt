package com.demo.kotlinewebapidemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.demo.kotlinewebapidemo.webservice.WebClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webclient=WebClient.Factory.create();

        compositeDisposable.add(
                webclient.getContactList()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            reponseBody->
                            reponseBody.contacts!!.size;

                            for (contact in reponseBody.contacts){
                                Log.d("test", "Name  ${contact!!.name}")
                                Log.d("test", "Email  ${contact!!.email}")

                            }
                           /* result ->
                            Log.d("test", "Name of Contact  ${result.contacts!!.size}")*/


                        }, { error ->
                            error.printStackTrace()
                        }))

        /*
        compositeDisposable.add(
                repository.searchUsers("Lagos", "Java")
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            result ->
                            Log.d("Result", "There are ${result.items.size} Java developers in Lagos")
                        }, { error ->
                            error.printStackTrace()
                        })
        )*/
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
