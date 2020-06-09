#!/bin/bash


echo Halting infrastructure
docker-compose -f docker-compose-with-scaling.yml down