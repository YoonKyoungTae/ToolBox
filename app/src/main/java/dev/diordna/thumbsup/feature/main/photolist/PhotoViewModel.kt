package dev.diordna.thumbsup.feature.main.photolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.diordna.thumbsup.data.photo.PhotoRepository
import dev.diordna.thumbsup.data.photo.model.PhotoApiModel
import dev.diordna.thumbsup.data.user.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _photoList: MutableLiveData<ArrayList<PhotoApiModel>> = MutableLiveData()
    val photoList
        get() = _photoList

    fun requestPhotoList() {
        viewModelScope.launch {
            val photoList = photoRepository.fetchPhotoList()
            _photoList.value = photoList
        }
    }

}