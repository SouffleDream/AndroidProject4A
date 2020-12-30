package com.esiea.androidproject.presentation.menu.fourth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esiea.androidproject.data.local.models.CatModel
import com.esiea.androidproject.data.repository.CatsRepository
import com.esiea.androidproject.presentation.menu.fourth.CatActivity.Companion.apiKey
import com.esiea.androidproject.presentation.menu.fourth.CatActivity.Companion.serverUrl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.BuildConfig

class CatViewModel : ViewModel() {

    private val compositeDisposableOnDestroy = CompositeDisposable()
    private var latestCatCall: Disposable? = null
    // the list the will be observed by the activity
    val bunchOfCats = MutableLiveData<List<CatModel>>()
    // the error message observed
    val errorMessage = MutableLiveData<String>()

    // the API call
    fun getSomeCats() {
        // initialising the repository class with the necessary information
        val catsRepository =
            CatsRepository(
                serverUrl,
                BuildConfig.DEBUG,
                apiKey
            )

        // stopping the last call if it's already running (optional)
        latestCatCall?.dispose()

        // perform the API call
        // asking for 10 cats. Don't care in what category so just passing null
        latestCatCall =
            catsRepository.getNumberOfRandomCats(10, null).subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    compositeDisposableOnDestroy.add(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    when {
                        result.hasError() -> result.errorMessage?.let {
                            // anyone who observes this will be notified of the change automatically
                            errorMessage.postValue("Error getting cats $it")
                        }
                            ?: run {
                                // anyone who observes this will be notified of the change automatically
                                errorMessage.postValue("Null error :(")
                            }
                        result.hasCats() -> result.netCats?.let {
                            // anyone who observes this will be notified of the change automatically
                            bunchOfCats.postValue(it)
                            // clearing the error if it existed (hacky and optional)
                            errorMessage.postValue("")
                        }
                            ?: run {
                                // anyone who observes this will be notified of the change automatically
                                errorMessage.postValue("Null list of cats :(")
                            }
                        else -> {
                            // anyone who observes this will be notified of the change automatically
                            errorMessage.postValue("No cats available :(")
                        }
                    }
                }
    }

    // clearing the collection of disposables = no memory leaks no matter what
    /*override fun onCleared() {
        compositeDisposableOnDestroy.clear()
        Log.d("TAG", "Clearing ViewModel")
        super.onCleared()
    }*/
}