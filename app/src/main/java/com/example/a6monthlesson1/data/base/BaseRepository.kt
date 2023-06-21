package com.example.a6monthlesson1.data.base


abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage ?: "unknown error"))
//                emit(Resource.Error(
//                    if (e.localizedMessage != null){
//                        e.localizedMessage
//                    }else{
//                        "unknow error"
//                    }
//                ))
        }
    }.flowOn(Dispatchers.IO)

}