package com.example.stringconverter.service;

import org.springframework.stereotype.Service;

/**
 * 文字列変換サービスのインターフェース
 * 
 * <p>文字列変換処理の契約を定義します。</p>
 */
@Service // (1) Springのサービスコンポーネントとして登録
public interface StringConverterService {
    /**
     * 文字列変換ロジックのインターフェース
     * @param inputText 入力文字列
     * @return 変換結果文字列
     */
    String convertLogic(String inputText);
}