echo "<< docker-compose -f docker-compose-base.yml  up >>"

docker kill $(docker ps -aq)
docker-compose kill
docker-compose up --build
