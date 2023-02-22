package com.example.hrresturant.ui.fragment.drawer

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import com.example.hrresturant.databinding.FragmentYoutubeBinding
import com.example.hrresturant.ui.fragment.BaseFragment

class YoutubeFragment : BaseFragment<FragmentYoutubeBinding>(FragmentYoutubeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(binding.youtubePlayerView)
        binding.youtubePlayerView.enterFullScreen();

//        binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//            override fun onReady(youTubePlayer: YouTubePlayer) {
//                super.onReady(youTubePlayer)
//                youTubePlayer.loadVideo("zVQiLKiMlTg",0f)
//            }
//        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.youtubePlayerView.enterFullScreen();
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            binding.youtubePlayerView.exitFullScreen();
        }
    }
}