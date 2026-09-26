package org.wikipedia.lesson08.homework

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.switch.KSwitch
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.configure.ConfigureActivity

object FeedConfigureScreen : KScreen<FeedConfigureScreen>() {
    override val layoutId = null
    override val viewClass = ConfigureActivity::class.java

    val backButton = KButton {
        withContentDescription("Navigate up")
    }

    val configureList = KRecyclerView(
        builder = { withId(R.id.content_types_recycler) },
        itemTypeBuilder = { itemType(::ConfigureListItem) }
    )
}