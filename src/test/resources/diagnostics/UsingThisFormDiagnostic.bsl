&НаСервере
Функция ФункцияСОшибкой()

    ГлобалтныйМетод(ЭтаФорма);
    Модуль.Метод("Проверка", ЭтаФорма);
    ЭтаФорма.Закрыть();
    Возврат ЭтаФорма;

КонецФункции

&НаСервере
Процедура ФункцияСОшибкой(Параметр)

    НовыйЭлемент = ЭтаФорма.Элементы.Добавить();
    ГлобалтныйМетод(ЭтаФорма.Элементы, НовыйЭлемент);
    ЗначениеПеременной = Чтото + ЭтаФорма.ЧисловойРеквизит;
    Возврат ЭтаФорма.Элементы;

КонецПроцедуры

Функция ФункцияСПараметром(ЭтаФорма)

    ЭтаФорма = ПолучитьЭтуФорму();
    ГлобалтныйМетод(ЭтаФорма);
    Модуль.Метод("Проверка", ЭтаФорма);
    ЭтаФорма.Закрыть();
    Возврат ЭтаФорма;

КонецФункции

&НаСервере
Процедура ФункцияСПараметром(ЭтаФорма)

    ГлобалтныйМетод(ЭтаФорма);
    Модуль.Метод("Проверка", ЭтаФорма);
    ЭтаФорма.Закрыть();
    Возврат ЭтаФорма;

КонецПроцедуры

ГлобалтныйМетод(ЭтаФорма);
Модуль.Метод("Проверка", ЭтаФорма);
ЭтаФорма.Закрыть();

Оповещение = Новый ОписаниеОповещения("ПослеЗакрытияВопроса_ПрочитатьФайл", ЭтаФорма, Параметры);
Возврат ЭтаФорма;

ЧтоТо = Метод(ЭтаФорма, ЭтаФорма);
ЭтаФорма();
Модуль.ЭтаФорма();

ЭтаФормаПлохая.Да()

Струткура.ЭтаФорма = "123";
ЭтаФорма.Реквизит = "123";