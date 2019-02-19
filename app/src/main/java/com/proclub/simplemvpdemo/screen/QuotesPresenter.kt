package com.proclub.simplemvpdemo.screen

import com.proclub.simplemvpdemo.base.MVPPresenter
import com.proclub.simplemvpdemo.data.FakeQuotesDatabase
import com.proclub.simplemvpdemo.data.Quote

class QuotesPresenter: MVPPresenter<QuotesView>() {
    fun addQuotes(message: String) {
        FakeQuotesDatabase.addQuotes(Quote(message))
        getQuotes()
    }

    fun clearQuotes() {
        FakeQuotesDatabase.clearQuotes()
        getQuotes()
    }

    fun getQuotes() {
        withView { showHideProgress(true) }
        FakeQuotesDatabase.getQuotes { quotes ->
            withView {
                showHideProgress(false)
                if (quotes.isEmpty()) {
                    showEmptyQuotes()
                } else {
                    showQuotes(quotes)
                }
            }
        }
    }
}