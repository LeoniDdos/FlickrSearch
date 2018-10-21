# flickrsearch

Тестовое задание:

Нужно на Java написать приложение, которое берет из Flickr API список фотографий по любому поисковому запросу и отображает их на экране.
Используется только один запрос к FlickrAPI: https://www.flickr.com/services/api/flickr.photos.search.html

Использовать архитектурный паттерн MVP, MVVM на выбор.
Формат отображения списка фото на экране любой  – сетка/линейка.
Используемые библиотеки – okhttp, retrofit, остальное на выбор.

Факультативно – при клике на маленькую фотографию открывать большую, покрыть код тестами.


Реализовано:

Архитектурный паттерн MVP.
Поле с вводом ключевого слова, по которому будет искать фотографии.
Отображение фотографий - линейкой с подписью к фотографии.
Нажатие на фотографию открывает полную версию фотографии.
Несколько юнит-тестов.

Библиотеки:
- Retrofit для запроса на фотографии
- OkHttp для логирования запросов
- Glide для прогрузки фотографий
- Mockito для юнит теста