package com.github.zsoltk.pokedex.home

import androidx.compose.Composable
import androidx.ui.foundation.AdapterList
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.github.zsoltk.pokedex.R
import com.github.zsoltk.pokedex.entity.NewsItem
import com.github.zsoltk.pokedex.home.appbar.MainAppBar
import com.github.zsoltk.pokedex.home.news.NewsCard
import com.github.zsoltk.pokedex.home.news.NewsHeaderSection

interface Home {

    sealed class MenuItem(
        val label: String,
        val colorResId: Int
    ) {
        object Pokedex : MenuItem("Pokedex", R.color.poke_teal)
        object Moves : MenuItem("Moves", R.color.poke_red)
        object Abilities : MenuItem("Abilities", R.color.poke_light_blue)
        object Items : MenuItem("Items", R.color.poke_yellow)
        object Locations : MenuItem("Locations", R.color.poke_purple)
        object TypeCharts : MenuItem("Type charts", R.color.poke_brown)
    }

    companion object {
        @Composable
        fun Content(onMenuItemSelected: (MenuItem) -> Unit) {
            AdapterList(data = List(1000) { NewsItem(it) }) {
                if(it.indexInList == 0) {
                    MainAppBar(onMenuItemSelected)
                    Container(modifier = LayoutPadding(32.dp)) {
                        NewsHeaderSection()
                    }
                }
                Container(modifier = LayoutPadding(left = 32.dp, right = 32.dp)) {
                    NewsCard(newsItem = it)
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewMainScreen() {
    Home.Content(onMenuItemSelected = {})
}
