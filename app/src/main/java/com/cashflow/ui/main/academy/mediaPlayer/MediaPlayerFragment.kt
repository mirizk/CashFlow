package com.cashflow.ui.main.academy.mediaPlayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.cashflow.databinding.FragmentMediaPlayerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MediaPlayerFragment: Fragment() {

    private lateinit var binding:FragmentMediaPlayerBinding
    val args: MediaPlayerFragmentArgs by navArgs()
    var exoPlayer: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMediaPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer?.release()
    }
    private fun initPlayer() {
        exoPlayer = ExoPlayer.Builder(requireContext()).build()
        binding.exoPlayerView.player = exoPlayer
        exoPlayer?.playWhenReady = true
        exoPlayer?.setMediaItem(MediaItem.fromUri(args.videoUrl?: ""))
        exoPlayer?.prepare()
    }

}