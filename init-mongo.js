// init-mongo.js
db = db.getSiblingDB(process.env.MONGO_INITDB_DATABASE || 'myapp_db');

db.createUser({
  user: 'app_user',
  pwd: 'app_password',
  roles: [{ role: 'readWrite', db: process.env.MONGO_INITDB_DATABASE }]
});

// Colección de prueba inicial
db.createCollection('health_check');
db.health_check.insertOne({
  status: 'ok',
  timestamp: new Date()
});

print('MongoDB inicializado correctamente.');