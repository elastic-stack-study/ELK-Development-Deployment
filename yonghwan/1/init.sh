#! /bin/bash

docker pull docker.elastic.co/elasticsearch/elasticsearch:8.9.0
docker pull docker.elastic.co/kibana/kibana:8.9.0
docker network create elastic
docker run --name elasticsearch --net elastic -p 9200:9200 -p 9300:9300 -d \
  -e "discovery.type=single-node" -e "xpack.security.enabled=false" \
  -e "http.cors.allow-origin=\"*\"" \
  -e "http.cors.enabled=true" \
  -t docker.elastic.co/elasticsearch/elasticsearch:8.9.0

docker run --name kibana --net elastic -p 5601:5601 -d docker.elastic.co/kibana/kibana:8.9.0

# python3 es-init.py