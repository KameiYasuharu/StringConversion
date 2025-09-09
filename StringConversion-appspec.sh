#!/bin/bash

# webappsディレクトリに移動
cd /home/ec2-user/webapps

# WARファイルを指定ディレクトリに無言で展開（既存ファイルは上書き）
unzip -q -o StringConversion.war -d /home/ec2-user/webapps/StringConversion

# アプリケーションディレクトリに移動
cd /home/ec2-user/webapps/StringConversion
    
# 既に実行中の旧プロセスを停止（ポート競合を回避）
pkill -f "org.springframework.boot.loader.WarLauncher" || true
    
# アプリケーションをバックグラウンドで起動
# nohup java -cp . org.springframework.boot.loader.WarLauncher > app.log 2>&1 &
nohup java -cp "WEB-INF/classes:WEB-INF/lib/*:." com.example.StringConversionApplication > app.log 2>&1 &
