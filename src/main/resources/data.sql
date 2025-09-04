-- Insert Users
INSERT INTO users (email, password, name) VALUES 
('john@example.com', '1234', 'John Doe'),
('jane@example.com', 'abcd', 'Jane Smith');

-- Insert Categories
INSERT INTO categories (name) VALUES 
('Food'),
('Transport'),
('Shopping'),
('Bills');

-- Insert Expenses
INSERT INTO expenses (description, amount, date, user_id, category_id) VALUES
('Pizza Order', 500, '2025-09-01', 1, 1),
('Bus Ticket', 50, '2025-09-02', 1, 2),
('Amazon Purchase', 1500, '2025-09-02', 2, 3),
('Electricity Bill', 2000, '2025-09-03', 2, 4);
