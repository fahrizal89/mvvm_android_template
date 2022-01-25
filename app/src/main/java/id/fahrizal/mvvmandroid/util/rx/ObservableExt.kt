package id.fahrizal.mvvmandroid.util.rx

import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DefaultObserver
import io.reactivex.schedulers.Schedulers

object ObservableExt {

    fun <T> Single<T>.observe(simpleSingleObserver: SimpleSingleObserver<T>? = null): Single<T> {
        val single = subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        if (simpleSingleObserver != null) {
            single.subscribe(simpleSingleObserver)
        } else {
            single.subscribe()
        }
        return this
    }

    fun <T> Observable<T>.execute(observer: DefaultObserver<T>? = null): Observable<T> {
        val observable = subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        if (observer != null) {
            observable.subscribe(observer)
        } else {
            observable.subscribe()
        }
        return this
    }

    fun Completable.execute(observer: CompletableObserver? = null): Completable {
        val single = subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        if (observer != null) {
            single.subscribe(observer)
        } else {
            single.subscribe()
        }
        return this
    }
}