package ru.anutakay.mypicture.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.anutakay.mypicture.MainActivity

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [])
    internal abstract fun get(): MainActivity
}