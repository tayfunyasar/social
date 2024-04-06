podman run --name social_database -e POSTGRES_USER=social_username -e POSTGRES_PASSWORD=social_password -e POSTGRES_DB=social_database -p 5531:5432 -v /var/lib/data postgres
