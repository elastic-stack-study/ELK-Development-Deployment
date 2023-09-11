#! /bin/bash

echo "[STEP 0] Install Docker"
curl -fsSL https://get.docker.com | sudo sh

echo "[STEP 1] Pulling images"
docker pull docker.elastic.co/elasticsearch/elasticsearch:8.9.0
docker pull docker.elastic.co/kibana/kibana:8.9.0
docker pull docker.elastic.co/logstash/logstash:8.9.0
docker pull bitnami/kafka

echo "[STEP 2] Creating network"
docker network create elastic

echo "[STEP 3] Running containers"
docker run --name elasticsearch --net elastic -p 9200:9200 -p 9300:9300 -d \
  -e "discovery.type=single-node" -e "xpack.security.enabled=false" \
  -e "http.cors.allow-origin=\"*\"" \
  -e "http.cors.enabled=true" \
  -t docker.elastic.co/elasticsearch/elasticsearch:8.9.0 >/dev/null 2>/dev/null

docker run --name kibana --net elastic -p 5601:5601 -d docker.elastic.co/kibana/kibana:8.9.0 >/dev/null 2>/dev/null

docker run --name logstash --net elastic -d docker.elastic.co/logstash/logstash:8.9.0 >/dev/null 2>/dev/null

docker run docker.elastic.co/beats/filebeat:8.9.2 \
setup -E setup.kibana.host=kibana:5601 -E output.elasticsearch.hosts=["elasticsearch:9200"] >/dev/null 2>/dev/null

echo "[STEP 4] Start Kafka"
docker run -d -p 9092:9092 --name kafka --net elastic \
  -e "KAFKA_CFG_NODE_ID=0" -e "KAFKA_CFG_PROCESS_ROLES=controller,broker" -e "KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=0@kafka:9093" \
  -e  bitnami/kafka:latest

