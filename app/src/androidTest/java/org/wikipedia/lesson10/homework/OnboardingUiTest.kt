package org.wikipedia.lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiTest: TestCase() {

    @get:Rule
    val tesRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testFirstSlideElements() {
        run {
            OnboardingUiScreen {
                step("Проверяет, что картинка первого слайда отображается") {
                    slideImage.isDisplayed()
                }
                step("Проверяет заголовок первого слайда через containsText") {
                    primaryText.isDisplayed()
                    primaryText.containsText("The Free Encyclopedia")
                }
                step("Проверяет описание первого слайда через containsText") {
                    secondaryText.isDisplayed()
                    secondaryText.containsText("found the following")
                }
                step("Проверяет, что в списке языков есть English") {
                    language.isDisplayed()
                    language.containsText("English")
                }
                step("Проверяет кнопку добавления языка через containsText") {
                    addLanguageButton.isDisplayed()
                    addLanguageButton.containsText("Add or edit languages")
                }
            }
        }
    }

    @Test
    fun testSwitchToSecondSlide() {
        run {
            OnboardingUiScreen {
                step("Нажимает Continue для перехода на второй слайд") {
                    continueButton.click()
                }
                step("Проверяет заголовок второго слайда через containsText") {
                    primaryText.isDisplayed()
                    primaryText.containsText("New ways to explore")
                }
                step("Проверяет описание второго слайда через containsText") {
                    secondaryText.isDisplayed()
                    secondaryText.containsText("Dive down the Wikipedia rabbit hole")
                }
                step("Проверяет, что кнопки Skip и Continue доступны") {
                    skipButton.isDisplayed()
                    continueButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun testThirdSlideReadingLists() {
        run {
            OnboardingUiScreen {
                step("Переходит на третий слайд") {
                    continueButton.click()
                    continueButton.click()
                }
                step("Проверяет заголовок третьего слайда через containsText") {
                    primaryText.isDisplayed()
                    primaryText.containsText("Reading lists with sync")
                }
                step("Проверяет описание третьего слайда через containsText") {
                    secondaryText.isDisplayed()
                    secondaryText.containsText("sync your reading lists")
                }
                step("Проверяет, что картинка третьего слайда отображается") {
                    slideImage.isDisplayed()
                }
            }
        }
    }

    @Test
    fun testLastSlideAndGetStarted() {
        run {
            OnboardingUiScreen {
                step("Пролистывает слайды до экрана Data & Privacy") {
                    repeat(3) {
                        continueButton.click()
                    }
                }
                step("Проверяет заголовок экрана приватности") {
                    primaryText.isDisplayed()
                    primaryText.containsText("Data & Privacy")
                }
                step("Проверяет появление финальной кнопки вместо стрелки Continue") {
                    getStartedButton.isDisplayed()
                    getStartedButton.containsText("Get started")
                }
                step("Завершает онбординг нажатием на кнопку") {
                    getStartedButton.click()
                }
            }
        }
    }
}