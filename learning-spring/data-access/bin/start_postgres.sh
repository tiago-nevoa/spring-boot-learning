#!/usr/bin/env bash

set -euo pipefail

# Check if psql command is available
if ! command -v psql &> /dev/null; then
    echo "Please ensure that the postgres client is in your PATH"
    exit 1
fi

# Set the directory for storing Postgres data
POSTGRES_DATA_DIR="$HOME/docker/volumes/postgres"

# Remove the existing data directory
rm -rf "$POSTGRES_DATA_DIR/data"

# Start the Postgres container
docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5432:5432 -v "$POSTGRES_DATA_DIR:/var/lib/postgresql" postgres

# Wait for the container to start
sleep 3

# Set the password for connecting to the database
export PGPASSWORD=postgres

# Run the schema.sql script
psql -U postgres -d dev -h localhost -f schema.sql

# Run the data.sql script
psql -U postgres -d dev -h localhost -f data.sql
