# Упрощенный запуск тестов
 
1. Склонировать репозиторий https://github.com/VereskQA/qamid-diplom.git
2. Открыть проект `fmh-android` в Android Studio.
3. Запустить эмулятор или подключить устройство для тестирования.
4. запустить тесты консольной командой `./gradlew connectedAndroidTest`.

# Запуск тестов и выгрузка allure-results

1. клонировать репозиторий https://github.com/VereskQA/qamid-diplom.git
2. Открыть проект `fmh-android` в Android Studio.
3. Запустить эмулятор или подключить устройство для тестирования.
4. Во вкладке Project левым кликом мыши (или аналогичным образом) выделить каталог `app`.
5. Запустить тесты сочетанием клавиш Shift+Control+R (Mac) Shift+Control+F10 (Windows)
6. По завершению, вгрузите каталог `/data/data/ru.iteco.fmhandroid/files/allure-results` с эмулятора или тестового устройства.
7. Выполните локально консольную команду `allure serve` находясь на уровень выше каталога `allure-results`.
