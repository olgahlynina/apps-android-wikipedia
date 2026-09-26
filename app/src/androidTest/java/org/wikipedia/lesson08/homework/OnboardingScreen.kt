package org.wikipedia.lesson08.homework
import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingPageView

object OnboardingScreen : KScreen<OnboardingScreen>() {

    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = OnboardingPageView::class.java

    val pager = KViewPager2(
        builder = {
            withId(id = R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(provideItem = ::PagerItem)
        }
    )

    val skipButton = KButton {
        withId(id = R.id.fragment_onboarding_skip_button)
    }
}

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image = KImageView(parent = matcher) {
        withId(id = R.id.imageViewCentered)
    }

    val title = KTextView(parent = matcher) {
        withId(id = R.id.primaryTextView)
    }

    val languages = KRecyclerView(
        parent = matcher,
        builder = {
            withId(id = R.id.languagesList)
        },
        itemTypeBuilder = {
            itemType(provideItem = ::LanguageItem)
        }
    )

    val addLanguageButton = KButton(parent = matcher) {
        withId(id = R.id.addLanguageButton)
    }
}

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher), TextViewAssertions