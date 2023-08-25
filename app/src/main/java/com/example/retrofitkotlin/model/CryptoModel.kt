package com.example.retrofitkotlin.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    //@SerializedName("currency")  // çektiğimiz verideki isimle verdiğimiz isim aynı olmazsa kullanılacak
    val currency: String,
    //@SerializedName("price")
    val price : String)
