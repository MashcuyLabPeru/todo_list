up-node:
	docker-compose -f docker-compose.yml -f docker-compose.node.yml up --build

up-java:
	mvn -f java-backend/ package
	docker-compose -f docker-compose.yml -f docker-compose.java.yml up --build

psql:
	PGPASSWORD=pa55word docker-compose exec -- postgres /usr/local/bin/psql -U admin -d todo_list
