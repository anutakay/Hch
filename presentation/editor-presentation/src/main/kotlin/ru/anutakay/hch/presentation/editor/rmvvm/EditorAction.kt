package ru.anutakay.hch.presentation.editor.rmvvm

import ru.anutakay.hch.presentation.common.Action

sealed class EditorAction : Action

class SetPercentageAction(val percentage: Int, val fromUser: Boolean) : EditorAction()