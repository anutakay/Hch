package ru.anutakay.hch.presentation.login.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.anutakay.hch.presentation.login.LoginFragment

@Module
abstract class LoginFragmentModule {

    @LoginScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun get(): LoginFragment
}