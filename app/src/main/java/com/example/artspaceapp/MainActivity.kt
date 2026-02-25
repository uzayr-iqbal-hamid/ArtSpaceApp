package com.example.artspaceapp

import android.graphics.Paint
import android.os.Bundle
import android.widget.Scroller
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier
        .fillMaxSize(),
) {
    var pageNo by remember { mutableStateOf(1) }
    val imageResource = when (pageNo) {
        1 -> R.drawable.pic1
        2 -> R.drawable.pic2
        3 -> R.drawable.pic3
        4 -> R.drawable.pic4
        5 -> R.drawable.pic5
        else -> R.drawable.pic6
    }
    val detailsResource = when (pageNo) {
        1 -> R.string.art1
        2 -> R.string.art2
        3 -> R.string.art3
        4 -> R.string.art4
        5 -> R.string.art5
        else -> R.string.art6
    }
    val subtitleResource = when (pageNo) {
        1 -> R.string.artist1
        2 -> R.string.artist2
        3 -> R.string.artist3
        4 -> R.string.artist4
        5 -> R.string.artist5
        else -> R.string.artist6
    }

    Column (
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer( modifier = Modifier.weight(1f) )

        ArtWall( imageId = imageResource, pageNo = pageNo )

        Spacer( modifier = Modifier.height(24.dp) )

        ArtDetails( titleRes = detailsResource, subtitle = subtitleResource )

        Spacer( modifier = Modifier.weight(1f) )

        ArtNavigation(
            pageNo = pageNo,
            onPrevious = { if (pageNo > 1) pageNo-- },
            onNext = { if (pageNo < 6) pageNo++ }
        )
    }
}

@Composable
fun ArtNavigation(
    pageNo: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Button(onClick = onPrevious, enabled = pageNo > 1) {
            Text("<- Previous")
        }

        Text(
            text = "${pageNo.toString()} / 6",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Button(onClick = onNext, enabled = pageNo < 6) {
            Text("Next ->")
        }
    }
}

@Composable
fun ArtWall(
    @DrawableRes imageId: Int,
    pageNo: Int
) {
        Surface (
            modifier = Modifier
                .width(280.dp)
                .height(360.dp),
            color = Color.White,
            shape = RoundedCornerShape(8.dp),
            shadowElevation = 8.dp
        ) {
            Column (
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(imageId),
                    contentDescription = null,
                    modifier = Modifier.size(350.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
}

@Composable
fun ArtDetails(
    @StringRes titleRes: Int,
    @StringRes subtitle: Int
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        color = Color(0xFFF1F1F1),
        shape = RoundedCornerShape(4.dp),
    ) {
        Column( modifier = Modifier.padding(16.dp) ) {
            Text (
                text = stringResource(titleRes),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(subtitle),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceAppTheme {
        ArtSpaceLayout()
    }
}