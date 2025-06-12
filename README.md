# BooksManagementBack

## 概要

このプロジェクトは、書籍管理システムのバックエンドです。以下の主要な技術スタックを使用しています：

- **Spring Boot**
- **MySQL**
- **MyBatis**
- **SLF4J (ログ出力)**
- **HikariCP (接続プール)**
- **Lombok**
- **Spring Boot DevTools (ホットリロード)**

## ディレクトリ構成

```bash
src/
├── main/
│ ├── java/
│ │ └── com/bookManagementBack/
│ │ ├── config/ # CORS設定など
│ │ ├── controller/ # APIコントローラ
│ │ ├── mapper/ # MyBatis Mapper
│ │ ├── model/ # エンティティやDTOなど
│ │ └── BooksManagementBackApplication.java
│ └── resources/
│ ├── application.yml # 設定ファイル
│ ├── mapper/ # MyBatisのXMLマッピングファイル
│ └── logback-spring.xml # ログ設定
└── test/
```

## 必要環境

- Java 17
- Maven 3.x
- MySQL 8.x

## セットアップ手順

1. **MySQL の設定**

   MySQL に以下のようなデータベースの作成
   
```bash

/*
 usersテーブル
*/ 
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userId` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT (uuid()),
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` int NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE,
  CONSTRAINT `users_chk_1` CHECK (`role` in (1,2))
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

/*
 categoriesテーブル
*/
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `use_count` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

/*
 bookテーブル
*/
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `category` int NULL DEFAULT NULL,
  `summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isbn` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `publish_date` date NULL DEFAULT NULL,
  `count` int NULL DEFAULT NULL,
  `count_on_borrowed` int NULL DEFAULT NULL,
  `location` int NULL DEFAULT NULL,
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
```

2. **application.yml の設定**
### src/main/resources/application.yml にDB接続情報の記述

```yml
spring:
  datasource: 
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/books_management?characterEncoding=utf-8&useSSL=false&useUnicode=true
    username: root  #mysqlのユーザー名
    password: 123456 #mysqlのパスワード
    type: com.zaxxer.hikari.HikariDataSource
  jackson:
    time-zone: Asia/Tokyo
  LOG_DIR: logs
mybatis:
  configuration:
    map-underscore-to-camel-case: true
  mapper-locations: classpath:mapper/*.xml

```

3. **依存関係のインストール**

```bath
mvn clean install

```

4. **アプリケーションの起動**

```bath
mvn spring-boot:run

```
### または BooksManagementBackApplication.java をIDEから実行。

## 使用技術詳細

| 技術              | 説明                                               |
|-------------------|----------------------------------------------------|
| Spring Boot       | 軽量なJavaベースのWebアプリケーション開発フレームワーク |
| MySQL             | データベース管理システム                            |
| MyBatis           | SQLマッピングフレームワーク                         |
| SLF4J + Logback   | ログ出力フレームワーク                              |
| HikariCP          | 高速なDBコネクションプール                          |
| Lombok            | ボイラープレートコード削減用アノテーションライブラリ    |


## 開発・テスト
- BookController 経由でAPIアクセスを行い、データベースのCRUD操作が可能です。
- テストコードは src/test/java に配置。



