package ru.anutakay.hch.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.anutakay.hch.MainActivity

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [])
    internal abstract fun get(): MainActivity
}