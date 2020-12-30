package com.esiea.androidproject.presentation.menu.fourth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.esiea.androidproject.R
import com.esiea.androidproject.data.local.models.CatModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cats.*

class CatActivity : AppCompatActivity() {


    // public static fields in a companion object because im a horrible person
    companion object {
        // the server url endpoint
        const val serverUrl = "https://api.thecatapi.com/v1/"
        // this is where you declare your api key
        const val apiKey = "R.string.GOOGLE_API_KEY.toString()"
    }

    private lateinit var viewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats)
        title = "Cat"
        // setting up viewModel
        viewModel = ViewModelProviders.of(this).get(CatViewModel::class.java)

        // observing the stuff we are interested about.
        // any change observed will run the corresponding method
        viewModel.bunchOfCats.observe(this, Observer { onResult(it) })
        viewModel.errorMessage.observe(this, Observer { onError(it) })

        // click listener so you can perform the API call manually
         viewModel.getSomeCats()
    }

    /**
     * Method triggered when we observe a change in MainViewModel.bunchOfCats MutableLiveData
     * @param bunchOfCats An updated list of cats we got from the API
     */
    private fun onResult(bunchOfCats: List<CatModel>) {
        val randomNumber = (0..bunchOfCats.size).shuffled().first()
        Picasso.get()
            .load(bunchOfCats[randomNumber].url)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .fit()
            .into(catView)
        Toast.makeText(this, "Got ${bunchOfCats.size} cats he's one of then", Toast.LENGTH_SHORT).show()
    }

    /**
     * Method triggered when we observe a change in MainViewModel.errorMessage MutableLiveData
     * @param error Error message describing what went wrong
     */
    private fun onError(error: String) {
        // a simple toast in case things went wrong
        error.let {
            if (!it.isBlank()) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }

        }
    }
}