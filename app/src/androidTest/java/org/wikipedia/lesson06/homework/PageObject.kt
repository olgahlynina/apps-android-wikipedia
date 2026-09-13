package org.wikipedia.lesson06.homework

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R


val readingText = KTextView {
    withId(R.id.textSettingsCategory)
}

val sizeText = KTextView {
    withId(R.id.text_size_percent)
}

val decreaseButton = KTextView {
    withId(R.id.buttonDecreaseTextSize)
}

val discreteSeekBar = KView {
    withId(R.id.text_size_seek_bar)
}

val increaseButton = KTextView {
    withId(R.id.buttonIncreaseTextSize)
}

val sansSerifButton = KButton {
    withId(R.id.button_font_family_sans_serif)
}

val serifButton = KButton {
    withId(R.id.button_font_family_serif)
}

val glassesIcon = KImageView {
    withParent {
        withId(R.id.readingFocusModeContainer)
    }
    isInstanceOf(AppCompatImageView::class.java)
}

val readingFocusSwitch = KSwitch {
    withId(R.id.theme_chooser_reading_focus_mode_switch)
}

val focusModeDescription = KTextView {
    withId(R.id.theme_chooser_reading_focus_mode_description)
}

val themeTitle = KTextView {
    withText(R.string.color_theme_select)
}

val lightThemeButton = KButton {
    withId(R.id.button_theme_light)
}

val sepiaThemeButton = KButton {
    withId(R.id.button_theme_sepia)
}

val darkThemeButton = KButton {
    withId(R.id.button_theme_dark)
}

val blackThemeButton = KButton {
    withId(R.id.button_theme_black)
}

val matchSystemThemeSwitch = KSwitch {
    withId(R.id.theme_chooser_match_system_theme_switch)
}

val imagesDimmingSwitch = KSwitch {
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
}