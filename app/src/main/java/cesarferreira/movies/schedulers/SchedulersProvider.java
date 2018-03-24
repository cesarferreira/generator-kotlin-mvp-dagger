package cesarferreira.movies.schedulers;

import io.reactivex.Scheduler;

public interface SchedulersProvider {

    Scheduler mainThread();

    Scheduler io();

    Scheduler computation();
}
