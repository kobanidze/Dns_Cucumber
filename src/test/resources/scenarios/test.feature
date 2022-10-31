# language: ru
@mortgage
Функция: Покупка товаров

  @success
  Сценарий: Проверка возможности покупки товаров
    И Проверить наличие кнопки подтверждения города
    И Нажать кнопку сменить город
    И Написать в поисковой строке город Москва
    И Нажать на кнопку с названием города
    И Заполнить поисковую строку продуктом playstation
    И Выбрать пункт из списка по тэгу Консоли
    И Выбрать продукт по названию Игровая консоль PlayStation 5 [825 ГБ SSD, геймпад - 1 шт, Bluetooth, Wi-Fi, белый]
    И Запоминаем цену первого продукта
    И Выбираем гарантию на продукт
    И Запоминаем цену первого продукта
    И Нажимаем на кнопку купить
    И Заполнить поисковую строку продуктом elden ring
    И Выбрать пункт из списка по тэгу Игры для PlayStation
    И Выбрать продукт по названию Игра Elden Ring (PS5) [16+, ролевая игра, дата выхода: 25.02.2022, язык озвучки: английский, стандартное издание]
    И Запоминаем цену второго продукта
    И Нажимаем на кнопку купить
    И Запоминаем итогововую цену
    И Переходим в корзину
    И Нажать на кнопку увеличить количество товара 2 раз для продукта Игра Elden Ring (PS5)
    И Удаляем продукт Elden Ring из корзины


