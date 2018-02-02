package org.cesarferreira.kotlinstarterkit.framework.executor


import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

@Singleton
class UIThread @Inject
internal constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}