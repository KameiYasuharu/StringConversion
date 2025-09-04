package com.example.stringconverter.initParam;

import ch.qos.logback.core.PropertyDefinerBase;
import software.amazon.awssdk.imds.Ec2MetadataClient;
import software.amazon.awssdk.imds.Ec2MetadataResponse;

public class InstanceIdDefiner extends PropertyDefinerBase {
	@Override
	public String getPropertyValue() {

		// インスタンスIDを取得
		// デフォルト値
		String instanceId = "Unknown";

		try (Ec2MetadataClient client = Ec2MetadataClient.create()) {
			// IMDSv2 (Version 2) を使ってインスタンスIDを取得
			Ec2MetadataResponse imdsResponse = client.get("/latest/meta-data/instance-id");
			instanceId = imdsResponse.asString();
		} catch (Exception e) {
			// EC2インスタンス以外で実行した場合や、エラーが発生した場合
			System.err.println("Failed to get instance ID from IMDS: " + e.getMessage());
			instanceId = "err-instanceId";
		}
		return instanceId;
	}

}
