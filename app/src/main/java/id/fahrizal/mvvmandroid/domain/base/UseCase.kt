package id.fahrizal.mvvmandroid.domain.base

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version UseCase, v 0.1 26/01/22 01.46 by Fahrizal Sentosa
 */
interface UseCase<T> {

    fun execute(): T
}