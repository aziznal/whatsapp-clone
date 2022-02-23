package com.example.whatsappclone.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * An event that stops emitting as soon as it's been observed
 *
 * @param T: type of event to be fired
 * */
open class SingleLiveEvent<T> : MutableLiveData<T>() {
    private val _isComplete = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) {
            if (_isComplete.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        }
    }

    @MainThread
    override fun setValue(value: T?) {
        _isComplete.set(true)
        super.setValue(value)
    }

    fun call() {
        value = null
    }
}