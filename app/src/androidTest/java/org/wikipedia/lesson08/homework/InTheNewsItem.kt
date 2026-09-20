package org.wikipedia.lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {
    val image = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
        isInstanceOf(AppCompatImageView::class.java)
        isDisplayed()
    }
    val text = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }
}