package org.wikipedia.lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homework.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class DeviceControlToolsTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun screenRotation() {
        before {
            device.uiDevice.setOrientationNatural()
        }.after {
            device.uiDevice.setOrientationNatural()
        }.run {
            step("Проверяет, что изначально ориентация естественная") {
                assertTrue(device.uiDevice.isNaturalOrientation)
            }
            step("Поворачивает экран вправо") {
                device.uiDevice.setOrientationRight()
                Thread.sleep(3000)
            }
            step("Проверяет, что ориентация изменилась") {
                assertFalse(device.uiDevice.isNaturalOrientation)
            }
        }
    }

    @Test
    fun lockAndUnlockScreen() {
        run {
            step("Выключает экран") {
                device.uiDevice.sleep()
                Thread.sleep(2000)
            }
            step("Включает и разблокирует экран") {
                device.uiDevice.wakeUp()
                device.uiDevice.swipe(500, 1500, 500, 500, 10)
                Thread.sleep(2000)
            }
            step("Проверяет отображение элемента на экране") {
                OnboardingScreen {
                    skipButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun minimizeAndRestoreApp() {
        run {
            step("Сворачивает приложение кнопкой Home") {
                device.uiDevice.pressHome()
                Thread.sleep(2000)
            }
            step("Разворачивает приложение через двойное нажатие Recent Apps") {
                device.uiDevice.pressRecentApps()
                Thread.sleep(1000)
                device.uiDevice.pressRecentApps()
                Thread.sleep(2000)
            }
            step("Проверяет отображение элемента после разворачивания") {
                OnboardingScreen {
                    skipButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun networkToggleAndRetry() {
        before {
            device.network.toggleWiFi(enable = true)
            device.network.toggleMobileData(enable = true)
        }.after {
            device.network.toggleWiFi(enable = true)
            device.network.toggleMobileData(enable = true)
        }.run {
            step("Выключает Wi-Fi и мобильный интернет") {
                device.network.toggleWiFi(enable = false)
                device.network.toggleMobileData(enable = false)
                Thread.sleep(2000)
            }
            step("Пропускает онбординг, чтобы перейти на ExploreScreen") {
                OnboardingScreen {
                    skipButton.click()
                }
            }
            step("Включает сеть обратно") {
                device.network.toggleWiFi(enable = true)
                device.network.toggleMobileData(enable = true)
                Thread.sleep(3000)
            }
        }
    }

    @Test
    fun changeLanguage() {
        val systemLocale = Locale.getDefault()

        before {
        }.after {
            device.language.switchInApp(systemLocale)
        }.run {
            step("Переключает язык приложения на английский") {
                device.language.switchInApp(Locale.ENGLISH)
                Thread.sleep(2000)
            }
            step("Проверяет текст кнопки 'Skip' на английском без использования ресурсов") {
                OnboardingScreen {
                    skipButton.hasText("Skip")
                }
            }
        }
    }

    @Test
    fun checkCurrentActivity() {
        run {
            step("Пропускает онбординг, чтобы открылась MainActivity") {
                OnboardingScreen {
                    skipButton.click()
                }
            }
            step("Проверяет, что теперь активна MainActivity") {
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }
}