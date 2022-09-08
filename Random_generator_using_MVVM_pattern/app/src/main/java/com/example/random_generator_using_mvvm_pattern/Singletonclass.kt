package com.example.random_generator_using_mvvm_pattern

class Singletonclass private constructor() {
    private lateinit var viewModel:RandomViewModel
    fun setState(model: RandomViewModel){
        viewModel  = model;
    }
    fun getState(): RandomViewModel{
        return viewModel
    }
    init {
    }
    companion object : SingletonHolder<Singletonclass>(::Singletonclass)
}

open class SingletonHolder<out T: Any>(constructor: () -> T) {
    private var constructor: (() -> T)? = constructor
    private var instance: T? = null
    fun getInstance(): T {
        if (instance != null) {
            return instance!!
        }else {
            instance = constructor!!()
            constructor = null
            return instance!!
        }

    }
}