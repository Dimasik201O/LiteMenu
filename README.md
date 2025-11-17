# LiteMenu

> Легковесная библиотека для быстрого создания интерактивных меню в инвентарях Minecraft

## О проекте

LiteMenu — минималистичное решение для создания пользовательских меню в инвентарях с удобной системой обработки событий. Библиотека предоставляет простой API для разработки интерактивных интерфейсов в ваших плагинах.

## Возможности

- Простое создание меню через наследование
- Встроенная система листенеров для обработки кликов и закрытия
- Поддержка асинхронного выполнения
- Автоматическая работа с главным потоком сервера
- Минимальные зависимости

## Установка

1. Скачайте последнюю версию `.jar` файла из [releases](https://github.com/Dimasik201O/LiteMenu/releases)

2. Добавьте библиотеку как локальную зависимость в ваш проект

### Maven

```xml
<dependency>
    <groupId>org.dimasik</groupId>
    <artifactId>LiteMenu</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/libs/LiteMenu-1.0-SNAPSHOT.jar</systemPath>
</dependency>
```

### Gradle

```gradle
dependencies {
    implementation files('libs/LiteMenu-1.0-SNAPSHOT.jar')
}
```

## Быстрый старт

### Создание меню

```java
public class MyMenu extends Menu {
    
    public MyMenu(JavaPlugin plugin) {
        super(plugin);
    }
    
    @Override
    public Menu compile() {
        inventory = Bukkit.createInventory(this, 27, "Моё меню");
        // Добавьте предметы в инвентарь
        return this;
    }
}
```

### Использование меню

```java
new MyMenu(plugin)
    .setPlayer(player)
    .compile()
    .open();
```

### Создание листенера

```java
public class MyMenuListener extends MenuListener {
    
    public MyMenuListener(JavaPlugin plugin) {
        super(MyMenu.class, plugin, false); // false = синхронная обработка
    }
    
    @Override
    protected void onClick(InventoryClickEvent event, Menu menu, Player player, int slot) {
        // Обработка клика по слоту
    }
    
    @Override
    protected void onClose(InventoryCloseEvent event, Menu menu, Player player) {
        // Обработка закрытия меню
    }
}
```

### Регистрация листенера

```java
new MyMenuListener(plugin).register();
```

## Требования

- Java 17+
- Paper/Spigot 1.16.5+

## Лицензия

Проект распространяется свободно для использования и модификации.

