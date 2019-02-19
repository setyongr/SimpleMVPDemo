package com.proclub.simplemvpdemo.data

import android.os.Handler

object FakeQuotesDatabase {
    private val quotes = mutableListOf<Quote>()

    private val handler = Handler()

    fun getQuotes(callback: (List<Quote>) -> Unit) {
        handler.postDelayed({
            callback(quotes)
        }, 2000)
    }

    fun addQuotes(quote: Quote) {
        quotes.add(quote)
    }

    fun clearQuotes() {
        quotes.clear()
    }
}