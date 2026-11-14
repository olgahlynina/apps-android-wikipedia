package org.wikipedia.lesson13.homework

import androidx.test.espresso.Espresso
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KTextView
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebViewTests: TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run("Сценарий: Проверка сносок и редиректов в WebView статьи") {

            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen {
                    skipButton {
                        isVisible()
                        click()
                    }
                }
            }

            step("Переходит в статью Corleck Head через поиск") {
                KTextView {
                    withText("Search Wikipedia")
                }.click()

                KEditText {
                    withHint("Search Wikipedia")
                }.typeText("corleck head")

                Espresso.closeSoftKeyboard()

                val articleResult = device.uiDevice.findObject(
                    UiSelector().text("Corleck Head")
                )
                articleResult.waitForExists(10000)
                articleResult.click()
            }

            step("Закрывает всплывающие окна после открытия статьи, если они появились") {
                val gamesPopup = device.uiDevice.findObject(
                    UiSelector().textContains("Wikipedia games")
                )
                if (gamesPopup.waitForExists(3000)) {
                    val closeBtn = device.uiDevice.findObject(
                        UiSelector().descriptionContains("Close")
                    )
                    if (closeBtn.exists()) {
                        closeBtn.click()
                    } else {
                        device.uiDevice.pressBack()
                    }
                }

                val gotItBtn = device.uiDevice.findObject(
                    UiSelector().text("Got it")
                )
                if (gotItBtn.waitForExists(2000)) {
                    gotItBtn.click()
                }
            }

            step("Скроллит до заголовка References и проверяет его текст") {
                flakySafely(timeoutMs = 10000) {
                    ArticleScreen {
                        webView {
                            withElement(Locator.ID, "References") {
                                scroll()
                                hasText("References")
                            }
                        }
                    }
                }
            }

            step("Находит пятую сноску в тексте по XPath и нажимает на неё") {
                ArticleScreen {
                    webView {
                        withElement(Locator.XPATH, "//sup[contains(@class,'mw-ref')]//span[text()=5]") {
                            scroll()
                            click()
                        }
                    }
                }
            }

            step("Проверяет заголовок 'Reference' и номер '5.' во всплывающем окне") {
                PopupWindowScreen {
                    referenceTitle {
                        isVisible()
                        hasText("Reference ")
                    }
                    referenceId {
                        isVisible()
                        hasText("5.")
                    }
                }
            }

            step("Закрывает всплывающее окно системной кнопкой Back") {
                device.uiDevice.pressBack()
            }

            step("Находит вторую ссылку с классом mw-redirect и нажимает на неё") {
                ArticleScreen {
                    webView {
                        withElement(Locator.XPATH, "(//a[contains(@class, 'mw-redirect')])") {
                            scroll()
                            click()
                        }
                    }
                }
            }

            step("Нажимает кнопку Read article во всплывающем окне превью статьи") {
                PopupWindowScreen {
                    readArticleButton {
                        isVisible()
                        click()
                    }
                }
            }

            step("Скроллит до элемента с id 'References' в открывшейся статье") {
                flakySafely(timeoutMs = 10000) {
                    ArticleScreen {
                        webView {
                            withElement(Locator.ID, "References") {
                                scroll()
                                hasText("References")
                            }
                        }
                    }
                }
            }
        }
    }
}