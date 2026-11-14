package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleScreen: KScreen<ArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
val webView = KWebView() {
    withId(R.id.page_web_view)
}
    val customizeInfoButton = KButton() {
        withId(R.id.buttonView)
    }
    val introducingCloseButton = KButton() {
        withId(R.id.close_button)
    }
}
