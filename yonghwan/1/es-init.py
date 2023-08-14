from elasticsearch import helpers, Elasticsearch
import csv
from os import environ

ELASTIC_PASSWORD = environ['ELASTIC_PASSWORD']

document = {
    "mappings": {
        "dynamic": False,
        "properties": {
            "date": {"type": "date"},
            "headline": {
                "type": "text"
            },
            "description": {
                "type": "text"
            }
        }
    }
}

es = Elasticsearch("http://localhost:9200")

if es.indices.exists(index='news'):
    es.indices.delete(index='news')
else:
    es.indices.create(index='news', body=document)

with open('cnn-headlines.csv') as f:
    reader = csv.DictReader(f)
    helpers.bulk(es, reader, index='news')