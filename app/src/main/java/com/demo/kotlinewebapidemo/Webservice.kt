package com.demo.kotlinewebapidemo

import com.demo.kotlinewebapidemo.reponse.ContactReponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Webservice {
    @GET("contacts/")
    fun getContactList() : Observable<ContactReponse>

   /* @retrofit2.http.GET("search/users")
    fun search(@retrofit2.http.Query("q") query: String,
               @retrofit2.http.Query("page") page: Int = 1,
               @retrofit2.http.Query("per_page") perPage: Int = 20): io.reactivex.Observable<Result>
*/

}