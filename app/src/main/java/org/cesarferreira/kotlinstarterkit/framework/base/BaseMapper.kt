package org.cesarferreira.kotlinstarterkit.framework.base

abstract class BaseMapper<in SOURCE, out TARGET> {

    /**
     * Transforms a type into another
     *
     * @param toBeTransformed source that will be transformed
     * @return the transformed object
     */
    abstract fun transform(toBeTransformed: SOURCE): TARGET

    /**
     * Transforms a list of types into another type
     *
     * @param list list of sources that will be transformed
     * @return the list of transformed objects
     */
    fun transform(list: List<SOURCE>): List<TARGET> = list.map { transform(it) }

}
