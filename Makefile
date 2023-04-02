up-node:
	docker-compose -f docker-compose.yml -f docker-compose.node.yml up --build

up-python:
	docker-compose -f docker-compose.yml -f docker-compose.python.yml up --build

psql:
	PGPASSWORD=pa55word docker-compose exec -- postgres /usr/local/bin/psql -U admin -d todo_list
