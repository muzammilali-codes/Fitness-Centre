package com.example.fitnesscentre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.font.FontWeight
import com.example.fitnesscentre.ui.theme.FitnessCentreTheme

data class Simpleitem(val imageres: Int, val title: String)

val itemList = listOf(
    Simpleitem(R.drawable.image1, "Gym: Body Shape "),
    Simpleitem(R.drawable.image2, "Yoga: Body Align"),
    Simpleitem(R.drawable.image3, "Stretching"),
    Simpleitem(R.drawable.image4, "Inversion"),
    Simpleitem(R.drawable.image1, "Fitness"),
    Simpleitem(R.drawable.ic_launcher_background, "Weighting")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessCentreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFBFEFFF) // Soft gray background
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
            unfocusedContainerColor = Color(0xFFBFEFFF),
            focusedContainerColor = Color(0xFFE8EAF6),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFF3F51B5),
            cursorColor = Color(0xFF3F51B5),
            focusedLabelColor = Color(0xFF3F51B5)
        ),
        placeholder = { Text("Search something", color = Color(0xFF757575)) },
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
                Text(
                    text = item.title,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(0xFF212121)
                )
            }
        }
    }
}

@Composable
fun Favs(modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = Color.White,
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
                    Text(
                        text = item.title,
                        modifier = Modifier.padding(start = 20.dp),
                        color = Color(0xFF212121)
                    )
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
        containerColor = Color(0xFFBFEFFF)
    ) {
        NavigationBarItem(
            icon = {
                Icon(Icons.Default.Home, contentDescription = null)//, tint = Color(0xFFCDDC39))
            },
            label = { Text("Home", color = Color.White) },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Default.AccountCircle, contentDescription = null)//, tint = Color(0xFFCDDC39))
            },
            label = { Text("Profile", color = Color.White) },
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
        containerColor = Color(0xFF3F51B5)
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(Icons.Default.Home, contentDescription = null, tint = Color(0xFFCDDC39))
                },
                label = { Text("Home", color = Color.White) },
                selected = true,
                onClick = {}
            )
            NavigationRailItem(
                icon = {
                    Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color(0xFFCDDC39))
                },
                label = { Text("Profile", color = Color.White) },
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
                .background(Color(0xFFFAFAFA))
        ) {
            Navigationrail()
            Spacer(modifier = Modifier.height(15.dp))
            Column(modifier = Modifier) {
                Searchbar()
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = " Align Your Body",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121)
                )
                Spacer(modifier = Modifier.height(20.dp))
                AlignBody()
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = " Favourite Collections",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121)
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
                .background(Color(0xFFFAFAFA))
                .padding(paddingValues)
        ) {
            Searchbar(modifier = Modifier.padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = " Align Your Body",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121)
            )
            Spacer(modifier = Modifier.height(20.dp))
            AlignBody()
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = " Favourite Collections",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121)
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
