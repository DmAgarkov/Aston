Паттерн Builder:
Transaction - неизменяемый объект финансовой транзакции с полями id, amount, currency, category, description, date.
Transaction.Builder - внутренний статический класс для пошагового создания Transaction с fluent-интерфейсом и валидацией обязательных полей.

Паттерн Strategy:
ReportStrategy - интерфейс стратегии с методом generate(List<Transaction>).
TableReportStrategy - стратегия вывода отчета в табличном формате.
SummaryReportStrategy - стратегия вывода отчета в виде сводки.
PieChartStrategy - стратегия вывода отчета в виде круговой диаграммы.
ExcelExportStrategy - стратегия экспорта отчета в Excel.
ReportGenerator - контекст, хранящий текущую стратегию и делегирующий ей генерацию отчета.

Паттерн Chain of Responsibility:
TransactionHandler - абстрактный базовый класс с методом handle() и ссылкой на следующий обработчик.
AmountHandler - обработчик, проверяющий что сумма транзакции не равна нулю.
LimitHandler - обработчик, проверяющий ежедневный лимит расходов и накапливающий сумму трат за день.

Паттерн Proxy:
TransactionService - интерфейс сервиса с методами getTransactions() и getTransactionById().
BaseTransactionService - сервис, хранящий список транзакций и возвращающий их копии.
SecurityProxy - прокси безопасности, проверяющий авторизацию пользователя перед выполнением операций.
CachingProxy - кэширующий прокси, сохраняющий результаты запросов в кэше для ускорения повторных обращений.

Паттерн Decorator:
Requester - интерфейс с методом request(List<Transaction>).
BaseRequester - базовая реализация Requester, возвращающая список без изменений.
AbstractDecorator - абстрактный декоратор, хранящий ссылку на обертываемый Requester.
FilteringDecorator - декоратор, фильтрующий транзакции по предикату.
SortingDecorator - декоратор, сортирующий транзакции по компаратору.
LimitDecorator - декоратор, ограничивающий количество транзакций.

Паттерн Adapter:
TransactionSaver - целевой интерфейс с методом save(List<Transaction>).
JsonSaver - существующий класс с методом saveToJson().
CsvSaver - существующий класс с методом saveToCsv().
JsonAdapter - адаптер, реализующий TransactionSaver и делегирующий вызов JsonSaver.saveToJson().
CsvAdapter - адаптер, реализующий TransactionSaver и делегирующий вызов CsvSaver.saveToCsv().