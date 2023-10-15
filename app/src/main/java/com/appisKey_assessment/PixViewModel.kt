package com.appisKey_assessment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PixViewModel @Inject constructor (private var pixDataRepo: PixDataRepo) :ViewModel() {
  var livePixList=MutableLiveData<ArrayList<Hits>>()

  init {
      loadPixData()
  }

   fun loadPixData(){
       viewModelScope.launch(Dispatchers.IO) {
           var pixHelper=pixDataRepo.LoadPixData()
           Log.i("TAG", "loadPixData: 34344345v ${pixHelper}")
           //livePixList.postValue(pixHelper.hits)
       }
   }

}