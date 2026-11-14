package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object PopupWindowScreen: KScreen<PopupWindowScreen>() {
    override val layoutId = null
    override val viewClass = null

    val referenceTitle = KTextView {
        withId(R.id.reference_title_text)
    }

    val referenceId = KTextView {
        withId(R.id.reference_id)
    }

    val referenceText = KTextView {
        withId(R.id.reference_text)
    }
    val readArticleButton = KButton {
        withId(R.id.link_preview_primary_button)
    }
}