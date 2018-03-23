package org.cesarferreira.kotlinstarterkit.presentation.framework.extensions

import java.util.*

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start