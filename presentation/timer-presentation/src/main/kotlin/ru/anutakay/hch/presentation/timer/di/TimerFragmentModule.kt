package ru.anutakay.hch.presentation.timer.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.anutakay.hch.presentation.timer.TimerFragment

@Module
abstract class TimerFragmentModule {

    @TimerScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun get(): TimerFragment
}