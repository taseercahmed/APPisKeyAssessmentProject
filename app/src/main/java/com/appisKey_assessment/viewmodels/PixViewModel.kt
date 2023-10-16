package com.appisKey_assessment.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appisKey_assessment.data.Hits
import com.appisKey_assessment.data.repos.PixDataRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
           livePixList.postValue(pixHelper.body()?.hits)
       }
   }

    fun setSelectedHit(hits: Hits){
        pixDataRepo.setSelectedHit(hits)
    }
    fun getSelectedHit(): Hits? {
        return pixDataRepo.getSelectedHit()
    }

}