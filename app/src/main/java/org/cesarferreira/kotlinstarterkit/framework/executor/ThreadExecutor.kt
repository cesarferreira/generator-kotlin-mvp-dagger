package org.cesarferreira.kotlinstarterkit.framework.executor

import io.reactivex.Scheduler

interface ThreadExecutor {
    val newThreadScheduler: Scheduler
    val ioScheduler: Scheduler
    val computationScheduler: Scheduler
}
