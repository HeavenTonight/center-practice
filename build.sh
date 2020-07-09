#! /bin/bash
cd `dirname $0`

proj_home=$PWD                             # the project root dir
productName="$appName:v$version"
port="$port"
echo "productName=$productName"
echo "port=$port"

echo "<①--------------start maven build package-------------->"
docker run --rm \
   -v ~/.m2:/root/.m2 \
   -v $proj_home:/usr/src/mymaven \
   -w /usr/src/mymaven \
   registry-vpc.cn-chengdu.aliyuncs.com/ouyong/maven:latest \
    mvn clean package -U \
    -Dmaven.test.failure.ignore=true \
    -Dmaven.test.skip=true
echo "<②-----------finished maven build package--------------->"

#reName
sudo mv $proj_home/center-practice-web/target/center-practice-web-*.jar $proj_home/center-practice-web/target/center-practice.jar

rm -rf /data/myapp/center-practice/center-practice.jar
cp $proj_home/center-practice-web/target/center-practice.jar /data/myapp/center-practice

pid=$(netstat -nlp | grep :$port | awk '{print $7}' | awk -F"/" '{print $1}')
echo "pid=$pid"
#判断进程
if [ -n "$pid" ];then
	sudo kill -9 $pid
	echo "<--------------start sleep---------------->"
    sleep 6 #休眠6秒
    echo "<--------------finished sleep---------------->"
fi
cd /data/myapp/center-practice/
echo "------------cd after pwd:$PWD"
BUILD_ID=DONTKILLME
sudo nohup java -jar center-practice.jar > /dev/null 2> /dev/null &

#echo "<③--------------start docker build image---------------->"
#docker build  -t $productName .
#echo "<④--------------finished docker build image-------------->"

#echo "<⑤--------------start check app-image-------------------->"
#docker image ls --format '{{.Repository}}:{{.Tag}}' | grep '$productName'
#echo "<⑥--------------finished check app-image----------------->"

#echo "push image to remote ..."
echo "publish finished ..."
