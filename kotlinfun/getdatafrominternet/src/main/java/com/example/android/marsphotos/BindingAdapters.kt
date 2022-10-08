package com.example.android.marsphotos

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.model.MarsPhoto
import com.example.android.marsphotos.model.NetworkStatus
import com.example.android.marsphotos.overview.PhotoGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, url: String?) {
    url?.let {
        val uri = url.toUri().buildUpon().scheme("https").build()

        imageView.load(uri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }

        // This works but only for the loading image
        DrawableCompat.setTint(
            DrawableCompat.wrap(imageView.drawable),
            ContextCompat.getColor(imageView.context, R.color.teal_200)
        );
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsPhoto>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("networkStatus")
fun bindNetworkStatusToImageView(imageView: ImageView, networkStatus: NetworkStatus) {
    when (networkStatus) {
        NetworkStatus.LOADING -> imageView.setImageResource(R.drawable.loading_animation)
        NetworkStatus.ERROR -> imageView.setImageResource(R.drawable.ic_connection_error)
        NetworkStatus.SUCCESS -> imageView.visibility = View.GONE
    }
}