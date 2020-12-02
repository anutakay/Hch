package ru.anutakay.hch.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.anutakay.hch.presentation.editor.rmvvm.EditorViewModel
import ru.anutakay.hch.presentation.ui.picture.PictureViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PictureViewModel::class)
    abstract fun pictureViewModel(viewModel: PictureViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditorViewModel::class)
    abstract fun bindsEditorViewModel(viewModel: EditorViewModel): ViewModel
}