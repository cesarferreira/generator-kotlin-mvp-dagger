package cesarferreira.movies.presentation.framework.extensions

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

class Fragments{}
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
        beginTransaction().func().commit()
