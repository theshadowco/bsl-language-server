
Процедура Один()
    А = 0;
КонецПроцедуры

#Область ИмяОбласти

// Описание
// Возвращаемое значение:
// Строка - описание строки
Функция Два()
    Возврат Неопределено;
КонецФункции

Функция Три(Парам, Знач Парам2, Парам3 = 0, Знач Парам4 = 0)
    Возврат Неопределено;
КонецФункции

#КонецОбласти

// Устарела.
//
Функция Четыре()
КонецФункции

// Устарела. См. функцию Три()
// Описание
//
Функция Пять()
КонецФункции

&НаКлиенте
Процедура Метод6()
КонецПроцедуры

&НаСервереБезКонтекста
Процедура Метод7()
КонецПроцедуры

&НаКлиенте
&НаСервере
Процедура Метод8()
КонецПроцедуры

Процедура Метод9()
КонецПроцедуры

&После
Процедура Метод10()
КонецПроцедуры

&НаКлиенте
&После("Метод11")
Процедура Метод11()
КонецПроцедуры

&После(Метод12)
&НаКлиенте
Процедура Метод12()
КонецПроцедуры

&НаКлиенте
&После
Функция Метод13()
КонецФункции

&Аннотация1
&Аннотация2
Процедура Метод14() Экспорт
КонецПроцедуры

&НаСервереБезКонтекста
&НаКлиентеНаСервереБезКонтекста
Процедура Метод15()
КонецПроцедуры

&НаКлиентеНаСервереБезКонтекста
&НаСервереБезКонтекста
Процедура Метод16()
КонецПроцедуры

&НаКлиентеНаСервере
&НаКлиенте
Процедура Метод17()
КонецПроцедуры

&НаКлиенте
&НаКлиентеНаСервере
Процедура Метод18()
КонецПроцедуры

&НаКлиенте
&НаКлиентеНаСервере
&НаКлиенте
&НаКлиентеНаСервере
Процедура Метод19()
КонецПроцедуры

&НаЧемУгодно(ДажеСПараметром = "Да", СПараметромБезЗначения, "Значение без параметра")
Процедура Метод20() Экспорт
КонецПроцедуры

&Перед("Перед")
Процедура Р_Перед()
КонецПроцедуры

&После("После")
Процедура Р_После()
КонецПроцедуры

&Вместо("Вместо")
Функция Р_Вместо()
КонецФункции
