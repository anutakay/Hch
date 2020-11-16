package ru.anutakay.mypicture.presentation.editor.rmvvm

import ru.anutakay.mypicture.presentation.common.Action

sealed class EditorAction : Action

class SetPercentageAction(val percentage: Int) : EditorAction()