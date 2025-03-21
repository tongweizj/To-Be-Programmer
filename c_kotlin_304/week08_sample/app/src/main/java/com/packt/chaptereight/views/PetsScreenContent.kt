package com.packt.chaptereight.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.packt.chaptereight.data.Cat
import com.packt.chaptereight.navigation.ContentType
import com.packt.chaptereight.viewmodel.PetsViewModel
import kotlinx.serialization.InternalSerializationApi

@OptIn(InternalSerializationApi::class)
@Composable
fun PetsScreenContent(
    modifier: Modifier,
    onPetClicked: (Cat) -> Unit,
    contentType: ContentType,
    petsUIState: PetsUIState,
    petsViewModel: PetsViewModel,
    onFavoriteClicked: (Cat) -> Unit
) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { petsViewModel.getPets() }) {
            Text("加载人物列表")
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = petsUIState.isLoading
        ) {
            CircularProgressIndicator()
        }

        AnimatedVisibility(
            visible = petsUIState.pets.isNotEmpty()
        ) {
            if (contentType == ContentType.List) {
                PetList(
                    onPetClicked = onPetClicked,
                    pets = petsUIState.pets,
                    modifier = Modifier
                        .fillMaxWidth(),
                    onFavoriteClicked = onFavoriteClicked
                )
            } else {
                PetListAndDetails(
                    pets = petsUIState.pets,
                    onFavoriteClicked = onFavoriteClicked
                )
            }

        }
        AnimatedVisibility(
            visible = petsUIState.error != null
        ) {
            Text(text = petsUIState.error ?: "")
        }
    }
}