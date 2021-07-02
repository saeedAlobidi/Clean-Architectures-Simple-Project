package com.example.clean_architectures_simple_project.presentation.core

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//------------------------------------------------------------------------------
// <auto-generated>
//   name :saeed mohammed alabidi
//  Email:saeed1adm@gmail.com
//  Phone:00967-733122038
// </auto-generated>
//------------------------------------------------------------------------------

abstract class BaseCustomActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var job: Job


    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job();
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()

    }

}


abstract class BaseCustomFragment : Fragment(), CoroutineScope {
    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}

abstract class BaseCustomViewModel() : ViewModel()


fun <R> BaseCustomActivity.ActivityLaunch(Block: suspend () -> R) {

    launch {
        try {
            Block()
        } catch (e: Exception) {
            Error::set
        }

    }

}


fun <R> BaseCustomViewModel.ViewModelLaunch(Block: suspend () -> R) {

    viewModelScope.launch {
        try {
            Block()
        } catch (e: Exception) {
            Error::set
        }

    }

}




