package com.team.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.team.tmdbclient.R
import com.team.tmdbclient.data.model.movie.Movie
import com.team.tmdbclient.databinding.ListItemBinding

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MyViewHolder>(){

    private val movieList = ArrayList<Movie>()
    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }


    class MyViewHolder(val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie:Movie){
            binding.titleTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview
            val posterURL = "https://image.tmdb.org/t/p/w500"+movie.posterPath
            Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)

        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}

