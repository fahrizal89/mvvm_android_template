package id.fahrizal.mvvmandroid.domain.base

interface UseCase<T, U> {

    fun execute(param: T): U
}