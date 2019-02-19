package com.proclub.simplemvpdemo.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.proclub.simplemvpdemo.R
import com.proclub.simplemvpdemo.data.Quote
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity: AppCompatActivity(), QuotesView {
    private val presenter = QuotesPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        presenter.attachView(this)
        presenter.getQuotes()

        initListener()
    }

    private fun initListener() {
        buttonAdd.setOnClickListener {
            presenter.addQuotes(textQuote.text.toString())
        }

        buttonClear.setOnClickListener {
            presenter.clearQuotes()
        }
    }

    override fun showQuotes(quotes: List<Quote>) {
        quotesContainer.text = quotes.joinToString(separator = "\n" ) { it.message }
    }

    override fun showEmptyQuotes() {
        quotesContainer.text = getString(R.string.no_quotes_message)
    }

    override fun showHideProgress(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
        quotesContainer.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }
}