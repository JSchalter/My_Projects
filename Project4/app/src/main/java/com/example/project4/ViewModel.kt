package com.example.project4

class ViewModel {
    private val API: String = "ce9834b9d2msh35b73155c38ea24p17cb8ajsn01dd3df894a4"
    private val Host: String = "dad-jokes.p.rapidapi.com"


//    val client = OkHttpClient()
//
//    val request = Request.Builder()
//        .url("https://dad-jokes.p.rapidapi.com/joke/search?term=Music%22)
//            .get()
//            .addHeader("X-RapidAPI-Key", "ce9834b9d2msh35b73155c38ea24p17cb8ajsn01dd3df894a4")
//            .addHeader("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com")
//            .build()
//
//            val response = client.newCall(request).execute()

    fun currentJoke(joke:String ) {
       val URLjoke: String = "https://dad-jokes.p.rapidapi.com/joke/search?term=$joke&%22"

    }


}