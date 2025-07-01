package com.example.fitnesscentre

import android.R.attr.icon
import android.R.attr.label
import android.R.attr.onClick
import android.R.attr.start
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesscentre.itemList
import com.example.fitnesscentre.ui.theme.FitnessCentreTheme

// Data class representing each item
data class Simpleitem(val imageres: Int, val title: String)

// Sample list of items (image and text)
val itemList = listOf(
    Simpleitem(R.drawable.image1, "Gym: Body Shape "),
    Simpleitem(R.drawable.image2, "Yoga: Body Align"),
    Simpleitem(R.drawable.image3, "Stretching"),
    Simpleitem(R.drawable.image4, "Inversion"),
    Simpleitem(R.drawable.image1, "Fitness"),
    Simpleitem(R.drawable.ic_launcher_background, "Weighting"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessCentreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF1F8E9) // 🍃 Fresh light green background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Searchbar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFE3F2FD),
            focusedContainerColor = Color(0xFFBBDEFB),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFF64B5F6),
            cursorColor = Color(0xFF1976D2),
            focusedLabelColor = Color(0xFF1976D2)
        ),
        placeholder = { Text("Search something") },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .heightIn(min = 54.dp)
    )
}

@Composable
fun AlignBody(modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier.padding(1.dp)) {
        items(itemList) { item ->
            Column(
                horizontalAlignment = CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = item.imageres),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(88.dp)
                        .clip(CircleShape)
                )
                Text(text = item.title, modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Composable
fun Favs(modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(itemList) { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.imageres),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(88.dp)
                            .clip(CircleShape)
                    )
                    Text(text = item.title, modifier = Modifier.padding(start = 20.dp))
                }
            }
        }
    }
}

@Composable
private fun Navigationbar() {
    NavigationBar(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .height(80.dp),
        containerColor = Color(0xFF81C784) // 🍃 Light green
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home") },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text("Profile") },
            selected = false,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun Navigationrail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = Color(0xFF81C784) // 🍃 Light green
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            NavigationRailItem(
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                label = { Text("Home") },
                selected = true,
                onClick = {}
            )
            NavigationRailItem(
                icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
                label = { Text("Profile") },
                selected = false,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Tablets() {
    FitnessCentreTheme {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1F8E9)) // 🍃 Background
        ) {
            Navigationrail()
            Spacer(modifier = Modifier.height(15.dp))
            Column(modifier = Modifier) {
                Searchbar()
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = " Align Your Body",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(20.dp))
                AlignBody()
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = " Favourite Collections",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(15.dp))
                Favs()
                Spacer(modifier = Modifier.height(75.dp))
            }
        }
    }
}

@Composable
fun Phone(modifier: Modifier) {
    Scaffold(
        bottomBar = { Navigationbar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1F8E9)) // 🍃 Background
                .padding(paddingValues)
        ) {
            Searchbar(modifier = Modifier.padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = " Align Your Body",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(20.dp))
            AlignBody()
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = " Favourite Collections",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(20.dp))
            Favs()
        }
    }
}

@Composable
fun MainScreen() {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    if (screenWidth < 600) {
        Phone(modifier = Modifier)
    } else {
        Tablets()
    }
}
