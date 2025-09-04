package com.example.stringconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stringconverter.dto.ConversionRequest;
import com.example.stringconverter.dto.ConversionResponse;
import com.example.stringconverter.service.StringConverterService;

/**
 * 文字列変換処理を行うRESTコントローラークラス
 * 
 * <p>クライアントからのリクエストを受け付け、文字列変換サービスを呼び出します。</p>
 */
@RestController // (1) RESTコントローラーとして登録（@Controller + @ResponseBody）
@RequestMapping // ベースURLマッピング
public class StringConverterController {

	@Autowired
	private StringConverterService stringConverterService;

	/**
	 * 文字列変換APIエンドポイント
	 * 
	 * <p>GETリクエストで受け取った文字列を変換し、結果を返します。</p>
	 * 
	 * @param request 変換リクエスト（入力文字列を含む）
	 * @return 変換結果を含むレスポンス
	 */
	@GetMapping("/conversion") // (2) /conversion パスへのGetリクエストを処理
	@ResponseBody // 戻り値を直接レスポンスボディとして返却
	public ConversionResponse convertString(ConversionRequest request) {
		// レスポンスオブジェクトの初期化
		ConversionResponse response = new ConversionResponse();

		String resultText = stringConverterService.convertLogic(request.getInputString());
		response.setResultText(resultText);

		return response;
	}
}