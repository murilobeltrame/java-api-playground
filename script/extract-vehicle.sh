current_dir=$(pwd)

cd ./src/vehicle-api

./mvnw clean install spring-boot:run -Dmaven.test.skip=true &

spring_boot_pid=$!

echo "... waiting for Spring Boot application to start ..."
while true; do
    curl -s http://localhost:9999/api-docs && break
    sleep 5
done

echo " ... downloading API docs ... "
curl -o vehicle-docs.json http://localhost:9999/api-docs

kill $spring_boot_pid
cd $current_dir