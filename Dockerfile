# 建议生产使用，ref: http://blog.tenxcloud.com/?p=1894
FROM docker.io/java:8u111

# USER root

# 中文乱码问题
ENV LANG C.UTF-8
# 中国时区问题
ENV TZ  Asia/Shanghai

COPY center-practice-web/target/app.jar /home/