package org.wikipedia.lesson08.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val inTheNewsHeader = KTextView {
        withId(R.id.view_card_header_title)
        withText("In the news")
    }

    val topReadHeader = KTextView {
        withId(R.id.view_card_header_title)
        withText("Top read")
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchItem)
            itemType(::CustomizeItem)
            itemType(::DateItem)
        }
    )

    val topReadList = KRecyclerView(
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadItem)
        }
    )

    val inTheNewsList = KRecyclerView(
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::InTheNewsItem)
        }
    )
}