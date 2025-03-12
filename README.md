# 株式会社ゆめみ Android エンジニアコードチェック課題に挑戦してみた💪

## 概要

[株式会社ゆめみ Android エンジニアコードチェック課題](https://github.com/yumemi-inc/android-engineer-codecheck)

[ゆめみの Android の採用コーディング試験を公開しました](https://qiita.com/blendthink/items/aa70b8b3106fb4e3555f)

## アプリ仕様

本アプリは GitHub のリポジトリを検索するアプリです。

<img src="docs/app.gif" width="320">

### 環境

- IDE：Android Studio Meerkat | 2024.3.1
- Kotlin：1.9.21
- Java：17
- Gradle：8.9
- minSdk：24
- targetSdk：35

### 動作

1. 何かしらのキーワードを入力
2. GitHub API（`search/repositories`）でリポジトリを検索し、結果一覧を概要（リポジトリ名）で表示
3. 特定の結果を選択したら、該当リポジトリの詳細（リポジトリ名、オーナーアイコン、プロジェクト言語、Star 数、Watcher 数、Fork 数、Issue 数）と README を Markdown で表示

### 取り組んだこと

- [公式推奨](https://developer.android.com/topic/architecture?hl=ja)のアーキテクチャやサンプルプロジェクトを参考に設計

- 詳細ページで`README.md`を Markdown で表示する

- 言語に対応するカラーアイコンを作成する [参考](https://github.com/ozh/github-colors)

- ユニットテスト、E2E テストの作成。GitHub Actions の CI でのテスト環境の作成


## AIサービスの利用
言語に対応するカラーアイコンの作成する際、400 以上の言語があったため[マップファイル](https://github.com/KazumaProject/android-engineer-codecheck/blob/main/app/src/main/kotlin/jp/co/yumemi/android/code_check/util/LanguageColors.kt)を AI を使用して作成しました。[参考](https://github.com/KazumaProject/android-engineer-codecheck/pull/40)

アプリのアイコンも AI で作成しました。
