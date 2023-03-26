up-node:
	docker-compose -f docker-compose.yml -f docker-compose.node.yml up --build

down:
	docker-compose -f docker-compose.yml down

psql:
	PGPASSWORD=pa55word docker-compose exec -- postgres /usr/local/bin/psql -U admin -d todo_list
