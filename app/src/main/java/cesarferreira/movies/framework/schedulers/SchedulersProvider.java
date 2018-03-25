package cesarferreira.movies.framework.schedulers;

import io.reactivex.Scheduler;

public interface SchedulersProvider {

    Scheduler mainThread();

    Scheduler io();

    Scheduler computation();
}
