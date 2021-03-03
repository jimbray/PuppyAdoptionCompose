/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.data.PetInfo
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme() {
                // A surface container using the 'background' color from the theme
                Surface() {
                    Home()
                }
            }
        }
    }

    override fun onBackPressed() {
        val viewModel: PetViewModel by viewModels()
        if (viewModel.showingDetails) {
            viewModel.closeDetails()
        } else {
            super.onBackPressed()
        }
    }
}

@Composable
fun Home() {

    val viewModel: PetViewModel = viewModel()
    Scaffold(topBar = { Topbar(viewModel.topBarTitle) }) {
        Box {
            PetList(viewModel.pets)

            if (viewModel.showingDetails) {
                val persentOffsetX = animateFloatAsState(if (viewModel.showingDetails) 0f else 1f)
                PetDetails(pet = viewModel.curPet!!, Modifier.layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    layout(placeable.width, placeable.height) {
                        val offset = (persentOffsetX.value * placeable.width).toInt()
                        placeable.placeRelative(offset, 0)
                    }
                })
            }

        }
    }

}


@Composable
fun Topbar(title: String) {
    Box(
        Modifier
            .background(Color.Blue)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                title,
                Modifier.fillMaxWidth(),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
        }
    }
}


@Composable
fun PetDetails(pet: PetInfo, modifier: Modifier = Modifier) {


    Box {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFFFFFFFF).convert(ColorSpaces.CieXyz))
        ) {
            Image(
                painter = painterResource(id = pet.avatar),
                contentDescription = pet.name,
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Row() {
                Text(text = pet.name, fontSize = 20.sp)
                Text(text = " | ", fontSize = 20.sp)
                Text(text = pet.breed, fontSize = 20.sp)
                Text(text = " | ", fontSize = 20.sp)
                Text(text = pet.gender, fontSize = 20.sp)
            }
            Text(text = pet.des, Modifier.padding(8.dp))

        }
    }

}

@Composable
fun PetList(pets: List<PetInfo>) {

    LazyColumn(Modifier.background(Color(0xFFFFFF).convert(ColorSpaces.CieXyz))) {
        itemsIndexed(pets) { index, pet ->
            PetItem(pet)
        }
    }


}

@Composable
fun PetItem(pet: PetInfo) {
    val viewModel: PetViewModel = viewModel()
    Column(Modifier.clickable {
        viewModel.curPet = pet
        viewModel.showingDetails = true
        viewModel.topBarTitle = pet.name
    }) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color(0xF7F7F7).convert(ColorSpaces.CieXyz))
                .padding(8.dp)
        ) {
            Image(
                painterResource(pet.avatar), pet.name,
                Modifier
                    .requiredWidth(120.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp)) {
                Row(Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(pet.name, fontSize = 16.sp)

                    Text(text = " | ")
                    Text(text = pet.breed)

                }

                Text(
                    pet.gender,
                    Modifier
                        .padding(5.dp)
                        .background(Color(0xFF5E5E5E).convert(ColorSpaces.CieXyz)),
                    fontSize = 12.sp,
                    color = Color.White
                )
                Row(Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(pet.height, fontSize = 12.sp)
                    Text(" | ", fontSize = 12.sp)
                    Text(pet.weight, fontSize = 12.sp)
                }

            }
        }
        Spacer(
            Modifier
                .background(color = Color(0xFFFFFF).convert(ColorSpaces.CieXyz))
                .fillMaxWidth()
                .requiredHeight(1.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val viewModel: PetViewModel = viewModel()
    PetItem(viewModel.pets[0])
}
