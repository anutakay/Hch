package ru.anutakay.mypicture.presentation.timer.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.anutakay.mypicture.presentation.timer.TimerFragment

@Module
abstract class TimerFragmentModule {

    @TimerScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun get(): TimerFragment
}