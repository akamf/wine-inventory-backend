#!/bin/bash

set -a
source .env
set +a

cat <<EOF > docker/mongo-init.js
db = db.getSiblingDB('${MONGO_APP_DATABASE}');

db.createUser({
    user: '${MONGO_APP_USER}',
    pwd: '${MONGO_APP_PASSWORD}',
    roles: [
        {
            role: 'readWrite',
            db: '${MONGO_APP_DATABASE}'
        }
    ]
});
EOF

echo "✅ mongo-init.js generated in docker/"