package org.wikipedia.lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homework.ConfigureListItem
import org.wikipedia.lesson08.homework.CustomizeItem

import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.FeaturedArticleItem
import org.wikipedia.lesson08.homework.FeedConfigureScreen
import org.wikipedia.lesson08.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class SimpleTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkFeaturedArticleWorkflow() {
        run("Сценарий: Пропуск онбординга и проверка Featured Article") {

            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen {
                    skipButton {
                        isVisible()
                        click()
                    }
                }
            }

            step("Проверяет отображение блока Featured Article экрана Explore") {
                ExploreScreen {
                    items {
                        childWith<FeaturedArticleItem> {
                            withDescendant { withId(org.wikipedia.R.id.articleTitle) }
                        } perform {
                            title.isVisible()
                            textOfArticle.isVisible()
                            image.isVisible()
                        }
                    }
                }
            }

            step("Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore") {
                ExploreScreen {
                    items {
                        childWith<CustomizeItem> {
                            withDescendant { withId(org.wikipedia.R.id.view_announcement_text) }
                        } perform {
                            announcementText.isVisible()
                            customizeButton {
                                isVisible()
                                click()
                            }
                        }
                    }
                }
            }

            step("Отключает Featured Article") {
                FeedConfigureScreen {
                    configureList {
                        childWith<ConfigureListItem> {
                            withDescendant { withText(org.wikipedia.R.string.view_featured_article_card_title) }
                        } perform {
                            checkbox {
                                isVisible()
                                click()
                            }
                        }
                    }

                    step("Нажимает стрелку назад в верхнем тулбаре") {
                        FeedConfigureScreen {
                            backButton {
                                isVisible()
                                click()
                            }
                        }
                    }

                    step("6. Проверяет, что блок Featured Article не отображается на экране Explore)") {
                        ExploreScreen {
                            featuredArticleHeader.doesNotExist()
                        }
                    }
                }
            }
        }
    }
}



