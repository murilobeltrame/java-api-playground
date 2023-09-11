current_dir=$(pwd)

cd ./src/company-api

./mvnw clean install spring-boot:run -Dmaven.test.skip=true &

spring_boot_pid=$!

echo "... waiting for Spring Boot application to start ..."
while true; do
    curl -s http://localhost:9998/api-docs && break
    sleep 5
done

echo " ... downloading API docs ... "
curl -o company-docs.json http://localhost:9998/api-docs

kill $spring_boot_pid
cd $current_dir