package dev.diordna.thumbsup.feature.main.photolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.diordna.thumbsup.databinding.ListItemPhotoBinding
import dev.diordna.thumbsup.data.photo.model.PhotoApiModel

class PhotoListAdapter : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    var photoList: ArrayList<PhotoApiModel> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(photoList[position])
    }

    override fun getItemCount(): Int = photoList.size

    class ViewHolder(private val binding: ListItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun binding(photo: PhotoApiModel) {
            binding.photo = photo
        }

    }

}