import jwt
import datetime
from flask import Flask, jsonify, request
from flask_sqlalchemy import SQLAlchemy
import os

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///food_app.db'
app.config['SECRET_KEY'] = 'super-secret-key'
db = SQLAlchemy(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(40), unique=True)
    password = db.Column(db.String(128))

class Product(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80))
    price = db.Column(db.Float)

class Order(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    user_id = db.Column(db.Integer)
    items = db.Column(db.String(255))

@app.route('/login', methods=['POST'])
def login():
    auth = request.json
    if auth.get('username') == 'admin' and auth.get('password') == '123':
        token = jwt.encode({'user': auth['username'], 'exp': datetime.datetime.utcnow() + datetime.timedelta(hours=24)}, app.config['SECRET_KEY'])
        return jsonify({'token': token})
    return jsonify({'message': 'Invalid'}), 401

@app.route('/api/v1/orders', methods=['POST'])
def place_order():
    data = request.json
    order = Order(user_id=data['user_id'], items=str(data['items']))
    db.session.add(order)
    db.session.commit()
    return jsonify({'message': 'Order placed'}), 201

@app.route('/api/v1/profit/calculate', methods=['POST'])
def calculate_profit():
    # Example: 10% of total revenue
    return jsonify({'total_profit': 1000.0}) 

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
    app.run(port=5000)