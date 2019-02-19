package com.proclub.simplemvpdemo.screen

import com.proclub.simplemvpdemo.base.MVPView
import com.proclub.simplemvpdemo.data.Quote

interface QuotesView: MVPView {
    fun showQuotes(quotes: List<Quote>)

    fun showEmptyQuotes()

    fun showHideProgress(show: Boolean)
}