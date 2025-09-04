package com.example.stringconverter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 文字列変換サービスの実装クラス
 * 
 * <p>実際の文字列変換処理を実装します。</p>
 */
@Service // (2) Springのサービスコンポーネントとして登録
public class StringConverterServiceImpl implements StringConverterService {

    /**
     * 文字列変換ロジックの実装
     * 
     * <p>特定の入力値に対して定義された変換を行います。</p>
     * 
     * @param inputString 変換対象の入力文字列
     * @return 変換結果文字列（該当なしの場合は"unknown"）
     */
    public String convertLogic(@ModelAttribute String inputString) {
        // 変換結果格納用変数の初期化
        String resultText = new String();
        
        // 入力値に応じた変換処理
        if ("A123".equals(inputString)) {
            resultText = "B456"; // (3) A123 → B456 に変換
        } else {
            resultText = "unknown"; // (4) 該当しない入力値
        }
        
        return resultText;
    }
}
