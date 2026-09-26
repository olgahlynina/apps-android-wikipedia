package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ConfigureListItem(matcher: Matcher<View>) : KRecyclerItem<ConfigureListItem>(matcher) {
    val title = KTextView(matcher) { withId(R.id.feed_content_type_title) }
    val checkbox = KSwitch(matcher) { withId(R.id.feed_content_type_checkbox) }
}