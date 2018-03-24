package cesarferreira.movies.presentation.framework.extensions

import java.util.*

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start