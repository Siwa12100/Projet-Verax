
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun VideoPlayer(videoUrl : String){
    val context = LocalContext.current

    val player = ExoPlayer.Builder(context).build()

    val playerView = PlayerView(context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    val mediaItem = MediaItem.Builder()
        .setUri(videoUrl)
        .build()

    player.setMediaItem(mediaItem)
    player.prepare()
    player.play()

    AndroidView(
        factory = { context -> playerView },
        modifier = Modifier.fillMaxSize(),
        update = { view ->
            view.player = player
        }
    )


}
