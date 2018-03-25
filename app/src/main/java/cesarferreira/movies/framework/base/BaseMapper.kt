package cesarferreira.movies.framework.base

abstract class BaseMapper<in SOURCE, out TARGET> {

    /**
     * Transforms a type into another
     *
     * @param source source that will be transformed
     * @return the transformed object
     */
    abstract fun transform(source: SOURCE): TARGET

    /**
     * Transforms a list of types into another type
     *
     * @param list list of sources that will be transformed
     * @return the list of transformed objects
     */
    fun transform(list: List<SOURCE>): List<TARGET> = list.map { transform(it) }

}
