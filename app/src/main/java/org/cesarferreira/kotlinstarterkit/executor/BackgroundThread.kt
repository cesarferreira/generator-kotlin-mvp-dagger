package org.cesarferreira.kotlinstarterkit.executor

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BackgroundThread @Inject
internal constructor() : ThreadExecutor {

    override val newThreadScheduler: Scheduler
        get() = Schedulers.newThread()

    override val ioScheduler: Scheduler
        get() = Schedulers.io()

    override val computationScheduler: Scheduler
        get() = Schedulers.computation()
}