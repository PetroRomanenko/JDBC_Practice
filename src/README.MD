Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:

1. Writer (id, firstName, lastName, List<Post> posts)
2. Post (id, content, created, updated, List<Label> labels)
3. Label (id, name)
4. PostStatus (enum ACTIVE, UNDER_REVIEW, DELETED)

**Требования:**
1. Придерживаться шаблона MVC (пакеты model, repository, service, controller, view)
2. Для миграции БД использовать https://www.liquibase.org/
3. Сервисный слой приложения должен быть покрыт юнит тестами (junit + mockito).
4. Слои:
5. model - POJO клаcсы
6. repository - классы, реализующие доступ к текстовым файлам
7. controller - обработка запросов от пользователя
8. view - все данные, необходимые для работы с консолью



Например: Writer, WriterRepository, WriterController, WriterView и т.д.


Для репозиторного слоя желательно использовать базовый интерфейс:
interface GenericRepository<T,ID>

interface WriterRepository extends GenericRepository<Writer, Long>

class JdbcWriterRepositoryImpl implements WriterRepository

Для импорта библиотек использовать Maven
Результатом выполнения проекта должен быть отдельный репозиторий на github, с описанием задачи, проекта и инструкцией по локальному запуску проекта.
