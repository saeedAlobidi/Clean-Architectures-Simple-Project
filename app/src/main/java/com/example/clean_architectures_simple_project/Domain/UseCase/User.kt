package com.example.clean_architectures_simple_project.Domain.UseCase
//------------------------------------------------------------------------------
// <auto-generated>
//   name :saeed mohammed alabidi
//  Email:saeed1adm@gmail.com
//  Phone:00967-733122038
// </auto-generated>
//------------------------------------------------------------------------------


import android.util.Log
import com.example.clean_architectures_simple_project.Domain.withSuspendDomain
import com.example.clean_architectures_simple_project.Gateway.Database.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


suspend fun getUserAll() = withSuspendDomain {
    internalGateway.getUserAll()
}


suspend fun loadData(id: Int, context: CoroutineContext = Dispatchers.IO) = withSuspendDomain {

    withContext(context) {
        val data = internalGateway.getUserAsync(id).await();
        internalGateway.setUser(Users (data.userId,data.title,data.completed) );
    }


}
