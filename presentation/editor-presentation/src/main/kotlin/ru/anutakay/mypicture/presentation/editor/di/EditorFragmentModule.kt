package ru.anutakay.mypicture.presentation.editor.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.anutakay.mypicture.presentation.editor.EditorFragment

@Module
abstract class EditorFragmentModule {

    @EditorScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun get(): EditorFragment
}