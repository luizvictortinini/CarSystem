#!/bin/bash

RABBITMQ_URL="http://localhost:15672"
USERNAME="car"
PASSWORD="car"


create_exchange() {
    curl -i -u $USERNAME:$PASSWORD -H "content-type:application/json" \
    -XPUT $RABBITMQ_URL/api/exchanges/%2F/$1 \
    -d'{"type":"'"$2"'","auto_delete":false,"durable":true,"arguments":{}}'
}


create_queue() {
    curl -i -u $USERNAME:$PASSWORD -H "content-type:application/json" \
    -XPUT $RABBITMQ_URL/api/queues/%2F/$1 \
    -d'{"auto_delete":false,"durable":true,"arguments":{}}'
}


create_binding() {
    curl -i -u $USERNAME:$PASSWORD -H "content-type:application/json" \
    -XPOST $RABBITMQ_URL/api/bindings/%2F/e/$1/q/$2 \
    -d'{"routing_key":"'"$3"'"}'
}


exchanges=("car_system" "car_system_dlq")
queues=("create" "update" "delete" "create_dlq" "update_dlq" "delete_dlq")
bindings=("car_system/create/carsystem.create" "car_system/update/carsystem.update" "car_system/delete/carsystem.delete" "car_system_dlq/create_dlq/carsystem.create_dlq" "car_system_dlq/update_dlq/carsystem.update_dlq" "car_system_dlq/delete_dlq/carsystem.delete_dlq")


for exchange in "${exchanges[@]}"; do
    create_exchange "$exchange" "topic"
done


for queue in "${queues[@]}"; do
    create_queue "$queue"
done


for binding in "${bindings[@]}"; do
    IFS='/' read -ra parts <<< "$binding"
    create_binding "${parts[0]}" "${parts[1]}" "${parts[2]}"
done