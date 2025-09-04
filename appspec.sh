#!/bin/bash
    # 切换到应用目录
    cd /home/ec2-user/webapps/StringConversion
    
    # 停止可能存在的旧进程（避免端口占用）
    pkill -f "org.springframework.boot.loader.WarLauncher" || true
    
    # 启动应用并后台运行
    nohup java -cp . org.springframework.boot.loader.WarLauncher > app.log 2>&1 &
    
    # 等待3秒后检查进程是否启动成功
    sleep 3
    if pgrep -f "org.springframework.boot.loader.WarLauncher" > /dev/null; then
      echo "应用启动成功"
      exit 0
    else
      echo "应用启动失败"
      exit 1
    fi
    
