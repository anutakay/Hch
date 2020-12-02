package ru.anutakay.hch.presentation.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Flowable
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutId(), container, false)

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    inline fun <reified T : ViewModel> viewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit): T {
        val vm = ViewModelProvider(this, factory)[T::class.java]
        vm.body()
        return vm
    }

    protected fun <T> Flowable<T>.observe(o: (T) -> Unit) {
        RxLifecycleHandler(this@BaseFragment, this, o)
    }
}