package com.example.stringconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * StringConverterアプリケーションのメインクラス
 * 
 * <p>Spring Bootアプリケーションの起動と基本設定を管理します。</p>
 */
@SpringBootApplication // (1) Spring Bootの自動設定を有効化（コンポーネントスキャン、自動設定など）
public class StringConverterApplication {

    /**
     * アプリケーションのエントリーポイント
     * 
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // (2) Spring Bootアプリケーションを起動
        // - 内蔵Tomcatサーバーの起動
        // - アプリケーションコンテキストの初期化
        // - 自動設定の適用
        SpringApplication.run(StringConverterApplication.class, args);
    }
}