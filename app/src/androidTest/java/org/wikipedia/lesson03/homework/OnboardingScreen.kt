package org.wikipedia.lesson03.homework

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.R
import org.wikipedia.views.AppTextView


val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)

val wikipediaLogoImage = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered,
    null
)
val welcomeTextOnboarding = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_welcome_title_v2
    )
val languagesFoundDescriptionText = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_multilingual_secondary_text
)

val defaultLanguageItemText = listOf(
    AppTextView::class.java,
    R.id.option_label,
    null
)

val addLanguagesButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)

val pageIndicatorDots = listOf(
    TabLayout::class.java,
    R.id.view_onboarding_page_indicator,
    null
)
val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)

val exploreIllustrationImage = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered,
    null
)


