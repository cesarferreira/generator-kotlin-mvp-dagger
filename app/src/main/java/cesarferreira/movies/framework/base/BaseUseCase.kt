package cesarferreira.movies.framework.base

abstract class BaseUseCase<out Type, in Params> where Type : Any {
    abstract fun buildUseCase(params: Params): Type

    class None
}